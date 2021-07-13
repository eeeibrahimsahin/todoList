var userInfo;
$(document).ready(function () {
    getData();
});

function getData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/users",
        dataType: "json",
        success: function (data) {
            console.log(data);
            let html;
            data.forEach((element) => {
                html += `<option value=${element.id}>${element.firstname} ${element.lastname} </option>`;
            });

            $("#userControlSelect").append(html);
        },
    });
}

$("#userForm").submit(function (e) {
    e.preventDefault();
    let userId = $("select[name=selection] option").filter(":selected").val();
    let userJsObj = {
        id: parseInt(userId),
    };
    let userJSON = JSON.stringify(userJsObj);
    console.log(userJSON);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/getUserById",
        data: userJSON,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            console.log("hello");

            userInfo = {
                id: response.id,
                firstname: response.firstname,
                lastname: response.lastname,
                username: response.username,
            };

            console.log(userInfo);
            pageRedirect();
        },
    });
});

function pageRedirect() {
    window.location.href = "../login.html";
}
