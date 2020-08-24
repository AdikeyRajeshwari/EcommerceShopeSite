package SpringMvc.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import SpringMvc.model.ProductInfo;



public class retriveProductInfo {
	

	/*public boolean demo(String productName, Book1 book1)
	{
	
		
	String url="jdbc:mysql://localhost:3306?user=root&password=techouts";
	
	String queryinsert = "select * from test.productinfo where productName=?";
	
	try {
		System.out.println("line no1");
		System.out.println("retrive controller"+productName);
		Class.forName("com.mysql.jdbc.Driver");
	System.out.println("line no2");
	System.out.println(productName);
	Connection connection=DriverManager.getConnection(url);
	connection.setAutoCommit(false);
	
	System.out.println("line no3");
	PreparedStatement preparedStatement=connection.prepareStatement(queryinsert);
	System.out.println("line no4");
	preparedStatement.setString(1, productName);
	
	System.out.println("line no5");
	//preparedStatement.setString(2, );
	
	ResultSet resultSet1=preparedStatement.executeQuery();
	System.out.println("line no6");
	
	if(resultSet1.next())
	{
		
		System.out.println("line no7");
		String productName1=resultSet1.getString("productName");
		System.out.println("line no7");
		int productPrice=resultSet1.getInt("productPrice");
		System.out.println("line no7");
		Blob blob = resultSet1.getBlob("images");
		System.out.println("line no7");
		
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096]; //4096bytes = 4kb
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) { //bytesRead=4kb
		outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		inputStream.close();
		outputStream.close();
		System.out.println(productPrice);
		
		if(base64Image != null)
		{
		
			
			
			book1.setBase64Image(base64Image);
			book1.setI(productPrice);
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
	*/
	
	
	
	
	public boolean demo(ProductInfo info, ArrayList<ProductInfo> list, HttpSession session)
	{
		 HashSet set=new HashSet<ProductInfo>();
		
	String url="jdbc:mysql://localhost:3306?user=root&password=techouts";
	
	String queryinsert = "select * from test.productinformayion";
	
	try {
		System.out.println("line no1");
		
		Class.forName("com.mysql.jdbc.Driver");
	System.out.println("line no2");
	
	Connection connection=DriverManager.getConnection(url);
	connection.setAutoCommit(false);
	
	System.out.println("line no3");
	PreparedStatement preparedStatement=connection.prepareStatement(queryinsert);
	System.out.println("line no4");
	
	
	
	ResultSet resultSet1=preparedStatement.executeQuery();
	System.out.println("line no6");
	
	while (resultSet1.next()) 
	{
		int productId =resultSet1.getInt("productId");
		System.out.println("line no7");
		String productName=resultSet1.getString("productName");
		System.out.println("line no7");
		int productPrice=resultSet1.getInt("productPrice");
		System.out.println("line no7");
		Blob blob = resultSet1.getBlob("images");
		System.out.println("line no7");
		String description=resultSet1.getString("description");
		String tyepe=resultSet1.getString("tyepe");
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096]; //4096bytes = 4kb
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) { //bytesRead=4kb
		outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		inputStream.close();
		outputStream.close();
		System.out.println(productPrice);
			
			if(base64Image != null)
			{
				
				ProductInfo info1=new ProductInfo();
				info1.setProductId(productId);
			info1.setProductName(productName);
				
				info1.setProductPrice(productPrice);
				info1.setBase64Image(base64Image);
				info1.setDescription(description);
				info1.setTyepe(tyepe);
			
		        list.add(info1);
		        info.setList(list);
		       
				set.add(tyepe);
				
				
			}
		
		
			
	}
	System.out.println(list);
	session.setAttribute("set", set);
	return true;
	
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return false;
	
	}
	
	
	
	
	public Boolean iteamsBasedOnGender(String type, ArrayList<ProductInfo> list, ProductInfo info1,HttpSession session)
	{
		String sql = "SELECT * from test.productinformayion where tyepe=?";
		  String url = "jdbc:mysql://localhost:3306?user=root&password=techouts";
		  String driver = "com.mysql.jdbc.Driver";
		  HashSet set=new HashSet<ProductInfo>();

		  try  {
		  	
		  		
		  	Class.forName(driver);//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306\test","root","techouts");
		  		Connection connection = DriverManager.getConnection(url);
		  		PreparedStatement statement = connection.prepareStatement(sql);
		  		statement.setString(1, type);
		  		ResultSet result = statement.executeQuery();

	while (result.next()) {
	
		int productId =result.getInt("productId");
		System.out.println("line no7");
		String productName=result.getString("productName");
		System.out.println("line no7");
		int productPrice=result.getInt("productPrice");
		System.out.println("line no7");
		Blob blob = result.getBlob("images");
		System.out.println("line no7");
		String description=result.getString("description");
		String tyepe=result.getString("tyepe");
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096]; //4096bytes = 4kb
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) { //bytesRead=4kb
		outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		inputStream.close();
		outputStream.close();
		System.out.println(productPrice);
		
		if(base64Image != null)
		{
			
			ProductInfo info2=new ProductInfo();
			info2.setProductId(productId);
		info2.setProductName(productName);
			
			info2.setProductPrice(productPrice);
			info2.setBase64Image(base64Image);
			info2.setDescription(description);
			info2.setTyepe(tyepe);
		
			//ProductInfo info1=new ProductInfo(productId,productName,productPrice,base64Image,description,tyepe);
			
			//list.add(info);
			
			//ProductInfo customer = new ProductInfo(resultSet1.getInt("productId"),resultSet1.getString("productName"),resultSet1.getInt("productPrice"));
	        list.add(info2);
	        info1.setList(list);
	       
	        set.add(tyepe);
			
			
		}
			
	}
	
	System.out.println(list);
	session.setAttribute("set1", set);
		return true;
		
	
	
			
	} catch (Exception ex) {
	ex.printStackTrace();

	}
		return null;
	}
}



