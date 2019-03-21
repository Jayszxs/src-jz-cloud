<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>欢迎登录</title>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login/login.css"/>
</head>
<body class="text-center login">
<form class="form-signin" id="form" action="login" method="post">
    <img src="img/z.jpg">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <!--  <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus=""> -->
    <input id="username" name="username" class="form-control" placeholder="用户名" value="test">
    <input type="password" id="password" class="form-control" name="password" placeholder="密码" value="123456">
    <!-- <input type="password" id="inputPassword" class="form-control" placeholder="Password" required=""> -->
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <!-- <div id="submit" class="ui fluid large teal submit button login">登录</div> -->
    <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
</form>
</body>
<script src="js/jquery.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
</html>

<script>
    $("#submit").click(function () {
        if ($("#username").val() && $("#password").val()) {
            $("#form").submit();
        }
    });
</script>