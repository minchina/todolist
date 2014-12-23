package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServiceServlet extends HttpServlet{

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
        String value;
        value = request.getParameter("name");
        response.setCharacterEncoding("utf8");
        PrintWriter out = response.getWriter();
        out.print(value);
    }
}
