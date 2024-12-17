/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trhuy
 */
@WebServlet(name = "themvdv", urlPatterns = {"/themvdv"})
public class themvdv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("them.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("add");
        boolean checkkq ;
        database db = new database();

        try {
            int mavdv = Integer.parseInt(request.getParameter("mavdv"));
            String hoten = (request.getParameter("hoten"));
            int sohc = Integer.parseInt(request.getParameter("sohc"));
            int sonamtd = Integer.parseInt(request.getParameter("sonamtd"));
            switch (action) {
                case "add":
                    checkkq=db.check(mavdv);
                    if(checkkq)
                    {
                        request.setAttribute("error", "đã tồn tại mã ");
                        request.getRequestDispatcher("them.jsp").forward(request, response);
                    }
                    else
                    {
                     db.add(mavdv, hoten, sonamtd, sohc);
                     response.sendRedirect("svqlvdv");
                    }
                    break;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(themvdv.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
