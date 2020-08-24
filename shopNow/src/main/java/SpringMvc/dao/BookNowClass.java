package SpringMvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookNowClass implements BookNow{

	public boolean purches(int productId, String userId) {
		// TODO Auto-generated method stub
		
		
		String url="jdbc:mysql://localhost:3306?user=root&password=techouts";
		String query = "select * from test.productinformayion where productId=?";
		
		String queryInsert = "insert into test.bookingproducts values(?,?,?,?,?)";
		try {
			System.out.println("line no1");
			
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("line no2");
		Connection connection=DriverManager.getConnection(url);
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, productId);
		ResultSet resultSet1=preparedStatement.executeQuery();
		
		if(resultSet1.next())
		{
			String productName=resultSet1.getString("productName");
			int productPrice=resultSet1.getInt("productPrice");
			String tyepe=resultSet1.getString("tyepe");
			
		
		PreparedStatement preparedStatementqueryInsert = connection.prepareStatement(queryInsert);
		System.out.println("line no27");
		preparedStatementqueryInsert.setInt(1, productId);
		System.out.println("line no28");
		preparedStatementqueryInsert.setString(2, productName);		
		System.out.println("line no29");
		preparedStatementqueryInsert.setInt(3, productPrice);
		System.out.println("line no30");
		preparedStatementqueryInsert.setString(4, tyepe);
		System.out.println("line no31");
		
		preparedStatementqueryInsert.setString(5, userId);
		System.out.println("line no32");
		preparedStatementqueryInsert.executeUpdate();
		System.out.println("line no33");
		connection.close();
		
	
	return true;
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	

		return false;
	}

}
