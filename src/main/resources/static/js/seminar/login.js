var loginBtn;
var nameInput;
var passwordInput;
$(function () {
    loginBtn = $("#login");
    nameInput = $("#username");
    passwordInput = $("#password");
    var s = "[ROLE_teacher]";
    loginBtn.click(function () {
        login();
    });
});

function login() {
    var verify = util.verifyWithAlert($("#loginForm"));
    if (verify == null) {
        $.ajax({
            type: "post",
            url: "/login",
            data: {
                "username": nameInput.val(),
                "password": passwordInput.val()
            },
            success: function (result, status, xhr) {
                if (xhr.status === 200) {
                    var response = xhr.responseText;
                    console.log(response);
                    var auth = response.substring(response.indexOf('_') + 1, response.lastIndexOf(']'));
                    window.location = "/" + auth + "/index";
                }
            },
            error: function () {
                util.showAlert("danger", "登录失败，未知错误", 3);
            }
        })
    } else {
        verify.focus();
    }
}