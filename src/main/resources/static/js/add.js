// 发送下面/question/add请求后，该请求返回一个值
function add() {
    var title = document.getElementById("question");
    var content = document.getElementById("textarea");
    data = {};
    data["title"] = title.value;
    data["content"] = content.value;
    $.ajax({
        url: "/question/add",
        type: 'post',
        data: data,
        dataType: 'json',
        success: function (response) {
            window.location.reload(); // 这里是啥意思
        }
    });
    return false;
}

$(function () {
    $('#messageModal').on('show.bs.modal', function (event) {
        var btnThis = $(event.relatedTarget);
        var id = btnThis.data('id');
        $("#id").val(id);
    });
});

function send() {
    var id = document.getElementById("toid");
    var content = document.getElementById("message");
    data = {};
    data["id"] = id.value;
    data["content"] = content.value;
    $.ajax({
        url: "/msg/add",
        type: 'post',
        data: data,
        dataType: 'json',
        async : true,
        success: function (response) {
            window.location.reload();
        }
    });
    return false;
}
