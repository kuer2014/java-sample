<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的登录页</title>
</head>
<body>
<h3>请登录</h3>
<form name="f" action="/login" method="POST">
    <table>
        <tbody><tr><td>User:</td><td><input type="text" name="username" value=""></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
        <tr><td colspan="2"><input name="submit" type="submit" value="Login"></td></tr>
        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
        </tbody></table>
</form>
</body>
</html>