$(() => {
  // 서브카테고리
  subCategoryShowHide();

  // 수량증가 버튼
  $('.incrBtn, .descBtn').click(function () {
    amountBtn($(this).attr('class'));
  });

  // 분류 글자 진하게
  sortAddClass();

  // 장바구니, 구매하기 버튼 이벤트
  $('.btnCart, .btnBuy').click(function () {
    if (loginCheck()) {
      let btnClassName = $(this).attr('class');
      if (btnClassName == 'btnCart') {
        // 장바구니 클릭시
        let jsonData = {
          uid: $('.sessUser_uid').text(),
          prodNo: $('input[name=prodNo').val(),
          count: $('input[name=num]').val(),
          price: $('input[name=ori_price]').val(),
          discount: $('input[name=discount]').val(),
          delivery: $('input[name=delivery]').val(),
        };

        $.ajax({
          type: 'post',
          url: '/Kmarket/product/view.do',
          data: jsonData,
          dataType: 'json',
          success: function (data) {
            if (data.result > 0 && confirm('장바구니에 담겼습니다. 이동하시겠습니까?')) {
              location.href = '/Kmarket/product/cart.do?uid=' + $('.sessUser_uid').text();
            }
          },
        });
      } else if (btnClassName == 'btnBuy') {
        // 구매하기 클릭시
        let uid = $('.sessUser_uid').text();
        let prodNo = $('input[name=prodNo').val();
        let price = Number($('input[name=ori_price]').val());
        let count = $('input[name=num]').val();
        let discount = Number($('input[name=discount]').val());
        let discountPrice = Math.floor((price * discount) / 100);
        let delivery = Number($('input[name=delivery]').val());
        let point = Math.ceil(((price * (100 - discount)) / 100) * count * 0.01);
        let total = Math.ceil(((price * (100 - discount)) / 100) * count) + delivery;
        let jsonData = {
          uid: uid,
          prodNo: prodNo,
          cartCount: count,
          cartPrice: price,
          cartDiscount: discountPrice,
          cartDelivery: delivery,
          cartPoint: point,
          cartTotal: total,
        };

        $.ajax({
          type: 'post',
          url: '/Kmarket/product/cart.do',
          data: jsonData,
          dataType: 'json',
          success: function (data) {
            if (data.result > 0) {
              location.href = `/Kmarket/product/order.do?uid=${uid}&prodNo=${prodNo}&count=${count}`;
            }
          },
        });
      }
    }
  });

  // 장바구니 주문하기 버튼 이벤트
  $('input[name=cartOrder]').click(function (e) {
    e.preventDefault();
    if ($('input[name=cartProduct]').is(':checked') == false) {
      alert('상품이 선택되지 않았습니다');
      return false;
    } else {
      if (confirm('주문하시겠습니까?')) {
        $('#cartForm').submit();
      } else {
        return false;
      }
    }
  });

  // 상품평 페이징 ajax
  $('.paging a').on('click', function (e) {
    e.preventDefault();
    $.ajax({
      url: $(this).attr('href'),
      dataType: 'json',
      success: function (data) {
        let content = '';
        $('.review > ul').remove();
        data.forEach((element) => {
          content += `<ul>
            <li>
              <div>
                <h5 class="star2-${element.rating}"></h5>
                <p class="ordUid">${element.uid}<span class="ordDate">${element.rdate}</span></p>
              </div>
            </li>
            <li><h3>${element.prodName}</h3></li>
            <li>${element.content}</li>
          </ul>`;
        });
        $('.review').append(content);
      },
    });
  });
  // 체크박스 이벤트
  // 체크박스 전체 체크 또는 해제
  $('input:checkbox[name=all]').click(function () {
    let checked = $(this).is(':checked');
    if (checked) {
      $('input:checkbox[name=cartProduct]').prop('checked', true);
      cartCheckTotal();
    } else {
      $('input:checkbox[name=cartProduct]').prop('checked', false);
      cartCheckTotal();
    }
  });

  // 개별 체크박스 해제시 전체 체크박스 표시 해제
  $('input:checkbox[name=cartProduct]').click(function () {
    let checked = $('input:checkbox[name=all]').is(':checked');
    if (checked) $('input:checkbox[name=all]').prop('checked', false);
    cartCheckTotal();
  });

  // 선택삭제
  $('input[name=del]').click(function () {
    if ($('input[name=cartProduct]:checked').length == 0) {
      alert('선택된 상품이 없습니다.');
      return false;
    }

    let cartNo = [];
    $('input[name=cartProduct]:checked').each(function () {
      cartNo.push($(this).val());
    });

    if (confirm('선택된 상품을 삭제하시겠습니까?')) {
      $.ajax({
        type: 'post',
        url: '/Kmarket/product/cartDelete.do',
        data: { cartNo: cartNo },
        dataType: 'json',
        success: function (data) {
          if (data.result > 0) {
            $('input[name=cartProduct]:checked').parents('tr').remove();
            if ($('input[name=cartProduct]').length == 0) {
              let content = `<tr class="empty">
                <td colspan="7">장바구니에 상품이 없습니다.</td>
              </tr>`;
              $('.cart table').append(content);
              $('.total').hide();
              $('input[name=del]').hide();
              $('input:checkbox[name=all]').prop('checked', false);
            }
          }
        },
      });
    }
  });

  // 장바구니에서 오더로 체크한 상품만 보내기
  /*$('input[name=cartOrder]').click(function (e) {
	e.preventDefault();
  });*/

  // 주소 다음 api 불러오기
  $('.btnZip').click(function () {
    execDaumPostcode();
  });

  // 포인트
  let point = Number($('input[name=point]').val());

  // 5000 이하면 사용불가
  if (point < 5000) {
    $('input[name=usedPoint]').css('background-color', '#e9e9e9');
    $('input[name=usedPoint]').prop('readonly', true);
    $('.pointApplyBtn').prop('disabled', true);
  } else {
    // 가진 포인트보다 많이 입력하면 최대치로
    $('input[name=usedPoint]').keyup(function () {
      let maxPoint = Number($('input[name=usedPoint]').val());
      if (maxPoint > point) {
        $('input[name=usedPoint]').val(point);
      }
    });

    // 전체합계로 숫자 보내기
    $('.pointApplyBtn').click(function () {
      let sendPoint = $('input[name=usedPoint]').val();
      if (sendPoint == '' || sendPoint == 0) {
        $('input[name=usedPoint]').val(0);
        $('#aUsedPoint').text(0);
      } else {
        let resultPoint = 0;
        $('#aUsedPoint').text(sendPoint);
        let total = Number($('input[name=ordTotPrice]').val());
        if (sendPoint > total) {
          $('#aTotalPrice').text(0);
          $('input[name=ordTotPrice]').val(0);
          $('#aUsedPoint').text(total);
          $('input[name=usedPoint]').val(total);
          resultPoint = point - total;
        } else {
          $('#aTotalPrice').text(total - sendPoint);
          $('input[name=ordTotPrice]').val(total - sendPoint);
          resultPoint = point - sendPoint;
        }
        $('#cur_point').text('현재 포인트 : ' + resultPoint + '점');
        alert('포인트가 적용되었습니다.');
      }
    });
  }

  // 주문 입력 유효성 검증
  $('#btnPayment').click(function (e) {
    e.preventDefault();
    orderValidation();
  });
});

