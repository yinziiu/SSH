package gxlg.dao;
import gxlg.model.User;

/**
 * 数据持久层接口类
 * @author ASUS
 *
 */
public interface IUserDao {
	
	public boolean save(User user);//增加数据，主要用于注册
	public boolean update(User user);//跟新数据，主要用于修改密码
	public User findByName(String username);//根据用户名查找数据
	public boolean isExist(String username);//判断用户名是否存在
}
