let productQuantity = 0;
let thisQuantity = 0;

$(function() {

$('.plus-button').on('click', function () {
    number = $(this).closest('div').find('.product-quantity').val();
    number++;
    $(this).closest('div').find('.product-quantity').text(number);
})


$('.minus-button').on('click', function () {
    number = $(this).closest('div').find('.product-quantity').val();
    number--;
    $(this).closest('div').find('.product-quantity').text(number);
})
})


function increaseQuantity() {
    //$(this) pekade på funktionen och kunde därmed
    //ej nå DOMens element. Därav gjort om struktur
    //efter så som läraren gjort.

      // productQuantity += 1;
     //  $(this).closest('.card-body').find('.product-quantity').text(productQuantity);
     //  console.log($(this));
    // $('#quantity').text(productQuantity);
    checkIfMoreThanZero(productQuantity);
}

function decreaseQuantity() {
    checkIfMoreThanZero(productQuantity);
}

function checkIfMoreThanZero(q) {
    if (q >= 0) {
        $('#cartcard').removeClass('notActive');
    }
    else if (q < 1) {
        $('#cartcard').addClass('notActive');
    }
}
