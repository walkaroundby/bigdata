package servlet.HttpServletRequest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Luo
 * 利用request实现转发
 */
public class RequestDemo05 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String data="这是请求到RequestDemo05时加入的数据";
        /**
         * 将数据存放到request对象中,此时把request对象当作一个Map容器来使用
         */
        request.setAttribute("data", data);
        //客户端访问RequestDemo06这个Servlet后，RequestDemo06通知服务器将请求转发(forward)到test.jsp页面进行处理
        request.getRequestDispatcher("/forward.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}