package vn.iotstar.Dao;

import java.util.List;

import vn.iotstar.models.Usermodel;

public interface IUserDao {
	
	List<Usermodel> findAll();
	
	Usermodel findById(int idusers);
	
	void insert(Usermodel user);
	
	Usermodel findByUserName(String username);
	
	boolean insertUser(Usermodel user);
	
	Usermodel checkLogin(String username, String password);
	
	boolean updatePassword(String email, String newPassword);

}
