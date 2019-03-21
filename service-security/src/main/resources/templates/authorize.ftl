<html>
<head>
    <meta charset="utf-8">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>授权中心</title>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/center/authorizationcenter.css"/>
</head>
<body>
<!-- <nav class="navbar navbar-dark bg-dark">
    <h3 class="title">授权中心</h3>
    <h5 class="title">Test</h5>
    <h5 class="title">Test</h5>
</nav> -->
<form id="form" action="${request.contextPath}/oauth/authorize" method='post'>
    <input id="approval" name='user_oauth_approval' value='false' type='hidden'/>
    <input id="approveOrDeny" name='authorize' value='Authorize' type='hidden'/>
    <input id="scope" name='scope.user' value='true' type='hidden'/>
</form>
<main class="container" role="main">
    <div class="jumbotron" id="modal">
        <h1>授权中心</h1>
       <#-- <a href="javascript:void(0)" onclick="changeUser()">[切换账号]</a>
        <span>${userName} &nbsp;|&nbsp;&nbsp;</span></div>-->
    <p class="lead">将允许应用${authorizationRequest.clientId}拥有以下权限： </p>
    <p class="lead"><i class="glyphicon glyphicon-user"></i>获取你的用户信息 </p>
    <div class="pull-right">
        <button type="button" class="btn btn-info" id="ok">允许</button>
        <button type="button" class="btn btn-info" id="no">拒绝</button>
    </div>
</main>
</body>
<script src="${request.contextPath}/js/jquery.js"></script>
<script src="${request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
</html>
<script>
    //$("#modal").modal({closable: false}).modal('show');
    $("#ok").click(function () {
        $("#approval").val("true");
        $("#approveOrDeny").attr("name", "authorize").val("Authorize");
        $("#form").submit();
    });

    $("#no").click(function () {
        $("#approval").val("false");
        $("#approveOrDeny").attr("name", "deny").val("Deny");
        $("#scope").val("false");
        $("#form").submit();
    });

    function changeUser() {
        const getUrlParameters = url =>
            url.match(/([^?=&]+)(=([^&]*))/g).reduce(
                (a, v) => (a[v.slice(0, v.indexOf('='))] = v.slice(v.indexOf('=') + 1), a), {});
        var url = getUrlParameters(window.location.href)['redirect_uri'];
        if (url.indexOf('?') == -1) {
            url += '?logout=yes'
        } else {
            url += '&logout=yes'
        }
        window.location.replace(url)
    }
</script>
