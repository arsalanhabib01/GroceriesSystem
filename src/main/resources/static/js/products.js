let productQuantity = 0;

function increaseQuantity() {
    productQuantity += 1;
    $('#quantity').text(productQuantity);
}

function decreaseQuantity() {
    if(productQuantity > 0) {
        productQuantity -= 1;
        $('#quantity').text(productQuantity);
    }
}