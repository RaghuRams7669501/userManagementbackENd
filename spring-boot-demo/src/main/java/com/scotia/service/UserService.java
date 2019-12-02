package com.scotia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scotia.dao.IUserDAO;
import com.scotia.entity.User;


@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}

	
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	
    @Override
    public void addUser(User user)
    {
    	userDAO.addUser(user);
    }

	@Override
	public User getUserDataByID(Integer id) {
		userDAO.getUser(id);
		return null;
	}


	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
		
	}
}
