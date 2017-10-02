<#import "layout.ftl" as u>
<@u.page title="/users/login">

<form action="http://localhost:8090/users/login" method="post">
    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
    <div>
        <label for="username">Email address</label>
        <input type="text" name="login" id="login" required autofocus>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me">
    </div>
    <button type="submit">Sign in</button>
</form>

</@u.page>