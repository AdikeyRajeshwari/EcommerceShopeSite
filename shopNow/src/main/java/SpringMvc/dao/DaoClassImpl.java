package SpringMvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import SpringMvc.model.UserInfo;





public class DaoClassImpl implements DaoClass{

	

	public boolean regDBConnection(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
		System.out.println(""+userInfo.getName()+"");
		String url = "jdbc:mysql://localhost:3306?user=root&password=techouts";
		String query = "insert into test.userinfo values(?,?,?,?)";
		String driver = "com.mysql.jdbc.Driver";
		
		try 
		{
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userInfo.getName());
			preparedStatement.setString(2, userInfo.getPhnNo());
			preparedStatement.setString(3, userInfo.getEmail());
			preparedStatement.setString(4, userInfo.getPassword());
			
			preparedStatement.executeUpdate();
			connection.close();
			return true;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	
	}

}
