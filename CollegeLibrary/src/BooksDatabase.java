import java.sql.*;
public class BooksDatabase {
     public static int saveData(int Id,String key , String name , String author, String publisher ,int quantity,int issued){
    	 int status=0;
    		try{
    			Connection con=DB.getConnection();
    			PreparedStatement ps=con.prepareStatement("insert into addbooks(Id,Bookno,Bookname,Author,Publisher,Quantity,Issued) values(?,?,?,?,?,?,?)");
    			ps.setInt(1, Id);
    			ps.setString(2,key);
    			ps.setString(3,name);
    			ps.setString(4,author);
    			ps.setString(5,publisher);
    			ps.setInt(6,quantity);
    			ps.setInt(7,issued);
    			status=ps.executeUpdate();
    			con.close();
    		}catch(Exception e){System.out.println(e);}
    		return status;
    	}
}

