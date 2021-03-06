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
        $(function () {
            $("#courseIdInput").val(sessionStorage.getItem("courseId"));
            $("#enterSeminar").click(function () {
                $("#ksIdForm").submit();
            });
            $("#backBtn").click(function () {
                $("#courseIdForm").submit();
            })
        });
    </script>
    <title>讨论课信息</title>
</head>
<body class="card-page sidebar-collapse">
<nav class="navbar navbar-color-on-scroll navbar-expand-lg bg-dark">
    <div class="container">
        <div class="navbar-translate">
            <a class="btn btn-link btn-fab btn-fab-mini btn-round" id="backBtn">
                <i class="material-icons">arrow_back_ios</i>
            </a>
            <div class="navbar-brand brand-title">讨论课信息</div>
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
<div class="container" style="margin-top: 40px">
    <div class="row">
        <div class="col-md-10 ml-auto mr-auto">
            <div class="card seminar-card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-9" style="display: flex;align-items: center">
                            <h4 class="card-title" style="margin-top: 0">${klassSeminar.seminar.theme}</h4>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="container">
                        <div class="col-md-10 ml-auto mr-auto">
                            <div class="line content-line">
                                <label style="width: 20%">课程要求</label>
                                <div style="width: 5%" class="sep"></div>
                                <div style="width: 75%" class="content">${klassSeminar.seminar.content}</div>
                            </div>
                            <div class="line" style="margin-top: 50px">
                                <label>状态</label>
                                <div class="sep"></div>
                                <div class="content" style="justify-content: center">
                                    <#if klassSeminar.state == 0>
                                        <span class="badge badge-pill badge-success">尚未开始</span>
                                    <#elseif klassSeminar.state == 1>
                                        <span class="badge badge-pill badge-warning">正在进行</span>
                                    <#else>
                                        <span class="badge badge-pill badge-secondary">已经结束</span>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="col-md-12 flex-space-around" style="margin-bottom: -49px">
                        <button class="btn btn-fab btn-fab-mini btn-round btn-lg bg-dark" id="enterSeminar">
                            <i class="material-icons">arrow_forward_ios</i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<form hidden id="ksIdForm" method="post" action="/student/course/seminar/progressing">
    <input placeholder="" name="klassId" value="${klassSeminar.klassId}">
    <input placeholder="" name="seminarId" value="${klassSeminar.seminar.id}">
</form>
<form hidden id="courseIdForm" method="post" action="/student/course/seminarList">
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