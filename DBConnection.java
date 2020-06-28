//@Reabaln
// This class is called by the Servlet to start the connection with the Database. 
package mvc;

import java.sql.*;

public class DBConnection {
	
		//	Database URL
	   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	   static final String DB_URL = "DB-URL-HERE";

	   //  Database credentials
	   static final String USER = "username;
	   static final String PASS = "password";
	   static Connection conn = null;

	   public static Connection getConnection (){
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);
	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");  
	     
  }catch(SQLException se){
     //Handle errors for JDBC
     se.printStackTrace();
  }catch(Exception e){
     //Handle errors for Class.forName
     e.printStackTrace();
  }
	return conn;
}//end getConnection
	   
	   public static void main(String[] args) {
		   System.out.println(DBConnection.getConnection());
	   }
}//end DBConnection


