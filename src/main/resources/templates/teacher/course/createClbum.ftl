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
    <script src="/static/js/teacher/course/createClbum.js"></script>
    <title>首页</title>
</head>
<body class="card-page sidebar-collapse">
<div class="alert-area"></div>
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark" id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" onclick="window.location='/teacher/course/clbumList'">
                <i class="material-icons">arrow_back_ios</i>
            </a>
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
        <div class="row flex-center">
            <div class="col-md-6">
                <form class="form" id="createCourseForm">
                    <div class="row" style="margin-top: 20px;margin-bottom: 20px;">
                        <div class="col flex-center">
                            <label style="margin-bottom: 0;">班级名称：</label>
                        </div>
                        <div class="col">
                            <input id="username" name="username" type="text" placeholder="年级" autocomplete="off"
                                   class="form-control empty-verify" data-emptyMessage="请输入年级">
                        </div>
                        <div class="col">
                            <input id="username" name="username" type="text" placeholder="班级" autocomplete="off"
                                   class="form-control empty-verify" data-emptyMessage="请输入班级">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div id="groupCard" class="card form-card dropdown-card">
                                <div class="card-body">
                                    <div class="body-header">
                                        <div class="body-title">班级简介</div>
                                        <div class="flex-center">
                                            <div class="triangle downward"></div>
                                        </div>
                                    </div>
                                    <div class="body-content">
                                        <hr>
                                        <div class="line">
                                            <label for="groupStart">讨论课时间</label>
                                            <div class="sep"></div>
                                            <div class="content">
                                                <div class="form-group bmd-form-group">
                                                    <input id="groupStart" name="groupStart" type="text" autocomplete="off"
                                                           class="form-control empty-verify" data-emptyMessage="请输入讨论课时间">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="line">
                                            <label for="groupEnd">讨论课地点</label>
                                            <div class="sep"></div>
                                            <div class="content">
                                                <div class="form-group bmd-form-group">
                                                    <input id="groupEnd" name="groupEnd" type="text" autocomplete="off"
                                                           class="form-control empty-verify" data-emptyMessage="请输入讨论课地点">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 ml-auto mr-auto">
                            <ul class="nav nav-pills nav-pills-icons flex-space-around">
                                <li class="nav-item">
                                    <a class="nav-link">
                                        <i class="material-icons">save_alt</i>
                                        导入名单
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container foot-container flex-center">
    <div class="confirm-div">
        <button class="btn btn-dark btn-round bg-dark confirm" style="margin: 0">
            <i class="material-icons">add_circle</i>
            创建
        </button>
    </div>
    <div class="cancel-div">
        <button class="btn btn-danger btn-round cancel" onclick="window.location='/teacher/course/clbum'" style="margin: 0">
            <i class="material-icons">clear</i>
            取消
        </button>
    </div>
</div>
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