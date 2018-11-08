package gxlg.dao.impl;

import org.springframework.orm.hibernate5.HibernateTemplate;
import gxlg.dao.IUserDao;
import gxlg.model.User;

/**
 * 数据持久层实现类，基于接口编程
 * @author ASUS
 *
 */
public class UserDao implements IUserDao {
	
	/**
	 * HibernateTemplate为Spring容器对数据访问的模板类
	 * 相当于Hibernate5中的Session对象
	 * 主要是对数据进行增删改查
	 * 这里使用的依赖注入为设值注入
	 * 设值注入步骤如下：
	 */
	//第一步：获取类对象
	private HibernateTemplate template;
	//第二步：提供setter和getter方法
	public HibernateTemplate getTemplate() {
		return template;
	}
	//第三步：使用setter将值注入属性值
	//第四步：在配置文件中要使用<bean>元素的<property>子元素来为每个属性注入值
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	/**
	 * 判断用户名是否存在
	 */
	@Override
	public boolean isExist(String username) {
		User user = template.get(User.class, username);
		return user==null?false:true;
	}

	/**
	 * 添加数据
	 * @param user
	 * @return
	 */
	@Override
	public boolean save(User user){
		boolean val = false;
		try {
			template.save(user);
			val = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
	
	/**
	 * 查询记录
	 * @param username
	 * @return
	 */
	@Override
	public User findByName(String username) {
		return template.get(User.class, username);
	}
	
	/**
	 * 更新数据
	 * @return
	 */
	@Override
	public boolean update(User user) {
		boolean val = false;
		try {
			if (user!=null){
				template.update(user);
			}
			val = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
}
