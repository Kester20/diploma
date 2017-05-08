function changeContent(content){
    if(content == "a"){
        sendRequest("personalInfo");
    }
    if(content == "b"){
        sendRequest("wishList");
    }
    if(content == "c"){
        sendRequest("orderList");
    }
    if(content == "d"){
        sendRequest("commentList");
    }
}

function sendRequest(parameter){
    $.ajax({
        type: "GET",
        url: "/info",
        dataType: "text",
        data: "info=" + parameter,
        success: function(result) {
            document.getElementById('contentChanging').innerHTML = result;
        }
    });
}