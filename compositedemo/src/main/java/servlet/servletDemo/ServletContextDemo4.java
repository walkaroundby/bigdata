package servlet.servletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Luo
 * 使用ServletContext调用forward方法实现请求转发
 */
public class ServletContextDemo4 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setHeader("content-type","text/html;charset=UTF-8");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>ServletContextDemo4</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ServletContextDemo4 转发功能至ServletContextDemo5");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
//        String data = "<h1><font color='red'>abcdefghjkl</font></h1>";
//        out.write(data);
        ServletContext context = this.getServletContext();//获取ServletContext对象
        RequestDispatcher rd = context.getRequestDispatcher("/ServletContextDemo5");//获取请求转发对象(RequestDispatcher)
        rd.forward(request, response);//调用forward方法实现请求转发
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}