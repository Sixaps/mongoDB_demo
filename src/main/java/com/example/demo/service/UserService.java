package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.bean.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public void add(User user) {
		this.userDAO.add(user);
	}
	
	public User find(String id) {
		return this.userDAO.find(id);
	}
	
	public void delete(String id) {
		this.userDAO.delete(id);
	}
	
	public void updatePwd(String id, String pwd) {
		this.userDAO.updatePwd(id, pwd);
	}
	
	public List<User> findAll() {
		return userDAO.findAll();
	}
}
