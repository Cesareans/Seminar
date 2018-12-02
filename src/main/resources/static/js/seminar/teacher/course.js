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
    $("#clbumNav").click({url:"/teacher/course/clbum"},postCourseId);
    $("#teamNav").click({url:"/teacher/course/team"},postCourseId);
    $("#seminarNav").click({url:"/teacher/course/seminar"}, postCourseId);
});

function postCourseId(e) {
    console.log(e.data.url);
    courseIdForm.form.attr("action", e.data.url);
    courseIdForm.courseIdInput.val(courseModal.attr("data-courseID"));
    courseIdForm.form.submit();
}