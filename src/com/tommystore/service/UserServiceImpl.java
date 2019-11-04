package com.tommystore.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommystore.bean.LoginBean;
import com.tommystore.constant.Role;
import com.tommystore.domain.User;
import com.tommystore.repository.UserRepository;

@Service
@PropertySource("/WEB-INF/properties")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Value("${newUsers.nHours}")
	private int nHours;
	
	@Override
	@Transactional
	public User find(Integer id) {
		
		return userRepository.find(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User validateLogin(LoginBean login) {
		
		return userRepository.validateLogin(login);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findUsers() {
		
		return userRepository.findUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> viewNewUser() {
		                    
		Date currentDate = new Date();
		Timestamp oneDayInterval = new Timestamp(currentDate.getTime() - (nHours*60*60*1000));
	
		return userRepository.viewNewUsers(oneDayInterval);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByRole(Role role) {
		
		return userRepository.findUserByRole(role);
	}

	@Override
	@Transactional
	public Boolean isExistByEmail(String email) {
		
		return userRepository.isUserExistByEmail(email);
	}

	@Override
	public List<String> findRoles() {
		
    	List<String> roleList = new ArrayList<>();
    	roleList.add("All");
    	
    	for (Role role : Role.values()) {
    		roleList.add(role.toString());
    	}
    	
    	return roleList;
	}

	@Override
	@Transactional
	public Boolean isValidToEdit(User user) {
		
		return userRepository.isValidToEdit(user);
	}

	@Override
	@Transactional
	public Boolean isUserValidForCheckout(User checkingOutUser) {
		
		User user = find(checkingOutUser.getId());
		
		if(!user.getShippingAddresses().isEmpty()) {
			
			return true;
		}
		
		return false;
	}

}
