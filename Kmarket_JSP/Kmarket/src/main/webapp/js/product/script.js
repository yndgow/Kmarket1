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
        if (confirm('장바구니에 담겼습니다. 이동하시겠습니까?')) {
          let jsonData = {
            prodNo: $('.prodNo').text(),
            uid: $('.sessUser_uid').text(),
            count: $('input[name=num]').val(),
          };
          console.log(jsonData);
          jsonData = JSON.stringify(jsonData);
          $.ajax({
            type: 'post',
            url: '/Kmarket/product/cart.do',
            data: jsonData,
            dataType: 'json',
            success: function (data) {
              if(data.result > 0) location.href = '/Kmarket/product/cart.do';
            },
          });
        }
      } else if (btnClassName == 'btnBuy') {
        location.href = '/Kmarket/product/order.do?prodNo=' + $('.prodNo').text();
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
            <li><h3>상품명1/BLUE/L</h3></li>
            <li>${element.content}</li>
          </ul>`;
        });
        $('.review').append(content);
      },
    });
  });
});

// 함수 모음
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
