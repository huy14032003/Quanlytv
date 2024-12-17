<%-- 
    Document   : them
    Created on : Dec 9, 2024, 3:56:38 PM
    Author     : trhuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thêm vận động viên!</h1>
        <form action="themvdv" method="post">
            <input type="hidden" name="add" value="add">
            <input type="text" name="mavdv" placeholder="mã vận dộng viên">;
            <input type="text" name="hoten" placeholder="họ tên">;
            <input type="text" name="sonamtd" placeholder="số năm thi đấu">;
            <input type="text" name="sohc" placeholder="số huân chương">;
            
            <input type="submit" value="Thêm" />  
            <% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
    <div class="error-message"><%= error %></div>
<% } %>
        </form>
    </body>
</html>
