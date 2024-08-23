<%-- 
    Document   : login.jsp
    Created on : Nov 29, 2023, 2:41:11 PM
    Author     : vinh1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="CSS/login.css"/>
    </head>
    
    <body>
        <div class="login-form">
            <form class="form" action="login" method="post">
                <div class="title">
                    <h1>Banking System</h1>
                </div>
                <div class="form-body">
                    <b>Account</b><br>
                    <input class="input" type="text" name="account" placeholder="Enter Account"><br>
                    <b>Password</b><br>
                    <input class="input" type="password" name="password" placeholder="Enter Password"><br>                    
                    <label>${error}</label>
                    <button class="button">Login</button>
                </div>               

            </form>
        </div>
    </body>
</html>
