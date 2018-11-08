package gxlg.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import gxlg.model.User;
import gxlg.service.IUserService;


public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -4159947880372603934L;
	// 请求参数
	//请求参数的接收：使用属性驱动，创建实体类，在action中创建实体类对象
	//并提供setter和getter方法，form中的name名，是对象名.实体类中的属性名
	//创建一个对象user对象
	private User user;
	//为该对象提供setter和getter方法，没有将会抛出异常
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	// 请求处理
	//这里使用的是设置注入
	//第一：调用IUserDao的默认构造函数创建一个对象
	private IUserService userService;
	//第二：为该对象提供setter和getter方法，没有将会抛出异常
	public IUserService getUserService() {
		return userService;
	}
	//使用setter将值注入属性值
	//在配置文件中要使用<bean>元素的<property>子元素来为每个属性注入值
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/*注册*/
	public String register() throws Exception{
		User u = userService.findUser(user.getUsername());
		System.out.println(user);
		if (u==null) {
			boolean val = userService.register(user);
			if (val) {
				System.out.println("注册成功！");
				return SUCCESS;
			}else{
				System.out.println("注册失败！");
				return ERROR;			
			}
		}else{
			this.addFieldError("error.username", "用户名已存在！");
			return ERROR;
		}	
	}
		
	/*登录*/
	public String login() throws Exception{
		System.out.println(user.getUsername());
		User u = userService.findUser(user.getUsername());
		System.out.println(u);
		if (u!=null) {
			if (user.getPassword().equals(u.getPassword())) {
				Map<String,Object> session = ActionContext.getContext().getSession();
				session.put("user.username", user.getUsername());
				System.out.println("登录成功");
				return SUCCESS;
			}else{
				System.out.println("登录失败");
				ActionContext context = ActionContext.getContext();
				context.put("error","用户名或密码错误");
				return ERROR;
			}
		}else{
			return ERROR;
		}	
	}
	
	
	/*修改密码*/
	public String repassword() {
		Map<String,Object> session = ActionContext.getContext().getSession();
		User u = userService.findUser((String) session.get("user.username"));
		System.out.println(u);
		System.out.println(user);
		if (u!=null) {
			if (user.getPassword().equals(u.getPassword())) {
				u.setPassword(user.getNewpassword());
				userService.update(u);
				System.out.println("修改成功");
				return SUCCESS;
			}else{
				this.addFieldError("error.password", "旧密码不正确！");
				return ERROR;
			}
		}else{
			return ERROR;
		}	
	}
	
	
	/*找回密码*/
	public String retake(){
		User u = userService.findUser(user.getUsername());
		System.out.println(u);
		if (u!=null) {
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("user.username", u.getUsername());
			session.put("user.password", u.getPassword());
			return "toretake";
		}else{
			return ERROR;
		}	
	}

}
