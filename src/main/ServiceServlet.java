package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ServiceServlet extends HttpServlet{
    Connection conn = null;
    Statement stmt = null;

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet展示页</title></head>");
        out.println("<body>name:秦凡鹏" + "<br/> sex:male " +"</body>");
        out.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{


        PrintWriter out =response.getWriter();
        String value = request.getParameter("name");
        response.setCharacterEncoding("utf8");
        JdbcService jd = new JdbcService();
        try {
            jd.insert(value);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.print(value);
    }
}
