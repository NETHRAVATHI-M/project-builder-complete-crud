package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Skill;
import utility.ConnectionManager;

public class CrudDAO implements CrudDaoInterface {

	@Override
	public void addSkill(Skill skill) {
		// TODO Auto-generated method stub
		String INSERT_USERS_SQL = "INSERT INTO SKILL(ID, NAME)VALUES(?,?)";

		int result = 0;
		try
		{
			Connection connection = null;
			try {
				connection = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setLong(1,skill.getId());
			preparedStatement.setString(2,skill.getName());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
			if(result==1) {
				System.out.println("added auccessfully");
			}
			else{
				System.out.println("check your details");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String DELETE_USERS_SQL = "delete * from SKILL where id ="+id;

		int result = 0;
		try
		{
			Connection connection = null;
			try {
				connection = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
			if(result==1) {
				System.out.println("deleted auccessfully");
			}
			else{
				System.out.println("check your details");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
	}

	@Override
	public void update(Skill skill) {
		// TODO Auto-generated method stub
		String UPDATE_USERS_SQL = "UPDATE SKILL SET NAME =? where id ="+skill.getId();
		

		int result = 0;
		try
		{
			Connection connection = null;
			try {
				connection = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.setString(1, skill.getName());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
			if(result==1) {
				System.out.println("updated successfully");
			}
			else{
				System.out.println("check your details");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
String display_SQL = "select * from skill";
		

		
		try
		{
			Connection connection = null;
			try {
				connection = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(display_SQL);
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			int id = result.getInt("ID");
			String name = result.getString("NAME");
			System.out.println("ID ="+id+"name= "+name);
			
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
	}

}
