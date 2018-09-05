package springboot.dao;

import java.util.List;

import springboot.model.User;

public interface UserApi {
	
	public boolean save(User user);
	
	public List<User> getAllUsers();

}
