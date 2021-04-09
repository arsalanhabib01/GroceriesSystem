let productQuantity = 0;
let cart = [];

$(document).ready(function() {

    $('.form-control').change(function() {
        updateQuantity(this.value);
    });

    $('.add-to-cart').click(function() {

        let exists = false;

        $('#cartcard').css('width', '30vw');

        let name = $(this).closest('div').find('.card-title').text();
        let price = $(this).closest('div').parent().parent().find('.product-price').text();
        let volume = $(this).closest('div').find('.card-text').text();
        let amount = parseInt($(this).closest('div').parent().parent().find('.form-control').val(), 10);

        if (amount === 0 ) {

        }

        else if (amount > 0) {

            if (cart.length === 0) {
                addToCart(name, price, volume, amount);
            }

            else if (cart.length > 0 ) {

                for (let i = 0; i < cart.length; i++) {
                    if (cart[i][0] === name) {
                        exists = true;
                       cart[i][3] += parseInt(amount, 10);
                       console.log(cart);
                       updateCartItem(cart[i][0], cart[i][3]);
                        }
                    }

                if (!exists) {
                    addToCart(name, price, volume, amount);
                }

                }
        }
    })

    //Making cart wide
    $('#cart.accordion').click(function() {
        $('#cartcard').css('width', '30vw');
    })

})

function updateQuantity(quantityInput) {
    checkIfMoreThanZero(quantityInput);
}


function updateCartItem(name, amount) {
 let sameProduct = $('.theCart').find('.itemName').text(); //Apelsin Juice

    if ($('.theCart').find('.itemName').text() === sameProduct) {
        console.log("Produkt finns i korg ");
    }

    $(".itemName:contains('" + name + "')").closest('.cartItem').find('.itemAmount').text(amount);



}



function addToCart (name, price, volume, amount) {

    item = [name, price, volume, amount];
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
                    <div class="itemAmount">
                    ${amount}
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