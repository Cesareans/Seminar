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
    $("#clbumNav").click(function () {
        courseIdForm.form.attr("action", "/teacher/course/clbum");
        courseIdForm.courseIdInput.val(courseModal.attr("data-courseID"));
        courseIdForm.form.submit();
    });
});