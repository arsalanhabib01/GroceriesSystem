$(function() {
    //   $("#addButton").click(function() {
    DisplayTable();
    //  });
});
function DisplayTable() {
    jQuery("#tabledata").html(""); //Clear the existing data
    var result = JSON.parse(localStorage.getItem("itemStores"));
    jQuery.each(result, function (key, value) {
        jQuery("#tabledata").append('<tr><td>' + value[0] + '</td><td>' + value[1] + '</td><td>'
            + value[2] + '</td><td>' + value[3] + '</td></tr>');
    })

}
