function changeLanguage(locale) {
    location.hash = "locale="+ locale;
    $.ajax({
        type: "GET",
        url: "/locale",
        dataType: "text",
        data: "locale=" + locale,
        success: function(result) {
            window.location.reload();
        }
    });
}
