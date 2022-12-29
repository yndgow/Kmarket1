$(() => {
  let csType = $('input[name=csType]').val();
  $('.btnWriteCs').click(() => {
    csType = $('input[name=csType]').val();
    let cate1 = $('select[name=cate1]').val();
    let cate2 = $('select[name=cate2]').val();

    location.href = '/Kmarket/admin/cs/write.do?csType=' + csType + '&cate1=' + cate1 + '&cate2=' + cate2;
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

  // list load ajax X -> resp
  $('.cate2').on('change', function () {
    let cate1Val = $('select[name=cate1]').val();
    let cate2Val = $(this).val();
    //adminCsList(cate2Val);
    if (csType == 'qna') {
      location.href = '/Kmarket/admin/cs/qna/list.do?csType=' + csType + '&cate1=' + cate1Val + '&cate2=' + cate2Val;
    } else {
      location.href = '/Kmarket/admin/cs/faq/list.do?csType=' + csType + '&cate1=' + cate1Val + '&cate2=' + cate2Val;
    }
  });

  // btnCancle
  $('.btnCancle').click(function (e) {
    e.preventDefault();
    history.back();
  });

  // btnWrite
  $('.btnWriteFaq').click(function (e) {
    e.preventDefault();
    let title = $('#title').val();
    let content = $('#content').val();
    if (!title.trim() || !content.trim()) {
      alert('제목과 내용을 작성해주세요.');
      return false;
    }

    let cate1 = $('select[name=cate1]').val();
    let cate2 = $('select[name=cate2]').val();
    let jsonData = { cate1: cate1, cate2: cate2 };
    let count = 0;
    $.ajax({
      url: '/Kmarket/admin/cs/faq/listCate2Count.do',
      data: jsonData,
      dataType: 'json',
      async: false,
      success: function (data) {
        count = data.result;
      },
    });
    if (count >= 10) {
      alert('2차유형당 최대갯수는 10개입니다.');
      return false;
    }
    if (confirm('자주묻는질문을 등록하시겠습니까?')) {
      $('#faqForm').submit();
    }
    return false;
  });

  // write page category set

  // qna update answer
  $('.btnUpdQna').click(function (e) {
    e.preventDefault();
    let answer = $('#content').val();
    let qnaNo = $('input[name=qnaNo]').val();
    let cate1 = $('input[name=wriCate1]').val();
    let cate2 = $('input[name=wriCate2]').val();

    let jsonData = { answer: answer, qnaNo: qnaNo };
    $.ajax({
      type: 'post',
      url: '/Kmarket/admin/cs/qna/update.do',
      data: jsonData,
      dataType: 'json',
      success: function (data) {
        if (data.result > 0) {
          location.href = '/Kmarket/admin/cs/qna/list.do?csType=qna&cate1=' + cate1 + '&cate2=' + cate2;
        }
      },
    });
  });

  // qna update del
  $('.btnDelQna').click(function (e) {
    e.preventDefault();
    if (!confirm('삭제하시겠습니까?')) {
      return false;
    }
    let qnaNo = $('input[name=qnaNo]').val();
    let cate1 = $('input[name=wriCate1]').val();
    let cate2 = $('input[name=wriCate2]').val();
    $.getJSON(`/Kmarket/admin/cs/delete.do?qnaNo=${qnaNo}`, function (data) {
      if (data.result > 0) {
        location.href = '/Kmarket/admin/cs/qna/list.do?csType=qna&cate1=' + cate1 + '&cate2=' + cate2;
      } else {
        alert('삭제 실패하였습니다.');
      }
    });
  });

  // back to list
  $('.btnList').click(function (e) {
    e.preventDefault();
    let cate1 = $('input[name=wriCate1]').val();
    let cate2 = $('input[name=wriCate2]').val();
    let csType = $('input[name=csType]').val();
    location.href = '/Kmarket/admin/cs/' + csType + '/list.do?csType=' + csType + '&cate1=' + cate1 + '&cate2=' + cate2;
  });

  // cate 1 cate 2 set
  setCategoryValue();

  // 선택삭제
  $('.btnDeleteSelected').click(function () {
    if ($('input[name=faqCheck]:checked').length == 0) {
      alert('선택된 글이 없습니다.');
      return false;
    }

    let arrNo = [];
    $('input[name=faqCheck]:checked').each(function () {
      arrNo.push($(this).val());
    });
    const url1 = new URL(window.location.href);
    const urlParams = url1.searchParams;
    let csType = urlParams.get('csType');
    let url2 = '/Kmarket/admin/cs/delete.do?csType=' + csType;

    if (confirm('선택된 글을 삭제하시겠습니까?')) {
      $.ajax({
        type: 'post',
        url: url2,
        data: { arrNo: arrNo },
        dataType: 'json',
        success: function (data) {
          if (data.result > 0) {
            $('input[name=faqCheck]:checked').parents('tr').remove();
          }
        },
      });
    }
  });

  // delete faq
  $('.btnDeleteFaq').click(function (e) {
    e.preventDefault();
    if (!confirm('삭제하시겠습니까?')) {
      return false;
    }
    let url = $(this).attr('href');
    if (!url) {
      let faNo = $('input[name=faNo]').val();
      url = '/Kmarket/admin/cs/delete.do?faNo=' + faNo;
    }
    let cate1 = $('input[name=wriCate1]').val();
    let cate2 = $('input[name=wriCate2]').val();
    $.getJSON(url, function (data) {
      if (data.result > 0) {
        location.href = '/Kmarket/admin/cs/faq/list.do?csType=faq&cate1=' + cate1 + '&cate2=' + cate2;
      } else {
        alert('삭제 실패하였습니다.');
      }
    });
  });
  // move faq modify
  $('.btnModifyFaq').click(function (e) {
    e.preventDefault();
    let faNo = $('input[name=faNo]').val();
    let cate1 = $('input[name=wriCate1]').val();
    let cate2 = $('input[name=wriCate2]').val();
    location.href = '/Kmarket/admin/cs/faq/modify.do?csType=faq&cate1=' + cate1 + '&cate2=' + cate2 + '&faNo=' + faNo;
  });
  // update faq submit
  $('.btnSubmitNotice').click(function (e) {
    e.preventDefault();
    let title = $('input[name=title]').val();
    let content = $('textarea[name=content]').val();
    if (!title.trim() || !content.trim()) {
      alert('제목과 내용을 확인하세요.');
      return false;
    } else {
      $('#faqForm').submit();
    }
  });
});

//// 함수모음 ////
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

// admin cs list
function adminCsList(cate2Val) {
  $('table.cs').empty();
  $('.paging').empty();
  let cate1 = $('select[name=cate1]').val();
  let cate2 = cate2Val;
  let csType = $('input[name=csType]').val();
  $.ajax({
    type: 'get',
    url: '/Kmarket/admin/cs/list.do',
    data: { cate1: cate1, cate2: cate2, csType: csType },
    dataType: 'json',
    success: function (data) {
      let content = '';
      if (csType == 'faq') {
        content += `
        <tr>
          <th><input type="checkbox" name="all"></th>
          <th>번호</th>
          <th>1차유형</th>
          <th>2차유형</th>
          <th>제목</th>
          <th>조회</th>
          <th>날짜</th>
          <th>관리</th>
        </tr>`;
        data.forEach((e) => {
          content += `<tr>
          <td><input type="checkbox" name="faqCheck"></td>
          <td>${e.faNo}</td>
          <td class="c1NameTd">${e.c1Name}</td>
          <td class="c2NameTd">${e.c2Name}</td>
          <td><a href="/Kmarket/admin/cs/view.do?no=${e.faNo}&csType=${csType}&cate1=${e.cate1}&cate2=${e.cate2}">${e.faTitle}</a></td>
          <td>${e.hit}</td>
          <td>${e.rdate}</td>
          <td>
            <a href="/Kmarket/admin/cs/delete.do?faNo=${e.faNo}" class="btnDeleteNotice">[삭제]</a>
            <a href="/Kmarket/admin/cs/modify.do?faNo=${e.faNo}" class="btnModifyNotice">[수정]</a>
          </td>
        </tr>`;
        });
      } else if (csType == 'qna') {
        content += `
        <tr>
          <th><input type="checkbox" name="all"></th>
          <th>번호</th>
          <th>1차유형</th>
          <th>2차유형</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>상태</th>
        </tr>`;
        data.forEach((e) => {
          content += `<tr>
          <td><input type="checkbox" name="faqCheck"></td>
          <td>${e.qnaNo}</td>
          <td class="c1NameTd">${e.c1Name}</td>
          <td class="c2NameTd">${e.c2Name}</td>
          <td><a href="/Kmarket/admin/cs/view.do?no=${e.qnaNo}&csType=${csType}&cate1=${e.cate1}&cate2=${e.cate2}">${e.qnaTitle}</a></td>
          <td>${e.uid}</td>
          <td>${e.rdate}</td>
          <td>${e.qnaCond}</td>
        </tr>`;
        });
      }
      $('.cs').append(content);
    },
  });
}

function setCategoryValue() {
  const url = new URL(window.location.href);
  const urlParams = url.searchParams;

  let cate1 = urlParams.get('cate1');
  let cate2 = urlParams.get('cate2');
  let csType = urlParams.get('csType');
  if (!cate1 && !cate2) {
    if (url.pathname == '/Kmarket/admin/cs/qna/list.do') {
      cate1 = 0;
      cate2 = 0;
    } else {
      cate1 = 1;
      cate2 = 1;
    }
  }

  $('select[name=cate2]').empty();
  $('select[name=cate1]').val(cate1).prop('selected', true);

  let content = `<option value="0">2차유형</option>`;
  let url1 = '/Kmarket/admin/cs/cate.do?csType=' + csType + '&cate1=' + cate1;
  content += ajaxload(url1);
  $('select[name=cate2]').append(content);

  $('select[name=cate2]').val(cate2).prop('selected', true);
}
