var datetimepicker;
var createCourseForm;
var prePer;
var quePer;
var repPer;
var courseItems;
var courseLimitList = [];
var courseConflictList = {};
var courseLimitBtn;
var courseConflictBtn;
var courseModal;
var formContainer;
var state = 0;
var courseLimitDom;
{
    courseLimitDom ="\n" +
        "                        <div class=\"col-lg-6 col-md-12\">\n" +
        "                            <div class=\"card form-card dropdown-card\">\n" +
        "                                <div class=\"card-body\">\n" +
        "                                    <div class=\"body-header\">\n" +
        "                                        <div class=\"body-title flex-space-between\">\n" +
        "                                            <div>选修课程要求</div>\n" +
        "                                            <div class=\"course-name\" style=\"margin-right: 20px\"></div>\n" +
        "                                        </div>\n" +
        "                                        <div class=\"flex-center\">\n" +
        "                                            <div class=\"triangle rightward\"></div>\n" +
        "                                        </div>\n" +
        "                                    </div>\n" +
        "                                    <div class=\"body-content\" style=\"display: none;\">\n" +
        "                                        <input hidden=\"\" class=\"courseLimitId\" placeholder=\"\">\n" +
        "                                        <hr>\n" +
        "                                        <div class=\"line\">\n" +
        "                                            <label for=\"teamMax\">人数上限</label>\n" +
        "                                            <div class=\"sep\"></div>\n" +
        "                                            <div class=\"content\">\n" +
        "                                                <div class=\"form-group bmd-form-group\" style=\"display: inline\">\n" +
        "                                                    <input type=\"text\" autocomplete=\"off\" placeholder=\"\" class=\"form-control empty-verify courseLimitMax\" data-emptymessage=\"请输入人数上限\" data-reg=\"^\\d$\" data-regmessage=\"上限不合法\">\n" +
        "                                                </div>\n" +
        "                                            </div>\n" +
        "                                        </div>\n" +
        "                                        <div class=\"line\">\n" +
        "                                            <label for=\"teamMin\">人数下限</label>\n" +
        "                                            <div class=\"sep\"></div>\n" +
        "                                            <div class=\"content\">\n" +
        "                                                <div class=\"form-group bmd-form-group\" style=\"display: inline\">\n" +
        "                                                    <input type=\"text\" autocomplete=\"off\" placeholder=\"\" class=\"form-control empty-verify reg-verify courseLimitMin\" data-emptymessage=\"请输入人数下限\" data-reg=\"^\\d$\" data-regmessage=\"下限不合法\">\n" +
        "                                                </div>\n" +
        "                                            </div>\n" +
        "                                        </div>\n" +
        "                                    </div>\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                        </div>";
}
$(function () {
    datetimepicker = $(".datetimepicker");
    createCourseForm = $("#createCourseForm");
    quePer = $("#quePer");
    prePer = $("#prePer");
    repPer = $("#repPer");
    courseItems = $(".courseItem");
    courseLimitBtn = $("#courseLimit");
    courseConflictBtn = $("#courseConflict");
    courseModal = $("#courseModal");
    formContainer = $("#formContainer");
    datetimepicker.datetimepicker({
        format: 'YYYY-MM-D H:mm',
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            up: "fa fa-chevron-up",
            down: "fa fa-chevron-down",
            previous: 'fa fa-chevron-left',
            next: 'fa fa-chevron-right',
            today: 'fa fa-screenshot',
            clear: 'fa fa-trash',
            close: 'fa fa-remove'
        }
    });

    $(".confirm").click(function () {
        var verify = null;
        //var verify = util.verifyWithAlert($(".form"));
        if (verify == null) {
            // var sum = parseInt(prePer.val()) + parseInt(quePer.val()) + parseInt(repPer.val());
            // if (sum !== 100) {
            //     util.showAlert("warning", "成绩权重和非一百", 3);
            //     dropdown(prePer.parents(".dropdown-card"));
            //     prePer.focus();
            //     return;
            // }
            var data = createCourseForm.serializeObject();
            var courseMemberLimits = [];
            $(courseLimitList).each(function () {
                var form = $("#"+this);
                var courseMemberLimit = {};
                courseMemberLimit.courseId = form.find(".courseLimitId").val();
                courseMemberLimit.max = form.find(".courseLimitMax").val();
                courseMemberLimit.min = form.find(".courseLimitMin").val();
                courseMemberLimits.push(courseMemberLimit);
            });
            data.courseMemberLimits = courseMemberLimits;
            $.ajax({
                type: "put",
                url: "/teacher/course",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                success: function () {
                    window.location = '/teacher/courseList';
                },
                error: function () {
                    util.showAlert("danger", "创建失败，未知错误", 3);
                }
            })
        } else {
            dropdown(verify.parents(".dropdown-card"));
            verify.focus();
        }
    });
    $(".dropdown-card").click(function (ev) {
        var offsetY = ev.pageY - $(this).offset().top;
        if (offsetY > 0 && offsetY < 50) {
            toggleDrop($(this));
        }
    });
    datetimepicker.bind("focus", function () {
        $(this).parent().addClass("on-date")
    });
    datetimepicker.bind("blur", function () {
        $(this).parent().removeClass("on-date")
    });

    courseLimitBtn.click(function () {
        state = 0;
    });
    courseConflictBtn.click(function () {
        state = -1;
    });

    courseModal.on("show.bs.modal", function () {
        courseItems.removeClass("hidden");
        switch (state) {
            case -1:
                break;
            case 0:
                courseItems.each(function () {
                    var courseItem = $(this);
                    if (courseLimitList.indexOf(courseItem.attr("data-courseId")) >= 0) {
                        courseItem.addClass("hidden");
                    }
                });
                break;
            default:
                courseItems.each(function () {
                    var courseItem = $(this);
                    if (courseConflictList[state].indexOf(courseItem.attr("data-courseId")) >= 0) {
                        courseItem.addClass("hidden");
                    }
                });
                break;
        }
    });
    $(".choose").click(function () {
        var courseItem = $(this).parents(".courseItem");
        switch (state) {
            case -1:
                break;
            case 0:
                var courseId = courseItem.attr("data-courseId");
                if (courseLimitList.indexOf(courseItem.attr("data-courseId")) < 0) {
                    courseLimitList.push(courseId);
                }
                addCourseLimitDom(courseItem);
                break;
            case 2:
                break;
        }
    });
});

function toggleDrop(card) {
    var content = $(card.find(".body-content"));
    var triangle = $(card.find(".triangle"));
    content.slideToggle();
    if (triangle.hasClass("rightward")) {
        triangle.attr("class", "triangle downward");
    } else {
        triangle.attr("class", "triangle rightward");
    }
}

function dropdown(card) {
    if (card !== undefined) {
        $(card.find(".body-content")).slideDown();
        $(card.find(".triangle")).attr("class", "triangle downward");
    }
}

function addCourseLimitDom(courseItem) {
    console.log(courseItem);
    var row = $(courseLimitDom);
    row.attr("id", courseItem.attr("data-courseId"));
    row.find(".dropdown-card").click(function (ev) {
        var offsetY = ev.pageY - $(this).offset().top;
        if (offsetY > 0 && offsetY < 50) {
            toggleDrop($(this));
        }
    });
    row.find(".course-name").html(courseItem.find(".name").text());
    formContainer.append(row);
}

function addConflictCourseDom() {

}