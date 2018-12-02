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
    <script src="/static/js/jquery-3.3.1.js"></script>
    <script src="/static/js/seminar/util.js"></script>
    <script src="/static/js/seminar/teacher/course.js"></script>
    <title>首页</title>
</head>
<body class="card-page sidebar-collapse">
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark" id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand">课程页</a>
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
                <li class="nav-item">
                    <a class="nav-link">
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
            <#if courses?size ==0>
                <div>空荡荡的</div>
            <#else>
            <#list courses as course>
            <div class="col-lg-4 col-md-6">
                <div class="card content-card">
                    <div class="card-body" data-courseID="${course.id}" data-toggle="modal" data-target="#courseModal">
                        <div class="body-header">
                            <div class="body-title">${course.courseName}</div>
                        </div>
                        <div class="body-content">
                            <hr>
                            <div class="line">
                                <label>班级数</label>
                                <div class="sep"></div>
                                <div class="content">3</div>
                            </div>
                            <div class="line">
                                <label>分组数</label>
                                <div class="sep"></div>
                                <div class="content">19</div>
                            </div>
                            <div class="line">
                                <label>待完成讨论课</label>
                                <div class="sep"></div>
                                <div class="content">3</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </#list>
            </#if>
        </div>
    </div>
</div>
<div class="container foot-container flex-center">
    <button onclick="window.location='/teacher/course/create'" class="btn btn-dark btn-round bg-dark" style="margin: 0">
        <i class="material-icons">add_circle</i>
        创建课程
    </button>
</div>
<form hidden id="courseIdForm">
    <input id="courseIdInput" name="courseId" title="">
</form>
<div class="modal fade" id="courseModal" data-courseID="">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"></h5>
                <button type="button" class="close" data-dismiss="modal">
                    <i class="material-icons">clear</i>
                </button>
            </div>
            <div class="modal-body" style="margin-top: 20px;margin-bottom: 10px;">
                <div class="row">
                    <div class="col-md-12 ml-auto mr-auto">
                        <ul class="nav nav-pills nav-pills-icons flex-center">
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons">description</i>
                                    课程信息
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 ml-auto mr-auto">
                        <ul class="nav nav-pills nav-pills-icons flex-space-around">
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons" id="seminarNav">event_note</i>
                                    讨论课
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons" id="clbumNav">class</i>
                                    班级
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons" id="teamNav">group</i>
                                    分组
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 ml-auto mr-auto">
                        <ul class="nav nav-pills nav-pills-icons flex-space-around">
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons">tune</i>
                                    讨论课设置
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons">equalizer</i>
                                    成绩
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons">share</i>
                                    课程共享
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--   Core JS Files   -->
<script src="/static/js/core/popper.min.js" type="text/javascript"></script>
<script src="/static/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="/static/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="/static/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/static/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="/static/js/material-kit.js?v=2.0.4" type="text/javascript"></script>
</body>
</html>