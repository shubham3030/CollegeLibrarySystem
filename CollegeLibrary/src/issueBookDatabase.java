import java.sql.*;

public class issueBookDatabase {
	public static boolean checkBook(String bookcallno){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from addBooks where Bookno=?");
			ps.setString(1,bookcallno);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int saveData(int id,String Bookno,String student_id,String student_name, String branch,String mob_no){
		int status=0;
		try{
			Connection con=DB.getConnection();
			
			status=updatebook(Bookno);//updating quantity and issue
			
			if(status>0){
			PreparedStatement ps=con.prepareStatement("insert into issuebooks(Id,Bookno,Student_id,Student_name,Branch,StudentContact) values(?,?,?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2,Bookno);
			ps.setString(3,student_id);
			ps.setString(4,student_name);
			ps.setString(5,branch);
			ps.setString(6,mob_no);
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
				quantity=rs.getInt("Quantity");
				issued=rs.getInt("Issued");
			}
			
			if(quantity>0){
			PreparedStatement ps2=con.prepareStatement("update addBooks set Quantity=?,Issued=? where Bookno=?");
			ps2.setInt(1,quantity-1);
			ps2.setInt(2,issued+1);
			ps2.setString(3,Bookno);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	}


