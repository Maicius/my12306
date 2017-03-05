/**
 * 
 */
package com.neuedu.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.business.entity.User;

/**
 * @author ttc
 *
 */
public class UserDAOImpl implements UserDAO {
	
	private Connection connection;
	
	public UserDAOImpl(Connection connection) {
		this.connection = connection;
	}

	
	
	@Override
	public User checkUser(User user) throws SQLException {
		
		String sql = "select * from tab_user where username = ?";
		User checkedUser = new User();
		PreparedStatement ps = null;
		try{
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				checkedUser.setUsername(rs.getString("username"));
			}
		}catch(SQLException e){
			throw e;
		}finally{
			ps.close();
		}
		
		return checkedUser;
	}

	
}
