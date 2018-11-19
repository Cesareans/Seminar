var loginBtn;
var nameInput;
var passwordInput;
$(function () {
    loginBtn = $("#login");
    nameInput = $("#name");
    passwordInput = $("#password");
    loginBtn.click(function () {
        login();
    })
});
function login() {
    if(verify()){
        $.ajax({
            type:"post",
            url:"/admin/login",
            data:{
                "name":nameInput.val(),
                "password":passwordInput.val()
            },
            success:function (result) {
                if(result === "success"){
                    window.location="/admin/index";
                }else if(result === "fail"){
                    popWithDelay(loginBtn,"登录失败，用户名或密码错误",3);
                }else{
                    popWithDelay(loginBtn,"登录失败，未知错误",3);
                }
            },
            error:function () {
                popWithDelay(loginBtn,"登录失败，未知错误",3);
            }
        })
    }
}
function verify() {
    if(nameInput.val() == null || nameInput.val() ===""){
        popWithDelay(nameInput, "请输入管理员名", 3);
        nameInput.focus();
        return false;
    }
    if(passwordInput.val() == null || passwordInput.val() === ""){
        popWithDelay(passwordInput, "请输入密码", 3);
        passwordInput.focus();
        return false;
    }
    return true;
}

function popWithDelay(pop, message, s) {
    pop.attr("data-content", message);
    pop.popover("show");
    setTimeout(function () {
        pop.popover("hide");
    },s * 1000);
}