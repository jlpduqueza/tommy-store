package com.tommystore.service;

import java.util.List;

import com.tommystore.bean.LoginBean;
import com.tommystore.constant.Role;
import com.tommystore.domain.User;

public interface UserService {
	
	public User find(Integer id);
	public User save(User user);
	public User validateLogin(LoginBean login);
	
    public Boolean isExistByEmail(String email);
    public Boolean isValidToEdit(User user);
	public Boolean isUserValidForCheckout(User user);
	
    public List<String> findRoles();
	public List<User> findUsers();
	public List<User> viewNewUser();
	public List<User> findByRole(Role role);
}
