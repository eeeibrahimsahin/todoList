$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/todoLists",
        dataType: "json",
        success: function (data) {
            console.log(data);
            let html;
            data.forEach((element) => {
                html += `<tr>
                                        <td>${element.id}</td>
                                        <td>${element.name}</td>
                                        <td>${element.todoItemList.length}</td>
                                       <td> <i class="far fa-edit"></i> <i class="far fa-trash-alt"></i></td>
                                    </tr>`;
            });

            $("#tableBody").append(html);
        },
    });
});
