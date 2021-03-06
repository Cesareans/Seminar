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
    <script src="/static/lib/jquery-3.3.1.js"></script>
    <script src="/static/js/util.js"></script>
    <script>
        window.onbeforeunload = function () {
            util.showLoading();
        }
    </script>
    <style>
        .nav-link {
            padding: 0 !important;
        }
    </style>
    <title>成绩</title>
</head>
<body class="card-page sidebar-collapse">
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark">
    <div class="container">
        <div class="navbar-translate">
            <a class="btn btn-link btn-fab btn-round" onclick="window.location='/teacher/courseList'">
                <i class="material-icons">arrow_back_ios</i>
            </a>
            <div class="navbar-brand brand-title">成绩</div>
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
                    <a class="nav-link" onclick="window.location='/teacher/index'">
                        <i class="material-icons">person</i>个人首页
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="window.location='/teacher/notification'">
                        <i class="material-icons">notifications</i>
                        待办
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="main main-raised">
    <div class="container">
        <div class="row">
            <#list rounds as round>
                <div class="col-md-6">
                    <div class="card content-card">
                        <div class="card-body">
                            <div class="body-header">
                                <div class="body-title">第${round.roundNum}轮</div>
                            </div>
                            <div class="body-content">
                                <hr>
                                <div class="row">
                                    <#list teams as team>
                                        <div class="col-6">
                                            <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                <li class="nav-item" data-toggle="modal"
                                                    data-target="#scoreModal${round.id}-${team.id}">
                                                    <a class="nav-link" style="padding-bottom: 0;">
                                                        <i class="material-icons">equalizer</i>
                                                        ${team.klass.serial}-${team.serial}&nbsp;${team.teamName}
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>

        </div>
    </div>
</div>

<#list rounds as round>
    <#list teams as team>
        <div class="modal fade" id="scoreModal${round.id}-${team.id}">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">${team.klass.serial}-${team.serial}&nbsp;${team.teamName}</h5>
                        <button type="button" class="close" data-dismiss="modal">
                            <i class="material-icons">clear</i>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <#if roundScores[round?index][team.id]??>
                                <div class="grade-area">
                                    <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                        <li class="nav-item">
                                            <a class="nav-link">
                                                <i class="material-icons">mic</i>
                                                展示分
                                                <h6><#if roundScores[round?index][team.id].presentationScore??>${roundScores[round?index][team.id].presentationScore}分<#else >无数据</#if></h6>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link">
                                                <i class="material-icons">comment</i>
                                                提问分
                                                <h6><#if roundScores[round?index][team.id].questionScore??>${roundScores[round?index][team.id].questionScore}分<#else >无数据</#if></h6>
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link">
                                                <i class="material-icons">description</i>
                                                报告分
                                                <h6><#if roundScores[round?index][team.id].reportScore??>${roundScores[round?index][team.id].reportScore}分<#else >无数据</#if></h6>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="vertical-separator"></div>
                                    <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                        <li class="nav-item">
                                            <a class="nav-link">
                                                <i class="material-icons">done_all</i>
                                                总分
                                                <h6><#if roundScores[round?index][team.id].totalScore??>${roundScores[round?index][team.id].totalScore}分<#else >无数据</#if></h6>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            <#else >
                                <div class="empty-tag" style="height: 30%">
                                    <div class="info">
                                        <div class="icon icon-rose flex-center">
                                            <i class="material-icons color-grey">portable_wifi_off</i>
                                        </div>
                                        <h4 class="info-title">该队没有分数记录</h4>
                                    </div>
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</#list>
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