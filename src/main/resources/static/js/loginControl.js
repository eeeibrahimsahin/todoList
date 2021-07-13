let username;
let password;
let usernameEl = $("#username");
$(document).ready(function () {
    // $(".alert").alert("close");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user/login",
        success: function (response) {
            console.log(response);
            username = response.username;
            usernameEl.val(username);
        },
    });
});

$("#loginForm").submit(function (e) {
    e.preventDefault();
    password = $("#password").val();
    let passwordJsObj = {
        password: password,
    };
    let passwordJSON = JSON.stringify(passwordJsObj);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/user/login",
        data: passwordJSON,
        contentType: "application/json",
        success: function (response) {
            if (response) {
                pageRedirect();
            }
            $("#password").val("");
            $(".alert").removeClass("d-none");
        },
    });
});

function pageRedirect() {
    window.location.href = "../userIndex.html";
}
