var selectedIndex = 0; // 초기값 설정

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


    // console.log(musicals[index].musicalId)
    // window.location.href = "/list/"+musicals[index].musicalId;
  }

  function imageClickHandler(index) {
    console.log("Selected Index:", index);
    selectedIndex = index;
    updateSelectedImage();
  }

  updateSelectedImage(); // 초기 이미지 업데이트
  //showSlides(); // 초기슬라이더
});

// --------------------------------------------------------------- 슬라이더 ---------------------------------------------
// JQuery 문법 $(선택자).동작함수();

$(function () {
  $('.slick-container').slick({
    slide: 'div',		//슬라이드 되어야 할 태그 ex) div, li 
    Infinity: true,
    slidesToShow: 5,		// 한 화면에 보여질 컨텐츠 개수
    slidesToScroll: 5,		//스크롤 한번에 움직일 컨텐츠 개수
    speed: 300,	 // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
  });
})
// var currentIndex = 0; // 현재 보이는 슬라이드의 시작 인덱스
// var itemsPerSlide = 5; // 한 번에 보이는 아이템의 수
// var slides = document.querySelectorAll('.slider-content');

// function showSlides() {
//   // 현재 슬라이드를 기준으로 다음 5개 아이템을 표시
//   for (var i = 0; i < slides.length; i++) {
//     slides[i].style.opacity = '0';
//   }
//   for (var i = currentIndex; i < currentIndex + itemsPerSlide && i < slides.length; i++) {
//     slides[i].style.opacity = '1';
//   }
// }

// function nextSlide() {
//   var totalSlides = slides.length;
//   if (currentIndex + itemsPerSlide < totalSlides) {
//     currentIndex += itemsPerSlide;
//     showSlides();
//     scrollToCurrentSlide();
//   }
// }

// function prevSlide() {
//   if (currentIndex - itemsPerSlide >= 0) {
//     currentIndex -= itemsPerSlide;
//     showSlides();
//     scrollToCurrentSlide();
//   }
// }

// function scrollToCurrentSlide() {
//   var currentSlide = slides[currentIndex];
//   currentSlide.scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'start' });
// }

// --------------------------------------------- 태그관련 ---------------------------------------------
function goNext() {
  let url = '/tags';
  window.location.href = url;
}

function redirectToUrlWithTag1(tag) {
  let baseUrl = '/tags/tag1';
  let url = baseUrl + '?tag1=' + tag;

  window.location.href = url;
}

function redirectToUrlWithTag2(tag2) {
  let baseUrl = '/tags/tag1&tag2';

  console.log(tag1);
  console.log(tag2);
  let url = baseUrl + '?tag1=' + tag1 + '&tag2=' + tag2; // 수정된 부분: '?' 대신 '&'

  window.location.href = url;
}

function redirectToUrlWithTag3(tag3) {
  let baseUrl = '/tags/allTagsSelected';
  console.log(tag1);
  console.log(tag2);
  console.log(tag3);
  let url = baseUrl + '?tag1=' + tag1 + '&tag2=' + tag2 + '&tag3=' + tag3; // 수정된 부분: '?' 대신 '&'

  window.location.href = url;
}
