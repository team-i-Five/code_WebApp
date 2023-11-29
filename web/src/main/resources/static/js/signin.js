function hideLabel(inputId, labelId) {
    var inputElement = document.getElementById(inputId);
    var labelElement = document.getElementById(labelId);

    if (inputElement && labelElement) {
        labelElement.style.display = inputElement.value.trim() !== '' ? 'none' : 'block';
    }
}

document.addEventListener("DOMContentLoaded", function () {
  });
