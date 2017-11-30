package com.me.rest;

import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.me.entity.Response;
import com.me.entity.User;

@Path("/users")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class UserServiceImpl implements UserService {
	
	private static HashMap<Integer, User> userMap = new HashMap<>();

	@Override
	@POST
	@Path("/add")
	public Response addUser(User user) {
		Response response = new Response();
		if (userMap.get(user.getId()) != null) {
			response.setId(0);
			response.setMessage("User already exists");
			return response;
		}
		
		userMap.put(user.getId(), user);
		response.setId(1);
		response.setMessage("User created successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/delete")
	public Response deleteUser(@PathParam("id") int id) {
		Response response = new Response();
		if (userMap.get(id) == null) {
			response.setId(0);
			response.setMessage("User does not exists");
			return response;
		}
		
		userMap.remove(id);
		response.setId(1);
		response.setMessage("User removed successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public User getUser(@PathParam("id") int id) {
		return userMap.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public User getDummyUser(@PathParam("id") int id) {
		User user = new User();
		user.setId(id);
		user.setUsername("Tun");
		user.setPassword("dummypwd");
		return user;
	}

	@Override
	@GET
	@Path("/getall")
	public User[] getUsers() {
		//return (User[]) userMap.values().toArray();
		Set<Integer> keys = userMap.keySet();
		User[] userArray = new User[userMap.size()];
		
		int i = 0;
		for (Integer id : keys) {
			userArray[i] = userMap.get(id);
			i++;
		}
		
		return userArray;
	}

}
