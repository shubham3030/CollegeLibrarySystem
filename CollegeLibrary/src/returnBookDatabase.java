import java.sql.*;
public class returnBookDatabase {
    public static int delete(String Bookno,String studentid){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updatebook(Bookno);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("delete from issuebooks where Bookno=? and Student_id=?");
		ps.setString(1,Bookno);
		ps.setString(2,studentid);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(String Bookno){
	int status=0;
	int quantity=0,issued=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select Quantity,Issued from addBooks where Bookno=?");
		ps.setString(1,Bookno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(issued>0){
		PreparedStatement ps2=con.prepareStatement("update addBooks set Quantity=?,Issued=? where Bookno=?");
		ps2.setInt(1,quantity+1);
		ps2.setInt(2,issued-1);
		ps2.setString(3,Bookno);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}