// Register the driver class
// then create a connection object

import java.sql.*;
public class DB {
  public static Connection getConnection(){ // return a connection to database
	  Connection con=null;
	  try{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","15103030");
		  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  return con;
  }
}
