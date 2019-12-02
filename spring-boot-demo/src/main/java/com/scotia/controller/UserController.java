package com.scotia.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scotia.entity.User;
import com.scotia.service.IUserService;



@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserDataByID(@PathVariable("id") Integer id) {
		System.out.println(">>>>>>>>comes into Get>>>>>>>>."+id);
		User user = userService.getUserDataByID(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("articles")
	public ResponseEntity<List<User>> getAllArticles() {
		System.out.println(">>>>>>>>>>>>>Articles>>>>>>>>>>>>>>");
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@PostMapping("article/{id}")	
	public ResponseEntity<List<User>> deleteUser(@PathVariable("id") Integer id) {
		System.out.println(">>>>>>>>>>>>Comes into Delete>>>>>>>>>>>");
		userService.deleteUser(id);
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}	
	@RequestMapping(value = "addUser", method = {RequestMethod.POST}, 
			consumes = {"application/json"})
	public ResponseEntity<List<User>>  addUser(@RequestBody User user) {
		System.out.println(">>>>>>>>>>>>Add User>>>>>>>>>>>>");

		userService.addUser(user);
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}	
	@RequestMapping(value = "updateUser", method = {RequestMethod.POST}, 
			consumes = {"application/json"})
	
	public ResponseEntity<List<User>> updateUser(@RequestBody User user) {
		System.out.println(">>>>>>>>>>>>Comes into Update>>>>updateUser>>>>>>>");
		userService.updateUser(user);
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
} 