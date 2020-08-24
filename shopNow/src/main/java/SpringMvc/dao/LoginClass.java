package SpringMvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginClass implements LoginInterface
{

	public Boolean login(String phnno, String email) {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306?user=root&password=techouts";
		String queryinsert="select * from test.userInfo where email=? && phnNo=?";
		try {
			
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(queryinsert);
		
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, phnno);
		
		ResultSet resultSet1=preparedStatement.executeQuery();
		if(resultSet1.next())
		{
			
			String email1=resultSet1.getString("email");
			String phnno1=resultSet1.getString("phnNo");
			if(email.equals(email1)&&phnno.equals(phnno1))
			{
				return true;
			}
		}
		
		connection.close();
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
