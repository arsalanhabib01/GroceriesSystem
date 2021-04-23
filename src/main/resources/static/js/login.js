$(function () {
    let $user = $('#user');
    let $name = $('#name');
    let $email = $('#email');
    let $address = $('#address');
    let $birthday = $('#birthday');

    function showUser($user){
            $user.append(
                '<tr>' +
                '<td><span class="name noEdit">' + $name + '</span><input class="edit name" ></td>' +
                '<td><span class="birthday noEdit">' + $birthday + ' </span><input class="editBirthday"</td>'+
                '<td><span class="address noEdit">' + $address +   ' </span><input class="editAdress"</td>'+
                '<td><button class="btn remove" data-id=' + $email + '>Ta bort</button></td>' +
                '<td><button class="btn editUser noEdit" data-id="' + $email + '">Ändra</button>' +
                '<button class="btn saveEdit edit btn-danger loging" data-id="' + $email + '">Spara</button>' +
                '<button class="btn cancelEdit edit">Avbryt</button></td>' +
                '</tr>'
            )
    }
    $('#login').on('click', function () {
        $email = $("#email").val();
        $.ajax({
            type: 'GET',
            url: '/api/login/',
            success: function () {
                showUser($user);
            },
            error: function () {
                alert('error GET AJAX');
            }
        });
        $user.delegate('.remove', 'click', function () {
            let $row = $(this).closest('tr');
            $.ajax({
                type: 'DELETE',
                url: '/api/login/' + $(this).attr('data-id'),
                success: function () {
                    $row.remove();
                }
            });

        });
        $user.delegate('.editUser', 'click', function () {
            let $row = $(this).closest('tr');
            $row.find('input.name').val( $row.find('span.name').html() );
            $row.find('input.birthday').val($row.find('span.birthday').html());
            $row.find('input.address').val($row.find('span.address').html());
            $row.addClass('edit');
        });
        $user.delegate('.cancelEdit', 'click', function () {
            $(this).closest('tr').removeClass('edit');
        });
        $user.delegate('.saveEdit', 'click', function () {
            let $row = $(this).closest('tr');
            let user = {
                name: $row.find('input.name').val(),
                birthday: $row.find('input.birthday').val(),
                address: $row.find('input.address').val()
            }
            $.ajax({
                type: 'PUT',
                url: 'api/login/' + $(this).attr('data-id'),
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                data: JSON.stringify($user),
                success: function () {
                    $row.find('span.name').html($user.name);
                    $row.find('span.birthday').html($user.birthday);
                    $row.find('span.address').html($user.address);
                    showUser();
                },
                error: function () {
                    alert('error PUT AJAX');
                }
            });
        });

    });
});
