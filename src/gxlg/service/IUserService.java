package gxlg.service;


import gxlg.model.User;

public interface IUserService {
	/**
	 * 查询用find**
	 */
	public User findUser(String username);	//根据用户名查找数据，进行登录，找回密码
	public boolean register(User user);	//注册
	public boolean update(User user);//更新数据，本项目用来修改密码
}
