package com.mts.service;

import com.mts.exception.UserCreationError;
import com.mts.model.User;

public interface IUserService {

	public User addUser(User user) throws UserCreationError;

	public User removeUser(User user);
}
