/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.vdv;

/**
 *
 * @author trhuy
 */
@WebServlet(name = "svqlvdv", urlPatterns = {"/svqlvdv"})
public class svqlvdv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        database db = new database();
        ResultSet rs = null;
        HttpSession ss = request.getSession();
        List<vdv> list = new ArrayList<>();
        try {
            rs = db.getdata();
            while (rs.next()) {
                int mavdv = rs.getInt("mavdv");
                String hoten = rs.getString("hoten");
                int sonamtd = rs.getInt("sonamtd");
                int sohc = rs.getInt("sohc");
                list.add(new vdv(mavdv, hoten, sohc, sonamtd));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        ss.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("themvdv");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
