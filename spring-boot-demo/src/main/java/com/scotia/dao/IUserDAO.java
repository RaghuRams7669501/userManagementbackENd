package com.scotia.dao;
import java.util.List;

import com.scotia.entity.User;
public interface IUserDAO {
   
   
   
    boolean articleExists(String title, String category);
	void updateUser(User user);
	
//	void addUser(int id, String firstname, String email, String username, String webSite, String phoneNumber);
	void addUser(User user);
	void getUser(Integer id);

	void deleteUser(int id);


	List<User> getAllUsers();
	
	
}
 