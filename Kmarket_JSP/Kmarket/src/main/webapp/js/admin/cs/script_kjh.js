$(() => {

  let csType = $('input[name=csType]').val();
  $('.btnWriteNotice').click(() => {
    location.href = '/Kmarket/admin/cs/write.do?csType=' + csType;
  });

  const url = '/Kmarket/admin/cs/cate.do?csType=' + csType;

  //csCate1Load(url);
  //if (csType == 'notice') $('select[name=cate2]').remove();
  // 카테고리 1번 리스트 출력 함수 김지홍
  //cate1List();

  $('select[name=cate1]').on('change', function (e) {
    e.preventDefault();
    $('select[name=cate2]').empty();
    let cate1 = $(this).val();
    let content = `<option value="0">2차유형</option>`;
    if (cate1 == '0') {
		$('select[name=cate2]').append(content);
		return false;
    }
    let url1 = url + '&cate1=' + cate1;
    content += ajaxload(url1);
    $('select[name=cate2]').append(content);
  });

});

// 사용 x
function csCate1Load(url) {
  $('select[name=cate1]').empty();
  let url1 = url + '&cate=1';
  let content = `<option value="0">1차유형</option>`;
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