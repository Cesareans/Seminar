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
var curSerial = 0;
var courseLimitDom;
var addConflictCourseBtnDom;
var courseNameDom;
var conflictCourseDom;
{
    conflictCourseDom = "\n" +
        "                            <div class=\"col-lg-6 col-md-12 conflict-course\">\n" +
        "                                <div class=\"card form-card dropdown-card\">\n" +
        "                                    <div class=\"card-body\">\n" +
        "                                        <div class=\"body-header\">\n" +
        "                                            <div class=\"body-title\">冲突课程</div>\n" +
        "                                            <div class=\"flex-center\">\n" +
        "                                                <div class=\"triangle rightward\"></div>\n" +
        "                                            </div>\n" +
        "                                        </div>\n" +
        "                                        <div class=\"body-content\" style=\"display: none;\">\n" +
        "                                            <hr style=\"margin-bottom: 20px\">\n" +
        "                                            <div class=\"courseNameList\">\n" +
        "                                                \n" +
        "                                            </div>\n" +
        "                                            <hr>\n" +
        "                                            <div class=\"container flex-center btnAddArea\">\n" +
        "                                                \n" +
        "                                            </div>\n" +
        "                                        </div>\n" +
        "                                    </div>\n" +
        "                                </div>\n" +
        "                            </div>";
    courseNameDom = "<label style=\"width: 100%;text-align: center;font-size: 16px\"></label>";
    addConflictCourseBtnDom = "<a class=\"btn bg-dark conflictCourse\"\n" +
        "                                                   style=\"width: 80%;color: #FFFFFF;\" data-toggle=\"modal\"\n" +
        "                                                   data-target=\"#courseModal\">\n" +
        "                                                    <i class=\"material-icons\">add</i>\n" +
        "                                                    新增课程\n" +
        "                                                </a>";
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
            var conflictCourses = [];
            var conflictCoursesDom = $(".conflict-course");
            for(var i in courseConflictList){
                if(!courseConflictList.hasOwnProperty(i)) continue;
                var conflictCourse = {};
                conflictCourse.serial = conflictCoursesDom.find(".conflictCourse").attr("data-serial");
                conflictCourse.courseId = [];
                $(conflictCoursesDom.find(".courseNameList").children("label")).each(function () {
                    conflictCourse.courseId.push($(this).attr("data-id"));
                });
                conflictCourses.push(conflictCourse);
            }
            data.conflictCourses = conflictCourses;
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
    $(".dropdown-card").click(clickDrop);
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
        var courseId = courseItem.attr("data-courseId");
        switch (state) {
            case -1:
                curSerial += 1;
                addConflictCourseDom(courseItem);
                break;
            case 0:
                if (courseLimitList.indexOf(courseItem.attr("data-courseId")) < 0) {
                    courseLimitList.push(courseId);
                }
                addCourseLimitDom(courseItem);
                break;
            default:
                if (courseConflictList[state].indexOf(courseItem.attr("data-courseId")) < 0) {
                    courseConflictList[state].push(courseId);
                }
                addCourseNameDom(courseItem, state);
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

function clickDrop(ev) {
    var offsetY = ev.pageY - $(this).offset().top;
    if (offsetY > 0 && offsetY < 50) {
        toggleDrop($(this));
    }
}

function addCourseLimitDom(courseItem) {
    var row = $(courseLimitDom);
    row.attr("id", courseItem.attr("data-courseId"));
    row.find('.courseLimitId').val(courseItem.attr("data-courseId"));
    row.find(".dropdown-card").click(clickDrop);
    row.find(".course-name").html(courseItem.find(".name").text());
    formContainer.append(row);
}

function addConflictCourseDom(courseItem) {
    var row = $(conflictCourseDom);
    var rowCourseNameDom = $(courseNameDom);
    rowCourseNameDom.html(courseItem.find(".name").text());
    rowCourseNameDom.attr("data-id", courseItem.attr("data-courseId"));
    row.find(".courseNameList").append(rowCourseNameDom);
    var rowAddConflictCourseDom = $(addConflictCourseBtnDom);
    rowAddConflictCourseDom.attr("data-serial", curSerial);
    rowAddConflictCourseDom.click(function () {
        state = parseInt($(this).attr("data-serial"));
    });
    row.find(".dropdown-card").click(clickDrop);
    row.find(".btnAddArea").append(rowAddConflictCourseDom);
    courseConflictList[curSerial] = [courseItem.attr("data-courseId")];
    formContainer.append(row);
}

function addCourseNameDom(courseItem, serial) {
    var row = $(courseNameDom);
    row.attr("data-id", courseItem.attr("data-courseId"));
    row.html(courseItem.find(".name").text());
    var conflictCourses = $(".conflict-course");
    conflictCourses.eq(serial - 1).find(".courseNameList").append(row);
}