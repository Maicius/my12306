/**
 * 
 */
package com.neuedu.business.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.neuedu.business.dao.UserDAO;
import com.neuedu.business.dao.UserDAOImpl;
import com.neuedu.business.entity.User;
import com.neuedu.utils.DBUtils;

/**
 * @author ttc
 *
 */
public class UserService {

	private UserService(){};
	
	public static UserService getInstance(){
		return new UserService();
	}
	
	public User checkUser(User user){
		
		Connection connection = DBUtils.getConnection();
		UserDAO userDAO = new UserDAOImpl(connection);
		User checkedUser = new User();
		try {
			checkedUser = userDAO.checkUser(user);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkedUser;
	}
}
