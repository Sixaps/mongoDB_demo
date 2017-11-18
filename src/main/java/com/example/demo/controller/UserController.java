package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;

import net.sf.json.JSONObject;



@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public void addUser(@RequestBody JSONObject jsonObject) {
		User user = new User();
		String username = jsonObject.getString("username");
		String pwd = jsonObject.getString("pwd");
		String id = jsonObject.getString("id");
		String name;
		if(jsonObject.has("nickname")){
			name = jsonObject.getString("nickname");
			user.setNickname(name);
		}
		user.setUsername(username);
		user.setPwd(pwd);
		user.setId(id);
		this.userService.add(user);
	}
	
	@RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
	public User findUser(@PathVariable String id) {
		return this.userService.find(id);
	}
	
	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	public List<User> findAllUser() {
		return this.userService.findAll();
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteUser(@PathVariable String id) {
		this.userService.delete(id);
	}
	
	@RequestMapping(value = "/ChangePwd/{id}", method = RequestMethod.POST)
	public void updatePwd(@PathVariable String id, @RequestBody JSONObject jsonObject) {
		String pwd = jsonObject.getString("pwd");
		this.userService.updatePwd(id, pwd);
	}
}