///////////////
///함수 모음///
//////////////

// 장바구니에서 오더로 체크한 상품만 보내기 사용 X
function checkedOrder() {
  console.log('test');
  // 리스트 생성
  let list = new Array();
  $('input[name=cartProduct]:checked').each(function () {
    // 객체 생성
    let prod = new Object();
    prod.prodNo = $(this).siblings('input[name=prodNo]').val();
    prod.count = $(this).parent().siblings('.count').text();
    prod.price = $(this).parent().siblings('.price').text();
    prod.discount = $(this).parent().siblings('.discount').text();
    prod.point = $(this).parent().siblings('.point').text();
    prod.delivery = $(this).parent().siblings('.delivery').text();
    prod.total = $(this).parent().siblings('.total').text();
    list.push(prod);
  });
  //JSON.stringify(list);
  console.log($('#cartForm').serialize());

  $.ajax({
    type: 'post',
    url: '/Kmarket/product/cart.do',
    //tranditional: true,
    data: $('#cartForm').serialize(),
    dataType: 'json',
    success: function (data) {
      console.log(data);
    },
  });
}

// 서브 카테고리 보이기
function subCategoryShowHide() {
  for (let i = 2; i <= 10; i++) {
    $('.category > li:nth-child(' + i + ')').on('mouseover', () => {
      $('.category li:nth-child(' + i + ') > ol:nth-of-type(1)').css('visibility', 'visible');
    });
  }
  $('#menu > li').on('mouseout', () => {
    $('.category li > ol').css('visibility', 'hidden');
  });
  $('.sub_categori').on('mouseover', () => {
    $(this).css('visibility', 'visible');
  });
}
// 수량 증가 버튼
function amountBtn(amountBtnClassName) {
  let num = $('input[name=num]').val();
  num = Number(num);
  if (amountBtnClassName == 'incrBtn') {
    if (num < 100) num += 1;
  } else {
    if (num > 1) num -= 1;
  }

  $('input[name=num]').val(num);
  let curPrice = $('.cur_price').text();
  curPrice = curPrice.split('원', '1')[0];
  curPrice = stringNumberToInt(curPrice);
  let totalPrice = num * curPrice;
  totalPrice = AddComma(totalPrice);
  $('.view_total_price > p > span').text(totalPrice + '원');
}

