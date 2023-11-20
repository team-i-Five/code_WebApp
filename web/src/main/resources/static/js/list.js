<<<<<<< HEAD
var selectedIndex = 0; // 초기값 설정

document.addEventListener("DOMContentLoaded", function() {
  var images = document.querySelectorAll(".list-image");
  images.forEach(function (image, index) {
      image.addEventListener("click", function () {
          imageClickHandler(index);
      });
  });

  var selectedIndex = 0; // 초기값 설정

  function updateSelectedImage() {
      const selectedImage = document.getElementById("selectedImage");
      const selectedId = document.getElementById("selectedId");
      const selectedTitle = document.getElementById("selectedTitle"); // 선택된 제목을 나타내는 요소
      const selectedSys = document.getElementById("selectedSys");
      const selectedGenre = document.getElementById("selectedGenre");
      const selectedDate = document.getElementById("selectedDate");
      const selectedLocation = document.getElementById("selectedLocation");
      const selectedRunning = document.getElementById("selectedRunning");
      const index = selectedIndex % musicals.length; // index를 musicals 배열의 길이로 나눈 나머지를 사용하여 배열을 순환하도록 함
      selectedImage.src = musicals[index].posterUrl;
      selectedId.textContent = musicals[index].musicalId;
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
});




//슬라이더 업데이트 5개씩
let startIndex = 0; // 슬라이드 그룹의 시작 인덱스

function prevBtn_click() {
  const container = document.querySelector('.musical-contents');
  const slideWidth = document.querySelector('.slider-content').offsetWidth;
  const visibleSlides = Math.floor(container.clientWidth / slideWidth);
  
  // 이전 버튼 클릭 시 시작 인덱스를 조절하여 슬라이더를 이동
  startIndex = Math.max(0, startIndex - visibleSlides);
  container.scrollLeft = startIndex * slideWidth;
}

function nextBtn_click() {
  const container = document.querySelector('.musical-contents');
  const slideWidth = document.querySelector('.slider-content').offsetWidth;
  const visibleSlides = Math.floor(container.clientWidth / slideWidth);
  const totalSlides = document.querySelectorAll('.slider-content').length;

  // 다음 버튼 클릭 시 시작 인덱스를 조절하여 슬라이더를 이동
  startIndex = Math.min(totalSlides - visibleSlides, startIndex + visibleSlides);
  container.scrollLeft = startIndex * slideWidth;
}

document.querySelector('.prev-btn').addEventListener('click', prevBtn_click);
document.querySelector('.next-btn').addEventListener('click', nextBtn_click);


// ------------------ 슬라이더 버튼 --------------------------------
// function prevBtn_click() {
//   const container = document.querySelector('.musical-contents');
//   const slideWidth = document.querySelector('.slider-content').offsetWidth;
//   const visibleSlides = Math.floor(container.clientWidth / slideWidth);
//   container.scrollLeft -= slideWidth * visibleSlides;
// }

// function nextBtn_click() {
//   const container = document.querySelector('.musical-contents');
//   const slideWidth = document.querySelector('.slider-content').offsetWidth;
//   const visibleSlides = Math.floor(container.clientWidth / slideWidth);
//   container.scrollLeft += slideWidth * visibleSlides;
// }

// document.querySelector('.prev-btn').addEventListener('click', prevBtn_click);
// document.querySelector('.next-btn').addEventListener('click', nextBtn_click);
=======
// Your JavaScript code for handling pagination and slide animation
function loadPage(page) {
    const musicalRow = document.getElementById("musicalRow");

    fetch(`/list?page=${page}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.text())
    .then(html => {
        musicalRow.innerHTML = html;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
