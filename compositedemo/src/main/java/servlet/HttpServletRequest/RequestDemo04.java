package servlet.HttpServletRequest;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Luo
 * post方式提交数据产生乱码的情况
 */

public class RequestDemo04 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RequestDemo04() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 *
		 * 对于以get方式传输的数据，request即使设置了以指定的编码接收数据也是无效的，默认的还是使用ISO8859-1这个字符编码来接收数据
		 */
		String userName = request.getParameter("userName");//接收数据
		//获取request对象以ISO8859-1字符编码接收到的原始数据的字节数组，然后通过字节数组以指定的编码构建字符串，解决乱码问题
		userName =new String(userName.getBytes("ISO8859-1"), "UTF-8") ;
		System.out.println("userName："+userName);
		response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
		outputStream.write(userName.getBytes("UTF-8"));

	}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 客户端是以UTF-8编码传输数据到服务器端的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
		 */
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		System.out.println("userName："+userName);
		response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
		outputStream.write(userName.getBytes("UTF-8"));
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
