var fileNameInput;
var teamIdInput;
var downloadFileForm;

$(function () {
    downloadFileForm = $("#downloadFileForm");
    fileNameInput = $("#fileNameInput");
    teamIdInput = $("#teamIdInput");

    $(".download-file").click(function () {
        fileNameInput.val($(this).attr("data-fileName"));
        teamIdInput.val($(this).attr("data-teamId"));
        downloadFileForm.submit();
    });

    $("#seminarIdInput").val(sessionStorage.getItem("seminarId"));
    $("#klassIdInput").val(sessionStorage.getItem("klassId"));
    $("#backBtn").click(function () {
        $("#seminarForm").submit();
    })
});