var courseModal;
$(function () {
    courseModal = $("#courseModal");

    courseModal.on("show.bs.modal",function (event) {
        var item = $(event.relatedTarget);
        courseModal.attr("data-courseID", item.attr("data-courseID"));
        $(courseModal.find(".modal-title")).html($(item.find(".body-title")).html());
    });
    $("#clbumNav").click(function () {
        window.location = "/teacher/course/clbum";
    });
});