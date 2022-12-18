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

  let csType = $('input[name=csType]').val();
  $('.btnWriteNotice').click(() => {
    location.href = '/Kmarket/admin/cs/write.do?csType=' + csType;
  });

  const url = '/Kmarket/admin/cs/cateList.do?csType=' + csType;

  csCate1Load(url);
  if (csType == 'notice') $('select[name=cate2]').remove();

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

  $('select[name=cate1]').on('change', function (e) {
    e.preventDefault();
    $('select[name=cate2]').empty();
    let cate1 = $(this).val();
    let content = `<option value="none">2차유형</option>`;
    if (cate1 == 'none') {
		$('select[name=cate2]').append(content);
		return false;
    }
    let url2 = url + '&cate=2&cate1=' + cate1;
    content += ajaxload(url2);
    $('select[name=cate2]').append(content);
  });
});

function csCate1Load(url) {
  $('select[name=cate1]').empty();
  let url1 = url + '&cate=1';
  let content = `<option value="none">1차유형</option>`;
  content += ajaxload(url1);
  $('select[name=cate1]').append(content);
}

function ajaxload(url) {
  let content = '';
  $.ajax({
    url: url,
    dataType: 'json',
    async: false,
    success: function (data) {
      data.forEach((e) => {
        if (e.c2Name == undefined) {
          content += `<option value=${e.cate1}>${e.c1Name}</option>`;
        } else {
          content += `<option value=${e.cate2}>${e.c2Name}</option>`;
        }
      });
    },
  });
  return content;
}
