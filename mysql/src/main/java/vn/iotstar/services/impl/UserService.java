package vn.iotstar.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vn.iotstar.Dao.IUserDao;
import vn.iotstar.Dao.impl.UserDaoImpl;
import vn.iotstar.models.Usermodel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    
	@Override
	public Usermodel login(String username, String password) {
		Usermodel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public Usermodel FindByUserName(String username) {
		
		return userDao.findByUserName(username);
	}

	@Override
	public boolean insertUser(Usermodel user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}
	
	
	@Override
    public boolean resetPassword(String email, String newPassword) {
        return userDao.updatePassword(email, newPassword);
    }

	
	@Override
	public boolean updatePassword(String email, String newPassword) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        conn = DBConnect.getConnection(); // class DBConnect của mày để lấy connection
	        String sql = "UPDATE users SET password = ? WHERE email = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, newPassword);
	        stmt.setString(2, email);

	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0; // Nếu có bản ghi được cập nhật thì trả về true
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


}
