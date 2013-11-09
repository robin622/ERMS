package edu.gwu.com.erms.service;

import java.util.List;

import edu.gwu.com.erms.bean.User;

public interface UserService {
	public Boolean addUser(User user);
	public Boolean checkUser(User user);
	public List<User> listUsers();
}
