var client = null, timer, ksId, studentNum, teamId;

var questionCount, teams, questions, teamName, onState, hangState, onAsk, raiseQuestionBtn;

var preTimeStamp, progressState = 'PAUSE';

var tabContent, curActive, curOnfocus, curAttendanceIdx;

$(function () {
    timer = $("#timer");
    questionCount = $("#questionCount");
    teams = $(".btn-team");
    questions = $(".btn-team.question");

    teamName = $("#teamName");
    onState = $("#on");
    hangState = $("#hang");
    onAsk = $("#onAsk");
    raiseQuestionBtn = $("#raiseQuestion");

    tabContent = $("#tabContent");
    curActive = curOnfocus = $(".active-team");
    curAttendanceIdx = curActive.attr("data-idx");
    timer.create();

    var data = $("#data");
    ksId = data.attr("data-ksId");
    studentNum = data.attr("data-studentNum");
    teamId = data.attr("data-teamId");
});

function changeFocus(target) {
    var tab = target.attr("data-tab");
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
    if (!curActive.hasClass("question")) {
        changeFocus(curActive);
    }
}

var socketAddr = "/seminar-socket";
var clientAddr = '/topic/client/';
var serverAddr = "/app/student/klassSeminar/";
var socket;
$(function () {
    var seminarState = $("body").attr("data-state");
    if (seminarState === '1') {
        serverAddr += ksId;
        clientAddr += ksId;
        raiseQuestionBtn.click(function () {
            sendRequest("RaiseQuestionRequest", {});
        });
        connect();
    }
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

var SwitchTeamResponse = {attendanceIndex: null, state: null, teamId: null};

function handleSwitchTeamResponse(content) {
    curActive.removeClass("active-team").addClass("passed-team");
    if (content.attendanceIndex < teams.length) {
        var onTeam = teams.eq(content.attendanceIndex);
        curAttendanceIdx = content.attendanceIndex;
        onTeam.removeClass("preparatory-team");
        teamName.text(onTeam.attr("data-teamName"));
        changeActive(onTeam);
    }
    if (content.teamId === teamId) {
        raiseQuestionBtn.hide();
    } else {
        raiseQuestionBtn.show();
    }
    setQuestionCount(0);
    pauseAt(content.state.timeStamp);
}

var PullQuestionResponse = {studentNum: null, teamSerial: null, teamName: null, questionCount: null};

function handlePullQuestionResponse(content) {
    preTimeStamp = timer.getTime();

    teamName.text(content.teamName);
    questionCount.text(content.questionCount);
    startAt(0);
    addQuestion(content.teamSerial);

    console.log(content.studentNum);
    console.log(studentNum);
    if (content.studentNum === studentNum) {
        onAsk.show();
        raiseQuestionBtn.hide();
    }
}

function handleEndQuestionResponse(content) {
    pauseAt(preTimeStamp);
    onAsk.hide();
    raiseQuestionBtn.show();
    changeActive(teams.eq(curAttendanceIdx));
}

function handleScoreResponse(content) {
}

function handleEndSeminarResponse() {
    window.location.reload();
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
    hangState.show();
    onState.hide();
}

function startAt(timeStamp) {
    timer.setTime(timeStamp);
    timer.start();
    progressState = 'PROCESSING';
    onState.show();
    hangState.hide();
}

function addQuestion(teamSerial) {
    var tab = $(curActive.attr("data-tab"));
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
