$(function () {
    let $user;
    let $name = $('#name');
    let $email= $('#email');
    let $birthday = $('#birthday');
    let $address = $('#address');
    $('#save-user').on('click', function () {
        $user = {
            "name":$name.val(),
            "email":$email.val(),
            "birthday":$birthday.val(),
            "address":$address.val()
        };
        $.ajax({
            type: 'POST',
            url: 'api/newuser',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify($user),
            success: function () {
                alert('Ny användare är sparat')
            },
            error: function () {
                alert('error');
            }
        });
    });
});



