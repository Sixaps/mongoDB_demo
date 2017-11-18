package com.example.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.User;

@Repository
public class UserDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void add(User user) {
		this.mongoTemplate.insert(user,"User");
	}
	
	public User find(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, User.class);
	}
	
	public List<User> findAll(){
		return this.mongoTemplate.findAll(User.class, "User");
	}
	
	public void delete(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		this.mongoTemplate.remove(query, "User");
	}
	
	public void updatePwd(String id, String pwd) {
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new Update().update("pwd", pwd);
		this.mongoTemplate.upsert(query, update, "User");
	}
}
