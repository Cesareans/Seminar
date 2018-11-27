var loginBtn;
var nameInput;
var passwordInput;
$(function () {
    loginBtn = $("#login");
    nameInput = $("#username");
    passwordInput = $("#password");
    loginBtn.click(function () {
        login();
    });
});
function login() {
    if(util.verifyWithAlert($("#loginForm"))){
        $.ajax({
            type:"post",
            url:"/login",
            data:{
                "username":nameInput.val(),
                "password":passwordInput.val()
            },
            success:function (result,status,xhr) {
                if(xhr.status === 200){
                    window.location="/admin/index";
                }else if(xhr.status === 204){
                    util.showAlert("danger","登录失败，用户名或密码错误",3);
                }
            },
            error:function () {
                util.showAlert("danger","登录失败，未知错误",3);
            }
        })
    }
}