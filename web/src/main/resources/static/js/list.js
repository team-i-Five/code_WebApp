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
