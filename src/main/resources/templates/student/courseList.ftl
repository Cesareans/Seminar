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
    <script src="/static/js/student/courseList.js"></script>
    <title>课程</title>
</head>
<body class="card-page sidebar-collapse">
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark">
    <div class="container">
        <div class="navbar-translate">
            <a class="btn btn-link btn-fab btn-round" onclick="window.location='/student/index'">
                <i class="material-icons">arrow_back_ios</i>
            </a>
            <a class="navbar-brand">课程</a>
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
                    <a class="nav-link">
                        <i class="material-icons">person</i>个人首页
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="main main-raised no-footer">
    <div class="container">
        <div class="row">
            <#list klasses as klass>
                <#if klass.course??>
                    <div class="col-md-6">
                        <div class="card content-card">
                            <div class="card-body" data-courseID="${klass.course.id}" data-klassId="${klass.id}">
                                <div class="body-header flex-space-between">
                                    <div class="body-title"
                                         style="text-align: left;font-size: 20px">${klass.course.courseName}</div>
                                    <div class="body-title"
                                         style="text-align: right;font-size: 12px">${klass.klassName}</div>
                                </div>
                                <div class="body-content">
                                    <hr>
                                    <div class="row">
                                        <div class="col-md-12 ml-auto mr-auto">
                                            <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                <li class="nav-item seminar-nav">
                                                    <a class="nav-link">
                                                        <i class="material-icons">event_note</i>
                                                        讨论课
                                                    </a>
                                                </li>
                                                <li class="nav-item team-nav">
                                                    <a class="nav-link">
                                                        <i class="material-icons">group</i>
                                                        组队
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12 ml-auto mr-auto">
                                            <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                                <li class="nav-item info-nav">
                                                    <a class="nav-link">
                                                        <i class="material-icons">description</i>
                                                        课程信息
                                                    </a>
                                                </li>
                                                <li class="nav-item grade-nav">
                                                    <a class="nav-link">
                                                        <i class="material-icons">equalizer</i>
                                                        成绩
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#if>
            </#list>
        </div>
    </div>
</div>
<form hidden id="courseIdForm" method="post">
    <input id="courseIdInput" name="courseId" placeholder="">
    <input id="klassIdInput" name="klassId" placeholder="">
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