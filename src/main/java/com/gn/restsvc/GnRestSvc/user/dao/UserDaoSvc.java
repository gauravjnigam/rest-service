package com.gn.restsvc.GnRestSvc.user.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gn.restsvc.GnRestSvc.user.model.User;

@Component
public class UserDaoSvc {

	private static final List<User> userList = new ArrayList<>();
	private static int userCounts = 3;

	static {
		userList.add(new User(1, "Gaurav", LocalDate.of(1987, 07, 06)));
		userList.add(new User(2, "Ravi", LocalDate.of(1987, 04, 06)));
		userList.add(new User(3, "Tom", LocalDate.of(1987, 07, 07)));
	}

	public List<User> findAll() {
		return userList;
	}

	public User save(User user) {
		
		if(user.getId() == null) {
			user.setId(++userCounts);
		}
		userList.add(user);
		return user;
	}
	
	public User findOne(int id) {
		Optional<User> userOpt =  userList.stream().filter(u -> u.getId()==id).findFirst();
		if(userOpt.isPresent()) {
			return userOpt.get();
		} else {
			return null;// throw exception
		}
	}
	
	public User deleteById(int id) {
		Iterator<User> usrItr = userList.iterator();
		while(usrItr.hasNext()) {
			User user = usrItr.next();
			if(user.getId() == id) {
				usrItr.remove();
				return user;
			}
		}
		
		return null;
	}

}
