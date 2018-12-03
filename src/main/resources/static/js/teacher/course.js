var courseModal;
var courseIdForm = {};
$(function () {
    courseModal = $("#courseModal");
    courseIdForm.form = $("#courseIdForm");
    courseIdForm.courseIdInput = $("#courseIdInput");

    courseModal.on("show.bs.modal",function (event) {
        var item = $(event.relatedTarget);
        courseModal.attr("data-courseID", item.attr("data-courseID"));
        $(courseModal.find(".modal-title")).html($(item.find(".body-title")).html());
    });
    $("#clbumNav").click({url:"/teacher/course/clbumList"},postCourseId);
    $("#teamNav").click({url:"/teacher/course/teamList"},postCourseId);
    $("#seminarNav").click({url:"/teacher/course/seminarList"}, postCourseId);
});

function postCourseId(e) {
    courseIdForm.form.attr("action", e.data.url);
    courseIdForm.courseIdInput.val(courseModal.attr("data-courseID"));
    courseIdForm.form.submit();
}