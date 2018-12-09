var resetPwdForm;
var passwordInput;
var confirmPwdInput;
$(function () {
    resetPwdForm = $("#resetPwdForm");
    passwordInput = $("#password");
    confirmPwdInput = $("#confirmPwd");

    $("#confirmBtn").click(function () {
        var password = passwordInput.val();
        var confirmPwd = confirmPwdInput.val();
        if(password !== confirmPwd){
            util.showAlert("warning", "两次密码不一致", 3);
            actForm.confirmPwd.registerDanger();
            return;
        }
        var verify = util.verifyWithAlert(resetPwdForm);
        if(verify == null){
            $.ajax({
                type: "post",
                url: "/modifyPassword",
                data: resetPwdForm.serialize(),
                success: function (result, status, xhr) {
                    if (xhr.status === 200) {
                        window.location="/teacher/index";
                    }
                },
                error: function () {
                    util.showAlert("danger", "修改失败，未知错误", 3);
                }
            });
        }else{
            verify.registerDanger();
        }
    })
});