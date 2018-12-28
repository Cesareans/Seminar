<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="apple-touch-icon" sizes="76x76" href="/static/imgs/apple-icon.png">
    <link rel="icon" type="image/png" href="/static/imgs/favicon.png">
    <link rel="stylesheet" href="/static/css/material-kit.css?v=2.0.4">
    <link rel="stylesheet" href="/static/css/user.css">
    <link rel="stylesheet" href="/static/css/icon.css">
    <link rel="stylesheet" href="/static/css/countup.css">
    <script src="https://cdn.bootcss.com/sockjs-client/1.3.0/sockjs.js"></script>
    <script src="/static/lib/stomp.js"></script>
    <script src="/static/lib/jquery-3.3.1.js"></script>
    <script src="/static/lib/countup.js"></script>
    <script src="/static/js/util.js"></script>
    <script src="/static/js/student/course/seminar/progressing.js"></script>
    <title>进行讨论课</title>
</head>
<body class="card-page sidebar-collapse" data-state="${state}">
<div class="alert-area"></div>
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark">
    <div class="container">
        <div class="navbar-translate">
            <a class="btn btn-link btn-fab btn-round" id="backBtn">
                <i class="material-icons">arrow_back_ios</i>
            </a>
            <div class="navbar-brand brand-title">讨论课</div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <!--All are needed here. Please do not remove anything.-->
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" onclick="window.location='/student/index'">
                        <i class="material-icons">person</i>个人首页
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<#if state = -1>
<div class="main main-raised no-footer">
    <div class="empty-tag">
        <div class="info">
            <div class="icon icon-rose flex-center">
                <i class="material-icons color-grey">access_time</i>
            </div>
            <h4 class="info-title">您在该课程下还未组队</h4>
        </div>
    </div>
</div>
<#elseif state = 0>
    <div class="main main-raised no-footer">
        <div class="empty-tag">
            <div class="info">
                <div class="icon icon-rose flex-center">
                    <i class="material-icons color-grey">access_time</i>
                </div>
                <h4 class="info-title">该讨论课尚未开始</h4>
            </div>
        </div>
    </div>
<#elseif state = 2>
    <div class="main main-raised no-footer">
        <div class="empty-tag">
            <div class="info">
                <div class="icon icon-rose flex-center">
                    <i class="material-icons color-grey">timer_off</i>
                </div>
                <h4 class="info-title">该讨论课已经结束</h4>
            </div>
        </div>
    </div>
<#else >
    <div id="data" data-ksId="${ksId}" data-studentNum="${studentNum}" data-teamId="${team.id}"></div>
    <div class="left-side side-raised">
        <#list monitor.attendanceList as enroll>
            <#if enroll??>
                <button data-idx="${enroll?index}" data-tab="#tab${enroll.id}" data-teamName="${enroll.team.teamName}"
                        class="btn btn-fab btn-round btn-team <#if (enroll?index < monitor.onPreAttendanceIndex)>passed-team<#elseif (enroll?index = monitor.onPreAttendanceIndex)>active-team<#else>preparatory-team</#if>">
                    ${enroll.team.serial}
                </button>
            </#if>
        </#list>
    </div>
    <div class="right-upper-side side-raised">
        <button id="questionCount" class="btn btn-fab btn-round btn-team static-question" disabled>
            ${monitor.raisedQuestionsCount}
        </button>
    </div>
    <div class="right-downer-side side-raised">
        <div id="tabContent">
            <#list monitor.attendanceList as enroll>
                <#if enroll??>
                    <div data-idx="${enroll?index}" class="tab-pane" id="tab${enroll.id}"
                         <#if (enroll?index != monitor.onPreAttendanceIndex)>style="display: none" </#if>>
                        <#list monitor.askedQuestion[enroll.id] as question>
                            <button class="btn btn-fab btn-round btn-team question">${question.team.serial}</button>
                        </#list>
                    </div>
                </#if>
            </#list>
        </div>
    </div>
    <div class="flex-center main-area">
        <div class="container">
            <div class="row">
                <div class="col-6 col-md-4 ml-auto mr-auto team-brand">
                    <h3 id="teamName"
                        style="text-align: center;margin-bottom: 0"><#if monitor.onPreAttendance??>${monitor.onPreAttendance.team.teamName}<#else >无正在进行队伍</#if></h3>
                    <hr>
                    <div style="padding-bottom: 10px;display: flex;justify-content: center" >
                        <span id="on" class="badge badge-pill badge-success" style="display: none">进行中</span>
                        <span id="hang" class="badge badge-pill badge-warning">暂停中</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div id="timer"></div>
            </div>
            <div class="row" style="margin-bottom: 103px">
                <div class="col-6 col-md-4 ml-auto mr-auto team-brand" style="background-color: #343a40;">
                    <h3 style="text-align: center;margin-top: 10px;color: #FFFFFF;">${team.teamName}</h3>
                </div>
            </div>
            <div class="row" id="onAsk" style="display: none">
                <div class="col-6 col-md-4 ml-auto mr-auto team-brand" style="background-color: #e91e63;">
                    <h4 style="text-align: center;margin-top: 10px;color: #FFFFFF;">您的提问时间</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="container foot-operation" style="max-width: 100%">
        <div class="row  flex-center" style="flex-direction: column;">
            <div id="operation" class="flex-space-around" style="width: 100%;">
                <button id="raiseQuestion" class="btn bg-dark btn-round btn-lg" style="width: 40%;<#if team.id=monitor.onPreAttendance.teamId> display: none; </#if>">
                    <i class="material-icons">send</i>
                    请求提问
                </button>
            </div>
        </div>
    </div>
</#if>

<form hidden id="returnForm" action="/student/course/seminarList" method="post">
    <input id="courseIdInput" name="courseId" placeholder="">
</form>
<!--   Core JS Files   -->
<script src="/static/lib/core/popper.min.js" type="text/javascript"></script>
<script src="/static/lib/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="/static/lib/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="/static/lib/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/static/lib/plugins/nouislider.min.js" type="text/javascript"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="/static/lib/material-kit.js?v=2.0.4" type="text/javascript"></script>
</body>
</html>