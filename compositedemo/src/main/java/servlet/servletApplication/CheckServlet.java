package servlet.servletApplication;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author gacl
 * 服务器端接收到验证码后的处理
 */
public class CheckServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clientCheckcode = request.getParameter("validateCode");//接收客户端浏览器提交上来的验证码
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码
        ServletContext context = this.getServletContext();
        response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流

        if (clientCheckcode.equals(serverCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            System.out.println("验证码验证通过！");
            outputStream.write("验证码验证通过！".getBytes("UTF-8"));
        }else {
            System.out.println("验证码验证失败！");
            outputStream.write("验证码验证失败！".getBytes("UTF-8"));
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}