<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="apple-touch-icon" sizes="76x76" href="/imgs/apple-icon.png">
    <link rel="icon" type="image/png" href="/imgs/favicon.png">
    <link rel="stylesheet" href="/css/material-kit.css?v=2.0.4">
    <link rel="stylesheet" href="/css/seminar/admin.css">
    <link rel="stylesheet" href="/icon/icon.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/seminar/adminTeacher.js"></script>
    <title>登录</title>
</head>
<body class="iframe-page">

<nav class="navbar navbar-default navbar-expand-lg">
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">
                    姓名
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <h6 class="dropdown-header">筛选</h6>
                    <a class="dropdown-item">姓名</a>
                    <a class="dropdown-item">工号</a>
                </div>
            </li>
        </ul>
        <form class="form-inline">
            <div class="form-group no-border">
                <input type="text" class="form-control" placeholder="搜索">
            </div>
            <button type="button" class="btn btn-white btn-just-icon btn-round">
                <i class="material-icons">search</i>
            </button>
        </form>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <button class="btn btn-primary">
                    <i class="material-icons">note_add</i>
                    创建
                </button>
            </li>
            <li class="nav-item">
                <button class="btn btn-danger">
                    <i class="material-icons">delete</i>
                    删除
                </button>
            </li>
        </ul>
    </div>
</nav>

<div class="page-body">
    <div class="card">
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>名字</th>
                    <th>工号</th>
                    <th>邮箱</th>
                    <th>激活状态</th>
                </tr>
                </thead>
                <#if teachers?size == 0>
                <tbody>
                空
                </tbody>
                <#else >
                    <tbody>
                    <#assign i = 0>
                    <#list teachers as teacher>
                    <#assign i = i+1>
                    <tr>
                        <td>${i}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.badgeNum}</td>
                        <td>${teacher.email}</td>
                        <td>
                            <#if teacher.activated>
                                已激活
                            <#else >
                                未激活
                            </#if>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </#if>
            </table>
        </div>
    </div>
</div>

<!--   Core JS Files   -->
<script src="/js/core/popper.min.js" type="text/javascript"></script>
<script src="/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="/js/material-kit.js?v=2.0.4" type="text/javascript"></script>
</body>
</html>