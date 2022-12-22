$(() => {
  var gnb = $('#gnb > li > a');
  gnb.click(function (e) {
    e.preventDefault();
    var isOpen = $(this).next().is(':visible');

    if (isOpen) {
      $(this).next().slideUp(200);
    } else {
      $(this).next().slideDown(200);
    }
  });

  // 카테고리 1번 리스트 출력 함수 김지홍
  //cate1List();

  // 체크박스 전체 체크 또는 해제
  $('input:checkbox[name=all]').click(function () {
    let checked = $(this).is(':checked');
    if (checked) {
      $('input:checkbox[name=faqCheck]').prop('checked', true);
    } else {
      $('input:checkbox[name=faqCheck]').prop('checked', false);
    }
  });

  // 개별 체크박스 해제시 전체 체크박스 표시 해제
  $('input:checkbox[name=faqCheck]').click(function () {
    let checked = $('input:checkbox[name=all]').is(':checked');
    if (checked) $('input:checkbox[name=all]').prop('checked', false);
  });
});
// 카테고리 1 호출
function cate1List() {
  $.ajax({
    url: '/Kmarket/cs/notice/cate.do',
    dataType: 'json',
    success: (data) => {
      let cate1 = $('select[name=cate1]');
      cate1.children().remove();
      let tag = `<option value="0">유형선택</option>`;
      data.forEach((e) => {
        tag += `<option value="/Kmarket/admin/cs/notice/list.do?cate1=${e.cate1}">${e.c1Name}</option>`;
      });
      cate1.append(tag);
    },
  });
}
