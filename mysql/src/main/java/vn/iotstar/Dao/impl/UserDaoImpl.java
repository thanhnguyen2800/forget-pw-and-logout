
package vn.iotstar.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.Dao.IUserDao;
import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.models.Usermodel;

public class UserDaoImpl extends DBConnectMySQL  implements IUserDao {
	
	@Override
	public List<Usermodel> findAll() {
	    String sql = "SELECT * FROM users";
	    List<Usermodel> list = new ArrayList<>();
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new Usermodel(
	                rs.getInt("idusers"),
	                rs.getString("username"),
	                rs.getString("email"),
	                rs.getString("password"),
	                rs.getString("fullname"),
	                rs.getString("images"),
	                rs.getString("phone"),
	                rs.getInt("roleid"),
	                rs.getDate("createDate")
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	@Override
	public Usermodel findById(int idusers) {
	    String sql = "SELECT * FROM users WHERE idusers = ? ";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, idusers);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Usermodel user = new Usermodel();
	            user.setIdusers(rs.getInt("idusers"));
	            user.setEmail(rs.getString("email"));
	            user.setUsername(rs.getString("username"));
	            user.setFullname(rs.getString("fullname"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setPhone(rs.getString("phone"));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public boolean insertUser(Usermodel user) {
	    String sql = "INSERT INTO users(username, password, email) VALUES (?, ?, ?)";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getEmail());
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public Usermodel findByUserName(String username) {
	    String sql = "SELECT * FROM users WHERE username = ? ";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Usermodel user = new Usermodel();
	            user.setIdusers(rs.getInt("idusers"));
	            user.setEmail(rs.getString("email"));
	            user.setUsername(rs.getString("username"));
	            user.setFullname(rs.getString("fullname"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setPhone(rs.getString("phone"));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public Usermodel checkLogin(String username, String password) {
	    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Usermodel user = new Usermodel();
	            user.setIdusers(rs.getInt("idusers"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@Override
	public boolean updatePassword(String email, String newPassword) {
	    String sql = "UPDATE users SET password=? WHERE email=?";
	    try (Connection conn = DBConnectMySQL.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, newPassword);
	        ps.setString(2, email);

	        int rows = ps.executeUpdate();
	        return rows > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	

	@Override
	public void insert(Usermodel user) {
		// TODO Auto-generated method stub
		
	}
}


