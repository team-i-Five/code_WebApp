function redirectToUrlWithTag(tag) {
    var baseUrl = '/tags/tag1';
    
    var url = baseUrl + '?tag1=' + tag;

    window.location.href = url;
}