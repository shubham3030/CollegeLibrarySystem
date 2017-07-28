import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class viewIssuedBooks  extends JFrame{
	 JTable table;
	   //private JPanel contentPane;
	  JButton jb;  
	 static viewIssuedBooks frame;
	   public static void main(String args[]){
		      EventQueue.invokeLater(new Runnable(){
		    	 public void run(){
		    		 try{
		    		 frame=new viewIssuedBooks("NITJ LIBRARY::BOOKS ISSUED");
		    		 frame.setVisible(true);
		    		 
		    	 }catch(Exception e){e.printStackTrace();}
		    	 }
		    	 
		      });
		}
	   public viewIssuedBooks(String s){
		   super(s);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 350);
			//contentPane = new JPanel();
			//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			JFrame frame1 = new JFrame();
			Container contentPane = frame1.getContentPane();
			
			contentPane.setLayout(new BorderLayout(2, 2));
			setContentPane(contentPane);//Sets the contentPane property. This method is called by the constructor. 
			
			String data[][]=null;
		    String col[]=null;
		    try{
		    	Connection con = DB.getConnection();
		    	PreparedStatement ps=con.prepareStatement("Select * from issuebooks",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    	//The constant indicating the type for a ResultSet object that is scrollable and updateable
		        ResultSet rs = ps.executeQuery();
		        ResultSetMetaData rsmd=rs.getMetaData();  // gives the information of data about data
		        int i=rsmd.getColumnCount(); // returns the number of columns
		        col=new String[i]; 
		        for(int j=1;j<=i;j++){
		        	col[j-1]=rsmd.getColumnName(j);// returns column name at specified index
		        }
		       rs.last();//moves the cursor to the last row in the resultset object
		        int rc=rs.getRow();//Recieve the current row  number
		        rs.beforeFirst();// moves the cursor to the beginning of result set(before first row)
		        data=new String[rc][i];
				int count=0;
				while(rs.next()){
					for(int k=1;k<=i;k++){
						data[count][k-1]=rs.getString(k);
					}
					count++;
				}
				con.close();
			
		        
		    }catch(Exception e1){ e1.printStackTrace();}
		    table=new JTable(data,col);
		   // table.setCellSelectionEnabled(true); // allows row and column selection 
		    table.setBounds(30,40,300,300);
		    JScrollPane sp=new JScrollPane(table); // add scrollpane to the table
		    contentPane.add(sp, BorderLayout.CENTER);
		    jb=new JButton("BACK");
		    jb.setBounds(110, 320, 200, 70);
		    jb.addActionListener( new ActionListener(){
		    	public void actionPerformed(ActionEvent e){
		    		String args[]={};
		    	   LibrarianSection.main(args);
		    	    frame.dispose();

		    	}
		    });
		    contentPane.add(jb,BorderLayout.SOUTH);

	   }


}

