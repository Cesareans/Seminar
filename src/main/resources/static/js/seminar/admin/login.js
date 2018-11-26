var loginBtn;
var nameInput;
var passwordInput;
$(function () {
    loginBtn = $("#login");
    nameInput = $("#name");
    passwordInput = $("#password");
    loginBtn.click(function () {
        login();
    });
});
function login() {
    if(util.verify($("#loginForm"))){
        $.ajax({
            type:"post",
            url:"/admin/login",
            data:{
                "name":nameInput.val(),
                "password":passwordInput.val()
            },
            success:function (result,status,xhr) {
                if(xhr.status === 200){
                    window.location="/admin/index";
                }else if(xhr.status === 204){
                    util.popWithDelay(loginBtn,"登录失败，用户名或密码错误",3);
                }
            },
            error:function () {
                util.popWithDelay(loginBtn,"登录失败，未知错误",3);
            }
        })
    }
}