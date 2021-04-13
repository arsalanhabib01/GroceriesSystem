let productQuantity = 0;
let cart = [];
let sum = 0;
let obj = JSON.parse(localStorage.getItem("itemStores"));

$(document).ready(function() {

    alreadyExistInCart(obj);

    $('.form-control').change(function() {
        updateQuantity(this.value);
    });

    $('.buy').click(function() {
        postCartToDB();
    })

    $('.add-to-cart').click(function() {

        let exists = false;

        $('#cartcard').css('width', '35vw');

        let name = $(this).closest('div').find('.card-title').text();
        let price = $(this).closest('div').parent().find('.product-price').text();
        let volume = $(this).closest('div').find('.card-text').text();
        let amount = parseInt($(this).closest('div').parent().find('.form-control').val(), 10);

        console.log("hej", cart.length);


        if (amount === 0 ) {

        }

        else if (amount > 0) {

            if (obj === null) {
                console.log("object not null");
                addToCart(name, price, volume, amount);
            }

            else if (obj.length > 0 ) {

                for (let i = 0; i < obj.length; i++) {
                    if (obj[i][0] === name) {
                        exists = true;
                        //localStorage object
                        obj[i][3] += parseInt(amount, 10);
                        localStorage.setItem("itemStores", JSON.stringify(obj));
                        console.log("localstorage : " +obj);
                        updateCartItem(obj[i][0], obj[i][3]);
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

    $('.remove-from-cart').click(function() {
        name = $(this).closest('div').find('.card-title').text();
        price = $(this).closest('div').parent().find('.product-price').text();
        volume = $(this).closest('div').find('.card-text').text();
        amount = parseInt($(this).closest('div').parent().find('.form-control').val(), 10);

        if (obj.length > 0 ) {
                        //localstorage obj
                        for(let i=0; i<obj.length; i++){
                            if(obj[i][0] == name) {
                                obj[i][3] -= parseInt(amount, 10);
                                localStorage.setItem("itemStores", JSON.stringify(obj));
                                console.log("localstorage : " + obj);
                                updateCartItem(name, obj[i][3])
                            }
                        }
                    } else {
                        //Remove product from cart
        }


        $('.form-control').val('0');
        calculateSum();
    })

    //Making cart wide
    $('#cart.accordion').click(function() {
        $('#cartcard').css('width', '35vw');
    })
})

function calculateSum() {
    let total = 0;
    for (let i = 0; i < obj.length; i++) {
        let sumPrice = obj[i][1];
        let sumAmount = obj[i][3];
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

function alreadyExistInCart (order){

    if(order !== null){
        for (let i = 0; i < order.length; i++) {

            $('#cartcard').css('width', '35vw');

            $('.theCart').append(`

                <div class="cartItem">
                    <button>
                        <div class="itemName">
                        ${order[i][0]}
                        </div>
                        <div class="itemPrice">
                        ${order[i][1]}
                         </div>
                        <div class="itemAmount">
                        ${order[i][3]}
                        </div>
                    </button>
                </div> `)
            calculateSum();
        }
    }

}


function addToCart (name, price, volume, amount) {

    item = [name, price, volume, amount];

            //localstorage
            store(item);
            obj = JSON.parse(localStorage.getItem("itemStores"));
            console.log(obj);

            console.log(name, price, amount);
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
                </div> `)
}

function checkIfMoreThanZero(q) {
    if (q >= 0) {
        $('#cartcard').css('width', '35vw');
    }
    else if (q < 1) {
        $('#cartcard').css('width', '10vw');
    }
}

function postCartToDB () {
    for(let i = 0; i < obj.length; i++) {


           /* $order = {
                "user_id":"test@test.se",
                "delivery": "true",
                "courier_id":"1",
                "time": "NOW();",
                "date": "NOW();"
            };*/

            $item = {
                "order_id":"1337",
                "product_name":obj[i][0],
                "product_id":"3",
                "amount":obj[i][3]
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
