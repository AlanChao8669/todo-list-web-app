package net.todoapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import net.todoapp.model.LoginBean;
import net.todoapp.utils.JDBCUtils;

public class LoginDao {

	public boolean validate(LoginBean login) throws ClassNotFoundException{
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");
		try{
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM users WHERE username = ? and password = ?");
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return status;
	}

}
