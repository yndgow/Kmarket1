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
      $('input:checkbox[name=noticeCheck]').prop('checked', true);
    } else {
      $('input:checkbox[name=noticeCheck]').prop('checked', false);
    }
  });

  // 개별 체크박스 해제시 전체 체크박스 표시 해제
  $('input:checkbox[name=noticeCheck]').click(function () {
    let checked = $('input:checkbox[name=all]').is(':checked');
    if (checked) $('input:checkbox[name=all]').prop('checked', false);
  });
  // delete notice
  $('.btnDeleteNot').click(function (e) {
    if (!confirm('삭제하시겠습니까?')) {
      return false;
    } else {
      let notNo = $('input[name=notNo]').val();
      if (!notNo) {
        notNo = e.target.id;
      }

      $.ajax({
        url: '/Kmarket/admin/cs/notice/delete.do',
        type: 'get',
        data: { notNo: notNo },
        dataType: 'json',
        success: function (data) {
          if (data.result > 0) {
            location.href = '/Kmarket/admin/cs/notice/list.do';
          }
        },
      });
    }
  });
  // list notice
  $('.btnList').click(function () {
    location.href = '/Kmarket/admin/cs/notice/list.do';
  });
  // write notice
  $('.btnWriteNotice').click(function(){
	let cate1 = $('select[name=cate1]').val();
	location.href = '/Kmarket/admin/cs/notice/write.do?cate1='+cate1;
  });
  // cancle notice 
  $('.btnCancle').click(function(){
	 history.back(); 
  });
  

  // btnModifyNot
  $('.btnModifyNot').click(function (e) {
    e.preventDefault();
    let notNo = $('input[name=notNo]').val();
    notNo = e.target.id;
    location.href = '/Kmarket/admin/cs/notice/modify.do?notNo=' + notNo;
  });

  // btnModNotice
  $('.btnModNotice').click(function (e) {
    e.preventDefault();
    let cate1 = $('select[name=cate1]').val();
    let title = $('#title').val();
    let content = $('#content').val();
    if (cate1 == 0 || !title.trim() || !content.trim()) {
      alert('카테고리, 제목, 내용을 확인하세요.');
      return false;
    } else {
      $('#noticeModifyForm').submit();
    }
  });

  // admin cs write notice
  $('.btnSubmitNotice').click(function (e) {
    e.preventDefault();
    let cate1 = $('select[name=cate1]').val();
    let title = $('#title').val();
    let content = $('#content').val();
    if (cate1 == 0 || !title.trim() || !content.trim()) {
      alert('카테고리, 제목, 내용을 확인하세요.');
      return false;
    } else {
      $('#noticeWriteForm').submit();
    }
  });

  // cate1 change
  $('#selNot').on('change', function () {
    let cate1 = $(this).val();
    location.href = '/Kmarket/admin/cs/notice/list.do?cate1=' + cate1;
  });

  // check delete notice
  $('.btnDeleteSelectedNot').click(function () {
    if ($('input[name=noticeCheck]:checked').length == 0) {
      alert('선택된 글이 없습니다.');
      return false;
    }

    let arrNo = [];
    let chkArr = document.querySelectorAll('input[name=noticeCheck]');
    for (let i = 0; i < chkArr.length; i++) {
      if (chkArr[i].checked == true) arrNo.push(chkArr[i].value);
    }
    if (confirm('선택된 글을 삭제하시겠습니까?')) {
      $.getJSON('/Kmarket/admin/cs/notice/delete.do', { arrNo: arrNo }, function (data) {
        if (data.result > 0) {
          $('input[name=noticeCheck]:checked').parents('tr').remove();
        }
      });
    }
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
