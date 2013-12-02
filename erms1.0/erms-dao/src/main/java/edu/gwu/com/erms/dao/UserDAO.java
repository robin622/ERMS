package edu.gwu.com.erms.dao;

import java.util.List;

import edu.gwu.com.erms.bean.User;

public interface UserDAO {
	public User insertUser(User user);
	public User checkUser(User user);
	public List<User> listUser();
	public boolean deleteUser(String userId);
	public String checkUserNameByEmail(String email);
	public String getEmail(String owner);
}
