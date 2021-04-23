let productQuantity = 0;
let cart = [];
let sum = 0;
let obj = JSON.parse(localStorage.getItem("itemStores"));

orderId = 0;

$(document).ready(function() {

    alreadyExistInCart(obj);

    $('.form-control').change(function() {
        updateQuantity(this.value);
    });

    $('.buy').click(function() {
        let mail = $('#customerMail').val();
        if(ValidateEmail(mail)) {
            postCartToDB();
            postOrderToDB();
        }
        else {
            alert("Mail is invalid");
        }
    })

    $('.add-to-cart').click(function() {

        let exists = false;

        $('#cartcard').css('width', '35vw');

        let name = $(this).closest('div').find('.card-title').text();
        let price = $(this).closest('div').parent().find('.product-price').text();
        let volume = $(this).closest('div').find('.card-text').text();
        let amount = parseInt($(this).closest('div').parent().find('.form-control').val(), 10);



        if (amount === 0 ) {

        }

        else if (amount > 0) {

            if (obj === null) {
                console.log("obj is null: localStorage itemStores is empty");
                addToCart(name, price, volume, amount);
            }

            else if (obj.length >= 0 ) {

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

        if (obj.length > 0) {
            //localstorage obj
            for (let i = 0; i < obj.length; i++) {
                if (obj[i][0] === name) {
                    obj[i][3] -= parseInt(amount, 10);
                    localStorage.setItem("itemStores", JSON.stringify(obj));
                    console.log("localstorage : " + obj);
                    updateCartItem(name, obj[i][3]);


                    //Remove product from cart
                    if (obj[i][3] <= 0) {
                        var indexOfProductwithZeroAmount = obj.indexOf(obj[i]);
                        console.log("zero : ", obj);

                        var $row =  $(".itemName:contains('" + obj[i][0] + "')").closest('.cartItem');
                        $row.remove();

                        if (indexOfProductwithZeroAmount > -1) {
                            obj.splice(indexOfProductwithZeroAmount, 1);

                            //
                            localStorage.setItem("itemStores", JSON.stringify(obj));


                        }

                    }
                }
            }

        }



        $('.form-control').val('0');
        calculateSum();
    })

    //Making cart wide
    $('#cart.accordion').click(function() {
        $('#cartcard').css('width', '35vw');
    })
})

function ValidateEmail(mail) {

    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail)) {
        $('.savedMail').remove();
        $('.salong').append(`<p class="savedMail"><h5>Mail sparad.</h5></p>`);
        return (true)
    }
    $('.savedMail').remove();
    $('.salong').append(`<p class="savedMail"><h5>*Ej giltig mailadress!*</h5></p>`);
    return (false)
}

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
            console.log("this is: obj: " + obj);

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

    orderId++;

    for(let i = 0; i < obj.length; i++) {

            $item = {
                "order_id": orderId,
                "product_name":obj[i][0],
                "product_id":"0",
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
                    alert('Cart added to db')
                },
                error: function () {
                    alert('error');
                }
            });
        }

}

function postOrderToDB () {

    let currentDate = new Date();
    let cDay = currentDate.getDate();
    let cMonth = currentDate.getMonth() + 1;
    let cYear = currentDate.getFullYear();

    $order = {
        "customer_id": 2,
        "order_id": orderId,
        "date": currentDate,// cDay + "/" + cMonth + "/" + cYear,
        "status": "PLOCKAS",
        "time": currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds()
     };

    $.ajax({
        type: 'POST',
        url: '/addorder',
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        data: JSON.stringify($order),
        success: function () {
            alert('Order har lagts')
        },
        error: function () {
            alert('error placing order to db');
        }
    });



}



