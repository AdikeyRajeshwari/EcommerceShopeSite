package SpringMvc.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

import SpringMvc.model.ProductInfo;

public class CartItemStatusClass implements CartItemStatus{

	public Boolean cartStatus(int productIdFromUser, String userId) {
		
		
		
		
		String url="jdbc:mysql://localhost:3306?user=root&password=techouts";
		
		String querySelect = "select * from test.cartiteams";
		
		try {
			System.out.println("line no1");
			
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("line no2");
		Connection connection=DriverManager.getConnection(url);
		//connection.setAutoCommit(false);
		
		
		PreparedStatement preparedStatement=connection.prepareStatement(querySelect);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		System.out.println("line no6");
		int count=0;
		System.out.println("line no7");
		int itemCount=0;
		
		while(resultSet.next())
		{
			System.out.println("line no8");
			int productId1=resultSet.getInt("productId");
			System.out.println("line no9");
			 itemCount=resultSet.getInt("count");
			 System.out.println("line no10");
			if(productId1 == productIdFromUser)
			{
				System.out.println("line no11");
				count=count+1;
				break;
			}
			else {
				System.out.println("line no12");
				count=0;
			}
			System.out.println("line no13 : "+count);
		}
		
		if(count>0)
		{
			System.out.println("line no14");
			//update statment
			String queryUpdate="UPDATE test.cartiteams SET count=? WHERE productId=?";
			System.out.println("a");
			PreparedStatement preparedStatementqueryUpdate = connection.prepareStatement(queryUpdate);
			System.out.println("a");
			preparedStatementqueryUpdate.setInt(1, itemCount+1);
			System.out.println("a");
			preparedStatementqueryUpdate.setInt(2, productIdFromUser);
			System.out.println("a");
			preparedStatementqueryUpdate.executeUpdate();
		}
		else
		{
			System.out.println("line no15");
			//insert statement
			String queryInsert = "insert into test.cartiteams values(?,?,?,?,?,?)";
			System.out.println("line no16");
			String querySelect2= "select * from test.productinformayion where productId=?";
			System.out.println("line no17");
			PreparedStatement preparedStatementquerySelect2=connection.prepareStatement(querySelect2);
			System.out.println("line no18");
			String productName = null;
			System.out.println("line no19");
			int productPrice = 0;
			String tyepe = null;
			System.out.println("line no20");
			preparedStatementquerySelect2.setInt(1, productIdFromUser);
			System.out.println("line no21");
			ResultSet resultSet1=preparedStatementquerySelect2.executeQuery();
			System.out.println("line no22");
			if(resultSet1.next())
			{
				System.out.println("line no23");
			 productName=resultSet1.getString("productName");
			 System.out.println("line no24");
			 productPrice=resultSet1.getInt("productPrice");
			 System.out.println("line no25");
			 tyepe=resultSet1.getString("tyepe");
			 System.out.println("line no26");
							
			}
			PreparedStatement preparedStatementqueryInsert = connection.prepareStatement(queryInsert);
			System.out.println("line no27");
			preparedStatementqueryInsert.setInt(1, productIdFromUser);
			System.out.println("line no28");
			preparedStatementqueryInsert.setString(2, productName);		
			System.out.println("line no29");
			preparedStatementqueryInsert.setInt(3, productPrice);
			System.out.println("line no30");
			preparedStatementqueryInsert.setString(4, tyepe);
			System.out.println("line no31");
			preparedStatementqueryInsert.setInt(5, 1);
			preparedStatementqueryInsert.setString(6, userId);
			System.out.println("line no32");
			preparedStatementqueryInsert.executeUpdate();
			System.out.println("line no33");
			connection.close();
			
		}
		return true;
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
		}
	
	
	/*view cart iteams*/
	public Boolean viewCart(String email, ProductInfo info, ArrayList<ProductInfo> list1)
	{
	String url="jdbc:mysql://localhost:3306?user=root&password=techouts";
	String query="select * from test.cartiteams where userId=?";
	String querySelect = "select * from test.productinformayion where productId=?";
	
	try {
		System.out.println("line no1"+email);
		
		Class.forName("com.mysql.jdbc.Driver");
	System.out.println("line no3");
	Connection connection=DriverManager.getConnection(url);
	System.out.println("line no4");
	PreparedStatement preparedStatement=connection.prepareStatement(query);
	System.out.println("line no5");
	preparedStatement.setString(1, email);
	System.out.println("line no6");
	ResultSet resultSet=preparedStatement.executeQuery();
	System.out.println("line no7");
	int productId=0;
	String base64Image = null;
	int productId1 = 0;
	int productPrice = 0;
	Blob blob ;
	String description = null;
	String tyepe = null;
	String productName = null;
	ProductInfo info1 = null;
	while(resultSet.next()) 
	{
		 info1=new ProductInfo();
		 productId =resultSet.getInt("productId");
		 int count1=resultSet.getInt("count");
		 
		System.out.println("line no8");
	
		PreparedStatement preparedStatementSelectquery=connection.prepareStatement(querySelect);
		System.out.println("line no8");
		preparedStatementSelectquery.setInt(1, productId);
		System.out.println("line no8");
		ResultSet resultSet1=preparedStatementSelectquery.executeQuery();
		System.out.println("line no8");
		while(resultSet1.next())
		{
		 productId1 =resultSet1.getInt("productId");
		productName=resultSet1.getString("productName");
		System.out.println("line no9");
		 productPrice=resultSet1.getInt("productPrice");
		System.out.println("line no10");
		 blob = resultSet1.getBlob("images");
		System.out.println("line no11");
		description=resultSet1.getString("description");
		System.out.println("line no12");
		 tyepe=resultSet1.getString("tyepe");
		System.out.println("line no13");
		InputStream inputStream = blob.getBinaryStream();
		System.out.println("line n142");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096]; //4096bytes = 4kb
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) { //bytesRead=4kb
		outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();
		 base64Image = Base64.getEncoder().encodeToString(imageBytes);
		inputStream.close();
		outputStream.close();
		System.out.println(productPrice);
		
		if(base64Image != null)
		{
			System.out.println("line no15");
			
			
			info1.setProductId(productId1);
		info1.setProductName(productName);
			
			info1.setProductPrice(productPrice);
			info1.setBase64Image(base64Image);
			info1.setDescription(description);
			info1.setTyepe(tyepe);
			info1.setCount(count1);
			System.out.println("count : "+count1);
			list1.add(info1);
	        info.setList(list1);
		}
	}
	
		
		
			
	}	
		
		
			
	
	System.out.println(list1);
	return true;
	
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return false;
	
	}
	
	
}
