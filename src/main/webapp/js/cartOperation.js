function addToCart(id) {
    $.ajax({
        type: "GET",
        url: "/cart/add",
        dataType: "json",
        data: "idProduct=" + id,
        success: function(result) {
            $("#total_head").html("$" + result.amount);
            $("#size_head").html("(" + result.size + ")");
            location.reload();
            location.href = result.modal;
        }
    });
}

function deleteProductFromCart(id){
  $.ajax({
      type: "GET",
      url: "/cart/delete",
      dataType: "text",
      data: "idProduct=" + id,
      success: function(result) {
         location.reload();
      }
  });
}

function setKeyValue(id, value){
  $.ajax({
      type: "GET",
      url: "/cart/amount/update",
      dataType: "json",
      data: "idProduct=" + id + "&value=" + value,
      success: function(result) {
          $("#total").html(result.amount);
          $("#total_head").html("$" + result.amount);
          $("#size_head").html("(" + result.size + ")");
      }
  });
}


function updateTotal(idLaptop, value) {
    setKeyValue(idLaptop, value);
}

function clearCart(){
  $.ajax({
      type: "GET",
      url: "clear_cart_servlet"
  });
}

function addToWishList(id) {
    $.ajax({
        type: "GET",
        url: "/wishList/add",
        dataType: "text",
        data: "idProduct=" + id,
        success: function(result) {
            location.reload();
        }
    });
}

function deleteFromWishList(id) {
    $.ajax({
        type: "GET",
        url: "/wishList/delete",
        dataType: "text",
        data: "idProduct=" + id,
        success: function(result) {
            location.reload();
        }
    });
}

function addComment(id) {
    var text = document.getElementById("textarea").value;
    $.ajax({
        type: "GET",
        url: "/comment/add",
        dataType: "text",
        data: "idProduct=" + id + "&text=" + text,
        success: function(result) {
            location.reload();
        }
    });
}