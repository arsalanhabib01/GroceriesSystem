let productQuantity = 0;
let cart = [];

$(document).ready(function() {

    $('.form-control').change(function() {
        updateQuantity(this.value);
        let name = $(this).closest('div').find('.card-title').text();
        let price = $(this).closest('div').parent().parent().find('.product-price').text();
        let volume = $(this).closest('div').find('.card-text').text();

        addToCart(name, price, volume);
    });

    $('#cart.accordion').click(function() {
        $('#cartcard').css('width', '30vw');
    })

})

function updateQuantity(quantityInput) {
    checkIfMoreThanZero(quantityInput);

}

function addToCart (name, price, volume) {

    item = [name, price, volume];
    cart.push(item);
    console.log(cart);

    $('.theCart').append(`
   
            <div class="cartItem">
                <button>
                    <div class="itemName">
                    ${name}
                    </div>
                    <div class="itemPrice">
                    ${price}
                    </div>
                </button>
            </div>
`)}




function checkIfMoreThanZero(q) {
    if (q >= 0) {
        $('#cartcard').css('width', '30vw');
    }
    else if (q < 1) {
        $('#cartcard').css('width', '10vw');
    }
}

//OLD FUNCTIONS
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


function increaseQuantity() {
    //$(this) pekade på funktionen och kunde därmed
    //ej nå DOMens element. Därav gjort om struktur
    //efter så som läraren gjort.

    // productQuantity += 1;
    //  $(this).closest('.card-body').find('.product-quantity').text(productQuantity);
    //  console.log($(this));
    // $('#quantity').text(productQuantity);

}

function decreaseQuantity() {
    checkIfMoreThanZero(productQuantity);
}