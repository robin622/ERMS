package edu.gwu.com.erms.dao;

import java.util.List;

import edu.gwu.com.erms.bean.User;

public interface UserDAO {
	public boolean insertUser(User user);
	public boolean checkUser(User user);
	public List<User> listUser();
}
