
// 검색어 가져와서 전송
function submitForm() {
    let searchInput = document.getElementById('searchInput').value; // 입력된 검색어를 가져옵니다.
    if (searchInput.trim() !== '') { // 입력된 검색어가 비어있지 않은지 확인합니다.
        // 현재 폼을 가져와서 submit 합니다.
        document.querySelector('form').submit();
    }
}

// 참고용
function performSearch() {
    const searchTerm = document.getElementById('searchInput').value;
    
    const newURL = '/stores/' + searchTerm;

    history.pushState({ path: newURL }, '', newURL);

    updateSearchResults(searchTerm);
}

// 태그 관련 js
function recommendSimilar(){
    console.log(musicalId);  
    let baseUrl = "/present/ml/";
    let selectedTitle = document.getElementById("selectedTitle").textContent;
    let encodedTitle = encodeURIComponent(selectedTitle);
  
    let url = baseUrl + musicalId +"?title="+encodedTitle;
  
  
    window.location.href = url;
  }
  
  function redirectToUrlWithTag1(tag) {
    let baseUrl = '/past/tags/tag1';
    let url = baseUrl + '?tag1=' + tag;
  
    window.location.href = url;
  }
  
  function redirectToUrlWithTag2(tag2) {
    let baseUrl = '/past/tags/tag1&tag2';
  
    console.log(tag1);
    console.log(tag2);
    let url = baseUrl + '?tag1=' + tag1 + '&tag2=' + tag2; // 수정된 부분: '?' 대신 '&'
  
    window.location.href = url;
  }
  
  function redirectToUrlWithTag3(tag3) {
    let baseUrl = '/past/tags/allTagsSelected';
    console.log(tag1);
    console.log(tag2);
    console.log(tag3);
    let url = baseUrl + '?tag1=' + tag1 + '&tag2=' + tag2 + '&tag3=' + tag3; // 수정된 부분: '?' 대신 '&'
  
    window.location.href = url;
  }