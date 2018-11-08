package gxlg.service.impl;

import gxlg.dao.IUserDao;
import gxlg.model.User;

public class UserService implements gxlg.service.IUserService {
	//依赖注入方式：设值注入、构造注入、自动装配
	
	//这里使用的是设置注入
	//第一：调用IUserDao的默认构造函数创建一个对象
	private IUserDao userDao;
	//第二：为该对象提供setter和getter方法，没有将会抛出异常
	public IUserDao getUserDao() {
		return userDao;
	}
	//使用setter将值注入属性值
	//在配置文件中要使用<bean>元素的<property>子元素来为每个属性注入值
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findUser(String username) {
		return userDao.findByName(username);
	}

	@Override
	public boolean register(User user) {
		System.out.println(user);
		boolean isExist = userDao.isExist(user.getUsername());
		System.out.println(isExist);
		if (isExist==true) {
			return false;
		}
		userDao.save(user);
		return true;
	}
	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

}
