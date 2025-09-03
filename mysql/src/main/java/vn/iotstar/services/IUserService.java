package vn.iotstar.services;

import vn.iotstar.models.Usermodel;

public interface IUserService {
	Usermodel login(String username, String password);
	
	Usermodel FindByUserName(String username);
	
	boolean insertUser(Usermodel user);
	
	Usermodel checkLogin(String username, String password);
	
	void resetPassword(String email, String newPassword);

	boolean updatePassword(String email, String newPassword);
	
	
	

		
	


}
