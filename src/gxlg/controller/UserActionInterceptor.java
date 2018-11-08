package gxlg.controller;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class UserActionInterceptor extends AbstractInterceptor{
	
	private static final long serialVersionUID = 7938788028043957253L;

	//拦截器方法
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获得请求相关的ActionContext实例
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		
		String  username = (String) session.get("p.username");
		
		if (username!=null && username.isEmpty()) {
			//正常继续调用action
			return invocation.invoke();
		}else{
			//如果session中没有当前用户信息，则终止调用action，并转向登录页面
			return Action.LOGIN;
		}
	}
	
}
