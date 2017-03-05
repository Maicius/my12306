/**
 * 
 */
package com.neuedu.business.dao;

import java.sql.SQLException;

import com.neuedu.business.entity.User;

/**
 * @author ttc
 *
 */
public interface UserDAO {

	User checkUser(User user) throws SQLException;
}
