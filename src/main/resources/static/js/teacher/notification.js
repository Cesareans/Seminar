var dropdownCard;
$(function () {
    dropdownCard = $(".dropdown-card");

    dropdownCard.click(function (ev) {
        var offsetY = ev.pageY - $(this).offset().top;
        if(offsetY>0&&offsetY<165){
            $(this).find(".operation-div").slideToggle();
            dropdownCard.not($(this)).find(".operation-div").slideUp();
        }
    });
});
