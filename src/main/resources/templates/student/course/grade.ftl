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
            <a class="btn btn-link btn-fab btn-round" onclick="window.location='/student/courseList'">
                <i class="material-icons">arrow_back_ios</i>
            </a>
            <div class="navbar-brand brand-title">课程成绩</div>
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
<div class="main main-raised">
    <div class="container">
        <div class="row">
            <#if hasGrade>
                <#list rounds as round>
                    <div class="col-lg-12">
                        <div class="card content-card">
                            <div class="card-body">
                                <div class="body-header">
                                    <div class="body-title">第${round.roundNum}轮</div>
                                </div>
                                <div class="body-content">
                                    <hr>
                                    <#if roundScoreMap[round.id]??>
                                        <div class="row">
                                            <div class="grade-area">
                                                <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                    <li class="nav-item">
                                                        <a class="nav-link">
                                                            <i class="material-icons">mic</i>
                                                            展示分
                                                            <h6><#if roundScoreMap[round.id].presentationScore??>${roundScoreMap[round.id].presentationScore}分<#else >无数据</#if></h6>
                                                        </a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link">
                                                            <i class="material-icons">comment</i>
                                                            提问分
                                                            <h6><#if roundScoreMap[round.id].questionScore??>${roundScoreMap[round.id].questionScore}分<#else >无数据</#if></h6>
                                                        </a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link">
                                                            <i class="material-icons">description</i>
                                                            报告分
                                                            <h6><#if roundScoreMap[round.id].reportScore??>${roundScoreMap[round.id].reportScore}分<#else >无数据</#if></h6>
                                                        </a>
                                                    </li>
                                                </ul>
                                                <div class="vertical-separator"></div>
                                                <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                    <li class="nav-item">
                                                        <a class="nav-link">
                                                            <i class="material-icons">done_all</i>
                                                            总分
                                                            <h6><#if roundScoreMap[round.id].totalScore??>${roundScoreMap[round.id].totalScore}分<#else >无数据</#if></h6>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    <#else >
                                        <div class="row">
                                            <div class="grade-area">
                                                <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                    <li class="nav-item">
                                                        <a class="nav-link">
                                                            <i class="material-icons">cancel</i>
                                                            无数据
                                                        </a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </#if>
                                    <hr>
                                    <div class="row">
                                        <#list round.seminars as seminar>
                                            <div class="col-6">
                                                <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                    <li class="nav-item" data-toggle="modal"
                                                        data-target="#seminarScoreModal${seminar.id}">
                                                        <a class="nav-link" style="padding-bottom: 0;">
                                                            <i class="material-icons">equalizer</i>
                                                            ${seminar.theme}
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
            <#else >
                <div class="empty-tag" style="height: 50%">
                    <div class="info">
                        <div class="icon icon-rose flex-center">
                            <i class="material-icons color-grey">portable_wifi_off</i>
                        </div>
                        <h4 class="info-title">您未加入任何队伍</h4>
                    </div>
                </div>
            </#if>
        </div>
    </div>
</div>

<#if hasGrade>
    <#list rounds as round>
        <#list round.seminars as seminar>
            <div class="modal fade" id="seminarScoreModal${seminar.id}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">${seminar.theme}</h5>
                            <button type="button" class="close" data-dismiss="modal">
                                <i class="material-icons">clear</i>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <#if seminarScoreMap[seminar.id]??>
                                    <div class="grade-area">
                                        <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                            <li class="nav-item">
                                                <a class="nav-link">
                                                    <i class="material-icons">mic</i>
                                                    展示分
                                                    <h6><#if seminarScoreMap[seminar.id].presentationScore??>${seminarScoreMap[seminar.id].presentationScore}分<#else >无数据</#if></h6>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link">
                                                    <i class="material-icons">description</i>
                                                    提问分
                                                    <h6><#if seminarScoreMap[seminar.id].questionScore??>${seminarScoreMap[seminar.id].questionScore}分<#else >无数据</#if></h6>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link">
                                                    <i class="material-icons">done_all</i>
                                                    报告分
                                                    <h6><#if seminarScoreMap[seminar.id].reportScore??>${seminarScoreMap[seminar.id].reportScore}分<#else >无数据</#if></h6>
                                                </a>
                                            </li>
                                        </ul>
                                        <div class="vertical-separator"></div>
                                        <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                            <li class="nav-item">
                                                <a class="nav-link">
                                                    <i class="material-icons">settings</i>
                                                    总分
                                                    <h6><#if seminarScoreMap[seminar.id].totalScore??>${seminarScoreMap[seminar.id].totalScore}分<#else >无数据</#if></h6>
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
                                            <h4 class="info-title">您没有参与该讨论课</h4>
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
</#if>
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