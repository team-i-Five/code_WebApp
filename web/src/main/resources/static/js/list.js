// 이벤트 핸들러 등록
document.querySelector('.prev-btn').addEventListener('click', prevBtn_click);
document.querySelector('.next-btn').addEventListener('click', nextBtn_click);



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