// 분류 글자 진하게 주기
function sortAddClass() {
  let href = $(location).attr('href');
  let listSort = ['soldDesc', 'priceAsc', 'priceDesc', 'scoreDesc', 'reviewDesc', 'rdateDesc'];
  for (let i = 0; i < listSort.length; i++) {
    if (href.match(listSort[i]) != null) {
      let n = i + 1;
      $('.sort > li:nth-child(' + n + ') > a').addClass('on');
    }
  }
  if (!href) $('.sort > li:nth-child(1) > a').addClass('on');
}
// 문자열 숫자 콤마 제거
function stringNumberToInt(stringNumber) {
  return parseInt(stringNumber.replace(/,/g, ''));
}
// 문자열 숫자 콤마 추가
function AddComma(data_value) {
  return Number(data_value).toLocaleString('en');
}
// 로그인 체크, 장바구니, 구매하기
function loginCheck() {
  let session = $('.sessUser_uid').text();
  if (session == '') {
    if (confirm('로그인하셔야 이용가능합니다. 로그인 페이지로 이동하시겠습니까?')) {
      location.href = '/Kmarket/member/login.do?prodNo=' + $('.prodNo').text();
    }
    return false;
  } else {
    return true;
  }
}
// 가격에서 , 원을 떼고 숫자로 만들기
function removeCommaWon(price) {
  let pricetxt = $('.' + price).text();
  pricetxt = pricetxt.split('원', '1')[0];
  let priceNum = stringNumberToInt(pricetxt);
  return priceNum;
}
// 전체합계
function cartCheckTotal() {
  let totalPrice = 0;
  let totalDiscount = 0;
  let totalDelivery = 0;
  let totalPoint = 0;
  let totalSum = 0;

  let cartCheck = $('input[name=cartProduct]:checked');
  // 상품수
  $('#cartCount').text(cartCheck.length);

  $('input[name=cartProduct]:checked').each(function () {
    totalPrice += Number($(this).parent().siblings('.price').text()); // 상품금액
    totalDiscount -= Math.ceil(Number(($(this).parent().siblings('.discount').text() / 100) * $(this).parent().siblings('.price').text()));
    totalDelivery += Number($(this).parent().siblings('.delivery').text());
    totalPoint += Number($(this).parent().siblings('.point').text());
    totalSum += Number($(this).parent().siblings('.total').text());
  });
  // 보여주는 데이터
  $('#cartPrice').text(totalPrice);
  $('#cartDiscount').text(totalDiscount);
  $('#cartDelivery').text(totalDelivery);
  $('#cartPoint').text(totalPoint);
  $('#cartTotal').text(totalSum);
  // form 전송을 위한 데이터 입력
  $('input[name=cartCount]').val(cartCheck.length);
  $('input[name=cartPrice]').val(totalPrice);
  $('input[name=cartDiscount]').val(totalDiscount);
  $('input[name=cartDelivery]').val(totalDelivery);
  $('input[name=cartPoint]').val(totalPoint);
  $('input[name=cartTotal]').val(totalSum);
}

// 주소 API
function execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 각 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var addr = ''; // 주소 변수
      var extraAddr = ''; // 참고항목 변수

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === 'R') {
        // 사용자가 도로명 주소를 선택했을 경우
        addr = data.roadAddress;
      } else {
        // 사용자가 지번 주소를 선택했을 경우(J)
        addr = data.jibunAddress;
      }

      // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
      if (data.userSelectedType === 'R') {
        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        // 건물명이 있고, 공동주택일 경우 추가한다.
        if (data.buildingName !== '' && data.apartment === 'Y') {
          extraAddr += extraAddr !== '' ? ', ' + data.buildingName : data.buildingName;
        }
        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
        if (extraAddr !== '') {
          extraAddr = '(' + extraAddr + ')';
        }
        // 조합된 참고항목을 해당 필드에 넣는다.
        document.getElementById('addr2').value = extraAddr;
      } else {
        document.getElementById('addr2').value = '';
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById('zip').value = data.zonecode;
      document.getElementById('addr1').value = addr;
      // 커서를 상세주소 필드로 이동한다.
      document.getElementById('addr2').focus();

      document.getElementById('zip').setAttribute('readonly', true);
      document.getElementById('addr1').setAttribute('readonly', 'true');
    },
  }).open();
}
// 주문 유효성 검증 체크
function orderValidation() {
  let nameReg = /^[가-힣]{2,10}$/;
  let hpReg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
  let addr2Reg = /^[가-힣0-9\(\)\-\s]{3,15}$/;

  let nameInput = $('input[name=name]').val();
  let hpInput = $('input[name=hp]').val();
  let addr2 = $('input[name=addr2]').val();
  let payment = $('input[name=payments]').val();

  let nameCheck = false;
  let hpCheck = false;
  let addr2Check = false;
  let paymentCheck = false;

  nameCheck = !nameReg.test(nameInput) ? false : true;
  hpCheck = !hpReg.test(hpInput) ? false : true;
  addr2Check = !addr2Reg.test(addr2) ? false : true;
  paymentCheck = payment == '' ? false : true;

  if (!nameCheck) {
    alert('이름을 확인하세요 2~10자');
    return false;
  }
  if (!hpCheck) {
    alert('전화번호를 확인하세요.');
    return false;
  }
  if (!addr2Check) {
    alert('상세주소를 입력하세요. 3~15자');
    return false;
  }
  if (!paymentCheck) {
    alert('결제방법을 선택하세요.');
    return false;
  }
  if (confirm('아래 정보로 결제하시겠습니까?')) {
    $('.order_info').submit();
  } else {
    alert('결제가 취소되었습니다.');
  }
}
