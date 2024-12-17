/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.*;

/**
 *
 * @author trhuy
 */
public class database {

    private static Connection con = null;

    public static Connection kn()throws ClassNotFoundException,SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlvdv", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("lỗi ");
        }

        return con;
    }
    public ResultSet getdata()throws ClassNotFoundException,SQLException
    {
        ResultSet rs=null;
        Statement st=null;
        try {
            kn();
            String sql="select * from vdv";
            st=con.createStatement();
            rs=st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
     public boolean check(int mavdv)throws ClassNotFoundException,SQLException
    {
        boolean kq=false;
        ResultSet rs=null;
        Statement st=null;
        try {
            kn();
            String sql="select mavdv from vdv where mavdv="+mavdv;
            st=con.createStatement();
            rs=st.executeQuery(sql);
            kq=rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return kq;
    }
    public static void add(int mavdv, String hoten,int sonamtd,int sohc) throws SQLException
    {
        Statement st=null;
        String sql= "insert into vdv (mavdv, hoten, sonamtd, sohc) values ("+mavdv+",N'"+hoten+"',"+sonamtd+","+sohc+")";
        st=con.createStatement();
        st.executeUpdate(sql);
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con=kn();
        
        if (con != null) {
            System.out.println("Đã sẵn sàng thực hiện các thao tác cơ sở dữ liệu.");
        } else {
            System.out.println("Kết nối thất bại. Vui lòng kiểm tra lại.");
        }
        
    }
     
}
