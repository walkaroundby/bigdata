package action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;

@Data
public class HelloAction extends ActionSupport {
	private String account;//账号
	private String password;//密码
	// 处理请求
	public String login() throws Exception {
		System.out.println(account);
		System.out.println(password);
		System.out.println("访问到了action，正在处理请求");
		System.out.println("调用service");
		return "success";
	}
	public String next() throws Exception {
		System.out.println("访问到了下一个action，正在处理请求");
		System.out.println("调用下一个service");
		System.out.println(account);
		System.out.println(password);
		return "next";
	}
}