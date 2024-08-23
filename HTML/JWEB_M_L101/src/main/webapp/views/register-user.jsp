<%-- 
    Document   : register-user
    Created on : Nov 16, 2023, 2:55:07 PM
    Author     : vinh1
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register-user.css">
        <title>Register form</title>
    </head>
    <body>
        <form  action="<%=request.getContextPath()%>/register" method="post"
               onsubmit="return validateRegister()" name="frm-register">
            <h1>USER DETAIL</h1>
            <div class="form-body" >
                <div class="form-row">
                    <span class="form-span" >First Name<strong>*</strong></span>
                    <input type="text" id="firstName" name="firstName" value="${user.getFirstName()}"><br/>
                </div>
                <div class="form-row">
                    <span class="form-span">Last Name<strong>*</strong></span>
                    <input type="text" id="lastName" name="lastName" value="${user.getLastName()}"><br/>

                </div>
                <div class="form-row">
                    <span class="form-span">Email<strong>*</strong></span>
                    <input type="text" id="email" name="email" value="${user.getEmail()}"><br/>

                </div>
                <div class="form-row">
                    <span class="form-span">User Name<strong >*</strong></span>
                    <input type="text" id="userName" name="userName" value="${user.getUserName()}"><br/>

                </div>
                <div class="form-row">
                    <span class="form-span">Password<strong>*</strong></span>
                    <input type="password" id="password" name="password"  value="${user.getPassword()}"><br/>

                </div>
                <div class="form-row">
                    <span class="form-span">Confirm Password<strong>*</strong></span>
                    <input type="password" id="confirmPassword" name="confirmPassword"><br/>

                </div>
                <div class="form-row">
                    <button class="btn-submit" type="submit">Register</button>
                    <span class="form-span" >${error}</span>
                </div>
            </div>            
        </form>
        <div class="table">
            <h3>User List</h3>
            <table class="table-body" id="tbl-result" >
                <thead>
                <th style="width: 5%">No</th>
                <th style="width: 20%">First Name</th>
                <th style="width: 20%">Last Name</th>
                <th style="width: 40%">Email</th>
                <th style="width: 15%">Username</th>
                </thead>
                <tbody>
                    <c:set var="counter" value="1" />
                    <c:if test="${listUser != null && !empty listUser}">
                        <c:forEach items="${listUser}" var="item">
                            <tr>
                                <td class="text-center" style="border: solid 1px black;">${counter}</td>
                                <td class="text-center" style="border: solid 1px black;">${item.getFirstName()}</td>
                                <td class="text-center" style="border: solid 1px black;">${item.getLastName()}</td>
                                <td class="text-center" style="border: solid 1px black;">${item.getEmail()} </td>
                                <td class="text-center" style="border: solid 1px black;">${item.getUserName()}</td>                                
                            </tr>
                            <c:set var="counter" value="${counter + 1}" />
                        </c:forEach>
                    </c:if>
                </tbody>

            </table>
        </div>        
        <script src="${pageContext.request.contextPath}/js/register-user.js"></script>
        
        <script>
            
                   document.addEventListener("DOMContentLoaded", function () {
                       validateRegister();
                   });
        </script>
    </body>
</html>

