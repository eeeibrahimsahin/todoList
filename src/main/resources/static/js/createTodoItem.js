var itemName;
var itemDeadline;
var itemDescription;

$("#todoItemForm").submit(function (e) {
    e.preventDefault();
    itemName = $("#name").val();
    itemDeadline = $("#deadline").val();
    itemDescription = $("#description").val();

    var itemJsObj = {
        name: itemName,
        deadline: itemDeadline,
        description: itemDescription,
    };

    var itemJSON = JSON.stringify(itemJsObj);

    $.ajax({
        type: "post",
        url: "http://localhost:8080/api/createNewItem",
        data: itemJSON,
        dataType: "application/json",
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        },
    });
});
