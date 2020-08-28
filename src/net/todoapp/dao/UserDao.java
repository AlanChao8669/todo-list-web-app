package net.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.todoapp.model.User;
import net.todoapp.utils.JDBCUtils;

public class UserDao {
	public int registerUser(User user) throws ClassNotFoundException {

		String INSERT_USERS_SQL = "INSERT INTO users" + 
			"(first_name, last_name, username, password) VALUES " +
			"(?, ?, ?, ?);";
		int result =0;
		try{
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			//System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
}
