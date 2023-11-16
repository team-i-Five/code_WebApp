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
      const index = selectedIndex % musicals.length; // index를 musicals 배열의 길이로 나눈 나머지를 사용하여 배열을 순환하도록 함
      selectedImage.src = musicals[index].posterUrl;
  }

  function imageClickHandler(index) {
      console.log("Selected Index:", index);
      selectedIndex = index;
      updateSelectedImage();
  }

  updateSelectedImage(); // 초기 이미지 업데이트
});



// ------------------ 슬라이더 버튼 --------------------------------
function prevBtn_click() {
  const container = document.querySelector('.musical-contents');
  const slideWidth = document.querySelector('.slider-content').offsetWidth;
  const visibleSlides = Math.floor(container.clientWidth / slideWidth);
  container.scrollLeft -= slideWidth * visibleSlides;
}

function nextBtn_click() {
  const container = document.querySelector('.musical-contents');
  const slideWidth = document.querySelector('.slider-content').offsetWidth;
  const visibleSlides = Math.floor(container.clientWidth / slideWidth);
  container.scrollLeft += slideWidth * visibleSlides;
}

document.querySelector('.prev-btn').addEventListener('click', prevBtn_click);
document.querySelector('.next-btn').addEventListener('click', nextBtn_click);
