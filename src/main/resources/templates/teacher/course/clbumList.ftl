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
    <script src="/static/js/teacher/course/clbum.js"></script>
    <title>首页</title>
</head>
<body class="card-page sidebar-collapse">
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark" id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" onclick="window.location='/teacher/courseList'">
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
        <div class="row">
            <#if clbums?size == 0>
                <div>空荡荡的</div>
            <#else >
                <#list clbums as clbum>
                <div class="col-lg-4 col-md-6">
                    <div class="card content-card">
                        <div class="card-body" data-clbumID="${clbum.id}" data-toggle="modal" data-target="#clbumModal">
                            <div class="body-header">
                                <div class="body-title">${clbum.clbumName}</div>
                            </div>
                            <div class="body-content">
                                <hr>
                                <div class="line">
                                    <label>讨论课时间</label>
                                    <div class="sep"></div>
                                    <div class="content">${clbum.time}</div>
                                </div>
                                <div class="line">
                                    <label>讨论课地点</label>
                                    <div class="sep"></div>
                                    <div class="content">${clbum.location}</div>
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
    <button onclick="window.location='/teacher/course/createClbum'" class="btn btn-dark btn-round bg-dark"
            style="margin: 0">
        <i class="material-icons">add_circle</i>
        创建班级
    </button>
</div>

<div class="modal fade" id="clbumModal">
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
                <div class="row">
                    <div class="col-md-12 ml-auto mr-auto">
                        <ul class="nav nav-pills nav-pills-icons flex-space-around">
                            <li class="nav-item">
                                <a class="nav-link">
                                    <i class="material-icons" style="color: #f44336">delete</i>
                                    删除班级
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