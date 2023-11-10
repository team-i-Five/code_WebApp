function hideLabel(inputId, labelId) {
    var inputElement = document.getElementById(inputId);
    var labelElement = document.getElementById(labelId);

    if (inputElement.value.trim() !== '') {
        labelElement.style.display = 'none';
    } else {
        labelElement.style.display = 'block';
    }
}
