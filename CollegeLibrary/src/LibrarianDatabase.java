import java.sql.*;
public class LibrarianDatabase {
	public static int saveData(String name,String password,String Id,String city,String contact){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into librarian(name,password,Id,city,contact) values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,Id);
			ps.setString(4,city);
			ps.setString(5,contact); // set the value at 5th column 
			status=ps.executeUpdate(); // Executes the SQL statement in this PreparedStatement object, which must be an SQL 
			//Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; 
			// it returns the row count of data manipulation language. 
			con.close();//close connection.
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int Delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Librarian where Id=?");
			ps.setInt(1,id); 
			status=ps.executeUpdate(); // Executes the SQL statement in this PreparedStatement object, which must be an SQL 
			//Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; 
			// it returns the row count of data manipulation language. 
			con.close();//close connection.
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public  static boolean checkAuthentication(String name ,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Librarian where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status=rs.next();
			con.close();
		}
		catch(Exception e){System.out.println(e);}
		return status;
	}
	}

