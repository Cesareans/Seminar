var courseModal;
$(function () {
    courseModal = $("#courseModal");

    courseModal.on("show.bs.modal",function (event) {
        var item = $(event.relatedTarget);
        courseModal.attr("data-courseID", item.attr("data-courseID"));
        $(courseModal.find(".modal-title")).html($(item.find(".body-title")).html());
    });
    courseModal.find(".confirm").click(function () {
        $.ajax({
            type:"delete",
            url:"/admin/teacher",
            traditional:true,
            data:{
                badgeNum:bns
            },
            success:function () {
                deleteItemsModal.modal("hide");
                if (groupCheck.hasClass("groupChecked")) {
                    groupCheck.trigger("click");
                }
                $(document).trigger("showNotification", ["删除成功", "success"]);
                sendDataRequest(defaultFilter);
            },
            error:function () {
                util.popWithDelay($(deleteItemsModal.find(".confirm")), "删除失败", 3);
            }
        });
    });
});