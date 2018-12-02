var seminarModalNavs;
var seminarModals;

$(function () {
    seminarModals = $(".seminar-modal");
    seminarModalNavs = $(seminarModals.find(".nav-link"));

    console.log(seminarModals.get(0));
    $(seminarModals.get(0)).on("hidden.bs.modal", function () {
        var navCol = $(this).find(".nav-col");
        var tabCol = navCol.siblings(".tab-col");
        if(navCol.hasClass("col-4")){
            navCol.removeClass("col-4");
            navCol.addClass("col-12");
            tabCol.removeClass("show");
        }
        $(navCol.find(".active")).removeClass("active");
    });
    seminarModalNavs.click(function () {
        var navCol = $(this).parent().parent().parent();
        var tabCol = navCol.siblings(".tab-col");
        if(navCol.hasClass("col-12")){
            navCol.removeClass("col-12");
            navCol.addClass("col-4");
            setTimeout(function () {
                if(navCol.hasClass("col-4")) {
                    tabCol.addClass("show");
                }
            }, 600);
        }else if(navCol.hasClass("col-4") && $(this).hasClass("active")){
            navCol.removeClass("col-4");
            navCol.addClass("col-12");
            tabCol.removeClass("show");
        }
    });

});