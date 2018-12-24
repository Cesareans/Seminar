var client = null, ksId, timer;

var questionCount, teams, questions, teamName, teamOperation;

var preTimeStamp, preState, progressState = 'PAUSE';

var tabContent, curActive, curOnfocus, curAttendanceIdx;
$(function () {
    timer = $("#timer");
    questionCount = $("#questionCount");
    teams = $(".btn-team");
    questions = $(".btn-team.question");

    teamName = $("#teamName");
    teamOperation = $("#teamOperation");

    tabContent = $("#tabContent");
    curActive = curOnfocus = $(".active-team");
    curAttendanceIdx = curActive.data("idx");
    timer.create();

    ksId = $("body").attr("data-ksId");
});
function changeFocus(target) {
    var tab = target.data("tab");
    tabContent.children(".tab-pane").hide();
    console.log($(tab));
    $(tab).show();
}
function changeActive(target) {
    if (curActive !== undefined) {
        curActive.removeClass("active-team");
    }
    curActive = target;
    curActive.addClass("active-team");
    if(!curActive.hasClass("question")) {
        changeFocus(curActive);
    }
}

var socketAddr = "/seminar-socket";
var clientAddr = '/topic/client/';
var serverAddr = "/app/student/klassSeminar/";
var socket;
$(function () {
    serverAddr += ksId;
    clientAddr += ksId;
    $("#raiseQuestion").click(function () {
        sendRequest("RaiseQuestionRequest", {});
    });
    connect();
});

function connect() {
    socket = new SockJS(socketAddr);
    client = Stomp.over(socket);
    client.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        client.subscribe(clientAddr, function (m) {
            handleResponse(JSON.parse(m.body));
        });
    });
}

function sendRequest(type, request) {
    var requestOnSend = {
        type: type,
        content: JSON.stringify(request)
    };
    client.send(serverAddr, {}, JSON.stringify(requestOnSend));
}

function handleResponse(response) {
    eval("handle" + response.type + "(" + response.content + ")");
}

var SeminarStateResponse = {state: {progressState: null, timeStamp: null}};
function handleSeminarStateResponse(content) {
    if (content.state.progressState === progressState)
        return;
    switch (content.state.progressState) {
        case 'PAUSE':
            pauseAt(content.state.timeStamp);
            break;
        case 'PROCESSING':
            startAt(content.state.timeStamp);
            break;
    }
}

var RaiseQuestionResponse = {questionNum: null};
function handleRaiseQuestionResponse(content) {
    setQuestionCount(content.questionNum);
}

var SwitchTeamResponse = {attendanceIndex: null, state: null};
function handleSwitchTeamResponse(content) {
    curActive.removeClass("active-team").addClass("passed-team");
    if (content.attendanceIndex < teams.length) {
        var onTeam = teams.eq(content.attendanceIndex);
        curAttendanceIdx = content.attendanceIndex;
        onTeam.removeClass("preparatory-team");
        teamName.text(onTeam.attr("data-teamName"));
        changeActive(onTeam);
    }
    setQuestionCount(0);
    pauseAt(content.state.timeStamp);
}

var PullQuestionResponse = {studentId: null, teamId: null, questionCount: null};
function handlePullQuestionResponse(content) {
    preTimeStamp = timer.getTime();
    preState = progressState;

    teamName.text(content.teamName);
    questionCount.text(content.questionCount);
    startAt(0);
    addQuestion(content.teamSerial);
}

function handleEndQuestionResponse(content) {
    pauseAt(preTimeStamp);
    changeActive(teams.eq(curAttendanceIdx));
}
function handleScoreResponse(content) {

}
function setQuestionCount(count) {
    questionCount.removeClass("static-question").addClass("active-question");
    setTimeout(function () {
        questionCount.removeClass("active-question").addClass("static-question");
    }, 1000);
    questionCount.text(count);
}

function pauseAt(timeStamp) {
    timer.setTime(timeStamp);
    timer.pause();
    progressState = 'PAUSE';
    teamOperation.text("暂停中...");
}

function startAt(timeStamp) {
    timer.setTime(timeStamp);
    timer.start();
    progressState = 'PROCESSING';
    teamOperation.text("进行中...");
}

function addQuestion(teamSerial) {
    var tab = $(curActive.data("tab"));
    var btn = $("<button class='btn btn-fab btn-round btn-team question'>" + teamSerial + "</button>");

    tab.append(btn);
    btn.click(function () {
        changeFocus($(this));
    });
    changeActive(btn);
}

$(function () {
    $("#courseIdInput").val(sessionStorage.getItem("courseId"));
    $("#backBtn").click(function () {
        $("#returnForm").submit();
    });
});
