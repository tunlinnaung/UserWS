package com.me.rest;

import com.me.entity.Response;
import com.me.entity.User;

public interface UserService {
	
	 public Response addUser(User user);
	 
	 public Response deleteUser(int id);
	 
	 public User getUser(int id);
	 
	 public User[] getUsers();
}
