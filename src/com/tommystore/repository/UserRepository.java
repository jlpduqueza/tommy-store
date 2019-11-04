package com.tommystore.repository;

import java.util.Date;
import java.util.List;

import com.tommystore.bean.LoginBean;
import com.tommystore.constant.Role;
import com.tommystore.domain.User;

public interface UserRepository {

	public User find(Integer id);
    public User validateLogin(LoginBean login);
	public User save(User user);
	
    public Boolean isUserExistByEmail(String email);
    public Boolean isValidToEdit(User user);
    
	public List<User> findUsers();
	public List<User> findUserByRole(Role role);
	public List<User> viewNewUsers(Date range);
    
}
