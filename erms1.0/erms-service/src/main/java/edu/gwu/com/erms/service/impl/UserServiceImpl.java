package edu.gwu.com.erms.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.gwu.com.erms.bean.User;
import edu.gwu.com.erms.dao.UserDAO;
import edu.gwu.com.erms.dao.impl.UserDAOImpl;
import edu.gwu.com.erms.service.UserService;

public class UserServiceImpl implements UserService{
	@Inject
	private UserDAO userDAO;
	public Boolean addUser(User user) {
		return userDAO.insertUser(user);
	}
	public User checkUser(User user) {
		return userDAO.checkUser(user);
	}
	public List<User> listUsers() {
		return userDAO.listUser();
	}
	public boolean deleteUser(String userId) {
		return userDAO.deleteUser(userId);
	}

}
