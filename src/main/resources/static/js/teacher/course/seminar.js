var seminarModalNavs;
var seminarModals;
var klassButtons;
var seminarForm = {};
var courseIdForm;

$(function () {
    seminarModals = $(".seminar-modal");
    seminarModalNavs = $(seminarModals.find(".nav-link"));
    klassButtons = $(".klass-btn");
    seminarForm.form = $("#seminarForm");
    seminarForm.seminarIdInput = $("#seminarIdInput");
    seminarForm.klassIdInput = $("#klassIdInput");
    courseIdForm = $("#courseIdForm");

    klassButtons.click(function () {
        //Logy
        seminarForm.klassIdInput.val($(this).attr("data-klassId"));
        seminarForm.form.submit();
    });
    $("#addRound").click(function () {
        $.ajax({
            type: "post",
            url: "/teacher/course/round/add",
            data: courseIdForm.serialize(),
            success: function (result, status, xhr) {
                if (xhr.status === 200) {
                    window.location = "/teacher/course/courseList";
                }
            },
            error: function () {
                util.showAlert("danger", "创建失败，未知错误", 3);
            }
        })
    });
    seminarModals.on("hidden.bs.modal", function () {
        var navCol = $(this).find(".nav-col");
        var tabCol = navCol.siblings(".tab-col");
        //Style
        if (navCol.hasClass("col-4")) {
            navCol.removeClass("col-4");
            navCol.addClass("col-12");
            tabCol.removeClass("show");
        }
        $(navCol.find(".active")).removeClass("active");
    });
    seminarModalNavs.click(function () {
        var navCol = $(this).parent().parent().parent();
        var tabCol = navCol.siblings(".tab-col");
        //Style
        if (navCol.hasClass("col-12")) {
            navCol.removeClass("col-12");
            navCol.addClass("col-4");
            setTimeout(function () {
                if (navCol.hasClass("col-4")) {
                    tabCol.addClass("show");
                }
            }, 600);
        } else if (navCol.hasClass("col-4") && $(this).hasClass("active")) {
            navCol.removeClass("col-4");
            navCol.addClass("col-12");
            tabCol.removeClass("show");
        }
        //Logy
        seminarForm.seminarIdInput.val($(this).attr("data-seminarId"));
    });
});