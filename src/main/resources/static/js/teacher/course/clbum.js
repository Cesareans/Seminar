var clbumModal;
$(function () {
    clbumModal = $("#clbumModal");

    clbumModal.on("show.bs.modal",function (event) {
        var item = $(event.relatedTarget);
        clbumModal.attr("data-clbumID", item.attr("data-clbumID"));
        $(clbumModal.find(".modal-title")).html($(item.find(".body-title")).html());
    });
});