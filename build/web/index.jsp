<%-- 
    Document   : index
    Created on : Dec 9, 2024, 3:04:57 PM
    Author     : trhuy
--%>

<%@page import="model.vdv"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hiện thông tin</h1>
        <form action="svqlvdv" method="get">
            <table border="1">
                <thead>
                    <tr>
                        <td>Mã vận động viên</td>
                        <td>Họ tên động viên</td>
                        <td>Số lần thi đấu</td>
                        <td>Số huân chương</td>
                        <td>Tiền thưởng</td>
                    </tr>
                </thead>
                <%List<vdv> list = (List<vdv>) session.getAttribute("list");
                    if (list != null && !list.isEmpty()) {
                        for (vdv v : list) {

                %>
                <tbody>
                    <tr>
                        <td><%= v.getMavdv() %></td>
                        <td><%= v.getHoten()%></td>
                        <td><%= v.getSonamtd()%></td>
                        <td><%= v.getSohc()%></td>
                        <td><%= v.getTienthuong()%></td>
                    </tr>
                </tbody>
                <%}
                    } else {

                    %>
                    <p>Không tìm thấy vận động viên</p>
                    <%}%>
            </table>
           
        </form>
            <form action="svqlvdv" method="post">
                <input type="submit" value="thêm" />
            </form>
    </body>
</html>
