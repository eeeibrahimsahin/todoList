let username;
let usernameEl = $(".navbar-text");
let cardsListEl = $("#todoListCards");
let cardEl;
let cardGroupEl;
$(document).ready(function () {
    getData();
});

function getData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user/login",
        success: function (response) {
            setTodoListToIndexPage(response.todoLists);
            console.log(response);
            username = response.firstname;
            console.log(username);
            usernameEl.text(username);
        },
    });
}

let colorList = [
    "secondary",
    "success",
    "info",
    "warning",
    "danger",
    "light",
    "dark",
    "primary",
];
function setTodoListToIndexPage(data) {
    cardEl = "";
    cardGroupEl = "";
    $.each(data, function (indexInArray, valueOfElement) {
        console.log(valueOfElement);
        $.each(
            valueOfElement.todoItemList,
            function (indexInArray, valueOfElement) {
                let random = Math.floor(Math.random() * colorList.length);
                let color = colorList[random];
                cardEl += `<div class="card border-${color} mb-3" style="max-width: 18rem;">
                        <div class="card-header bg-transparent border-${color}">${valueOfElement.name}</div>
                            <div class="card-body text-${color}">
                                <h5 class="card-title">Deadline: ${valueOfElement.deadline}</h5>
                                <p class="card-text">${valueOfElement.description}</p>
                            </div>
                        <div class="card-footer bg-transparent border-${color}"><span onclick="deleteItem(${data[indexInArray].id})"><i class="far fa-edit"></i></span>
                        <span onclick="deleteItem(${data[indexInArray].id})"><i class="far fa-trash-alt"></i></span></div>
                    </div>`;
            }
        );

        cardGroupEl += `<div class="jumbotron jumbotron-fluid">
                            <div class="container">
                                <h1 class="display-4"> <a class="nav-item nav-link" href="./todoItems.html">${valueOfElement.name}</a></h1>
                                <div class="card-columns">
                                    ${cardEl}
                                </div>
                            </div>
                        </div>`;
        cardEl = "";
    });
    cardsListEl.append(cardGroupEl);
}

function deleteItem(id) {
    console.log(id);
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/item/delete/${id}`,
        success: function (response) {
            cardsListEl.val("");
            console.log("llll");
            getData();
        },
    });
}
