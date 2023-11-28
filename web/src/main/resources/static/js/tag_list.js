let musicalId =0;

document.addEventListener("DOMContentLoaded", function () {
  var images = document.querySelectorAll("#slider-image");
  images.forEach(function (image, index) {
    image.addEventListener("click", function () {
      imageClickHandler(index);
    });
  });

  var selectedIndex = 0; // 초기값 설정

  function updateSelectedImage() {
    const selectedImage = document.getElementById("selectedImage");
    const selectedTitle = document.getElementById("selectedTitle"); // 선택된 제목을 나타내는 요소
    const selectedSys = document.getElementById("selectedSys");
    const selectedGenre = document.getElementById("selectedGenre");
    const selectedDate = document.getElementById("selectedDate");
    const selectedLocation = document.getElementById("selectedLocation");
    const selectedRunning = document.getElementById("selectedRunning");
    const index = selectedIndex % musicals.length; // index를 musicals 배열의 길이로 나눈 나머지를 사용하여 배열을 순환하도록 함
    selectedImage.src = musicals[index].posterUrl;
    selectedTitle.textContent = musicals[index].title; // 선택된 이미지의 제목 업데이트
    selectedSys.textContent = musicals[index].synopsis;
    selectedGenre.textContent = musicals[index].genre;
    selectedDate.textContent = musicals[index].date;
    selectedLocation.textContent = musicals[index].location;
    selectedRunning.textContent = musicals[index].runningTime;


    musicalId = musicals[index].musicalId;

    console.log(musicalId)
    // window.location.href = "/list/"+musicals[index].musicalId;
  }

  function imageClickHandler(index) {
    console.log("Selected Index:", index);
    selectedIndex = index;
    updateSelectedImage();
  }

  updateSelectedImage(); // 초기 이미지 업데이트


  // --------------------------------------------------------------- 슬라이더 ---------------------------------------------
  // JQuery 문법 $(선택자).동작함수();
  // 이건 태그결과 js
  $('.show-slides').slick(
    {
      infinite: false, // 무한반복
      slidesToShow: 4, // 화면에 보여질 갯수
      slidesToScroll: 4, // 슬라이드 갯수
      dots: true, // 네비버튼
      variableWidth: true,
      speed: 400
    });

  /*<![CDATA[*/
  // ml 결과 js
  console.log(slideNum);
  $('.show-one-slide').slick(
    {
      infinite: true, // 무한반복
      slidesToShow: 1, // 화면에 보여질 갯수
      slidesToScroll: 1, // 슬라이드 갯수
      centerMode: true,
      dots: true, // 네비버튼
      draggable: false, // 드래그기능 
      speed: 400
    });
  if (slideNum == '1') {
    $('.slick-prev').on('click', function () {
      var currentSlideIndex = $('.show-one-slide').slick('slickCurrentSlide');
      imageClickHandler(currentSlideIndex);
    });

    $('.slick-next').on('click', function () {
      var currentSlideIndex = $('.show-one-slide').slick('slickCurrentSlide');
      imageClickHandler(currentSlideIndex);
    });
  }


});

// --------------------------------------------- 태그관련 ---------------------------------------------

function recommendSimilar(){
  console.log(musicalId);  
  let baseUrl = "/ml/";
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
