function hideLabel(inputId, labelId) {
    var inputElement = document.getElementById(inputId);
    var labelElement = document.getElementById(labelId);

<<<<<<< HEAD
    if (inputElement && labelElement) {
        labelElement.style.display = inputElement.value.trim() !== '' ? 'none' : 'block';
    }
}

document.addEventListener("DOMContentLoaded", function () {
  });
=======
    if (inputElement.value.trim() !== '') {
        labelElement.style.display = 'none';
    } else {
        labelElement.style.display = 'block';
    }
}
>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
