var util = {
    popWithDelay: function (pop, message, s) {
        pop.attr("data-content", message);
        pop.popover("show");
        setTimeout(function () {
            pop.popover("hide");
        }, s * 1000);
    },
    verify:function (form) {
        var emptyVerifies = form.find("input.empty-verify");
        for(var i = 0 ; i < emptyVerifies.length; ++i){
            var emptyVerify = $(emptyVerifies.get(i));
            if(emptyVerify.val() == null || emptyVerify.val() ===""){
                this.popWithDelay(emptyVerify, emptyVerify.attr("data-emptyMessage"), 3);
                emptyVerify.focus();
                return false;
            }
        }
        var regVerifies = form.find("input.reg-verify");
        for(i = 0 ; i < regVerifies.length; ++i){
            var regVerify = $(regVerifies.get(i));
            if(!(new RegExp(regVerify.attr("data-reg")).test(regVerify.val()))){
                this.popWithDelay(regVerify, regVerify.attr("data-regMessage"), 3);
                regVerify.focus();
                return false;
            }
        }
        return true;
    }
};