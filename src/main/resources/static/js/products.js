let productQuantity = 0;
let cart = [];
let sum = 0;

$(document).ready(function() {

    $('.form-control').change(function() {
        updateQuantity(this.value);
    });

    $('.buy').click(function() {
        postCartToDB();
    })

    $('.add-to-cart').click(function() {

        let exists = false;

        $('#cartcard').css('width', '30vw');

        let name = $(this).closest('div').find('.card-title').text();
        let price = $(this).closest('div').parent().find('.product-price').text();
        let volume = $(this).closest('div').find('.card-text').text();
        let amount = parseInt($(this).closest('div').parent().find('.form-control').val(), 10);

        if (amount === 0 ) {

        }

        else if (amount > 0) {

            if (cart.length === 0) {
                addToCart(name, price, volume, amount);
            }

            else if (cart.length > 0 ) {
                var obj = JSON.parse(localStorage.getItem("itemStores"));
                for (let i = 0; i < cart.length; i++) {
                    if (cart[i][0] === name) {
                        exists = true;
                        cart[i][3] += parseInt(amount, 10);
                        obj[i][3] += parseInt(amount, 10);
                        localStorage.setItem("itemStores", JSON.stringify(obj));
                        console.log("localstorage : " +obj);
                        console.log("Array: " +cart);
                        updateCartItem(cart[i][0], cart[i][3]);
                        }
                    }

                if (!exists) {
                    addToCart(name, price, volume, amount);
                }

                }
        }
        $('.form-control').val('0');
        calculateSum();
    })

    //Making cart wide
    $('#cart.accordion').click(function() {
        $('#cartcard').css('width', '30vw');
    })
})

function calculateSum() {
    let total = 0;
    for (let i = 0; i < cart.length; i++) {
        let sumPrice = cart[i][1];
        let sumAmount = cart[i][3];
        sum = parseInt(sumPrice,10) * parseInt(sumAmount,10);
        total += sum;
    }
    console.log(total);
    $('.sum').html('Summa: ' + total);
}

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
    
    store(item);
    console.log(localStorage.getItem("itemStores"));

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

function postCartToDB () {
    for(let i = 0; i < cart.length; i++) {


           /* $order = {
                "user_id":"test@test.se",
                "delivery": "true",
                "courier_id":"1",
                "time": "NOW();",
                "date": "NOW();"
            };*/

            $item = {
                "order_id":"1337",
                "product_name":cart[i][0],
                "product_id":"3",
                "amount":cart[i][3]
            };


            $.ajax({
                type: 'POST',
                url: '/addcart',
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                data: JSON.stringify($item),
                success: function () {
                    alert('Order har lagts')
                },
                error: function () {
                    alert('error');
                }
            });
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