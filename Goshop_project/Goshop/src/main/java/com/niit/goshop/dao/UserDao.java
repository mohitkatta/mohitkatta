package com.niit.goshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.goshop.models.User;
@Repository("userDAO")
public interface UserDao {
	boolean addUser(User user);
	User getUser(String s);
	boolean updateUser(User u);
	boolean deleteUser(String em);
	List<User> listUsers();
}