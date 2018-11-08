package gxlg.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gxlg.model.User;
import gxlg.service.IUserService;

public class testApp {

	@Test
	public void test1(){
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("/applicationContext.xml");
		System.out.println(context.getBean("dataSource"));
		IUserService service = (IUserService) context.getBean("userService");
		User user = new User("123","123",null,null);
		System.out.println(service.register(user));
		
	}
}
