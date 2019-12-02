package com.scotia.service;

import java.util.List;


import com.scotia.entity.User;

public interface IUserService {
     List<User> getAllUsers();
     
     void updateUser(User user);
     


	void addUser(User user);
	User getUserDataByID(Integer id);

	

	void deleteUser(int userId);
}
