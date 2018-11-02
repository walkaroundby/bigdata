package servlet.servletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ServletContextDemo1");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		String data = "xdp_gacl";
		/**
		 * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
		 * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
		 */
		ServletContext context = this.getServletConfig().getServletContext();//获得ServletContext对象
		context.setAttribute("data", data);  //将data存储到ServletContext对象中
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}