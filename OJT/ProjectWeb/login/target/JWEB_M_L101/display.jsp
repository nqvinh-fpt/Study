<%-- 
    Document   : display
    Created on : Nov 28, 2023, 11:20:30 AM
    Author     : vinh1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table-body" id="tbl-result" >
                                <thead>
                                <th style="width: 10%">ID</th>
                                <th style="width: 50%">Tên</th>
                                <th style="width: 10%">Số lượng</th>
                                <th style="width: 35%">Đơn giá</th>
                                </thead>
                                <tbody>


                                    <c:forEach items="${data}" var="item">
                                        <tr>
                                            <td>${item.getID()}</td>
                                            <td>${item.getName()}</td>
                                            <td>${item.getQl()}</td>
                                            <td>${item.getPrice()}</td> 
                                        </tr>

                                    </c:forEach>

                                </tbody>

                            </table>
    </body>
</html>
