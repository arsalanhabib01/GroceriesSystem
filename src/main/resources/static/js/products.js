let productQuantity = 0;

function increaseQuantity() {
    productQuantity += 1;
    $('#quantity').text(productQuantity);
    checkIfMoreThanZero(productQuantity);
}

function decreaseQuantity() {
    if (productQuantity > 0) {
        productQuantity -= 1;
        $('#quantity').text(productQuantity);
    }
}

    function checkIfMoreThanZero(q) {
        if (q > 0) {
            $('#cartcard').removeClass('notActive');
        }

}