package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by minchina on 14-12-23.
 */
public class ToDoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet展示页</title></head>");
        out.println("<body>name:毛宁川" + "<br/> sex:male " +"</body>");
        out.println("</html>");
    }
}
