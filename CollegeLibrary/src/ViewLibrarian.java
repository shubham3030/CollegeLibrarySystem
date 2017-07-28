import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
public class ViewLibrarian extends JFrame {
   JTable table;
   //private JPanel contentPane;
   private JButton jb;
   static ViewLibrarian frame;
   public static void main(String args[]){
	      EventQueue.invokeLater(new Runnable(){
	    	 public void run(){
	    		 try{
	    		 frame=new ViewLibrarian("LIBRARIAN LIST");
	    		 frame.setVisible(true);
	    		 
	    	 }catch(Exception e){e.printStackTrace();}
	    	 }
	    	 
	      });
	}

public ViewLibrarian(String s){
	super(s);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 700, 350);
	//contentPane = new JPanel();
	JFrame frame1 = new JFrame();
	Container contentPane = frame1.getContentPane();
	//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(2, 2));
	setContentPane(contentPane);//Sets the contentPane property. This method is called by the constructor. 
	
	String data[][]=null;
    String col[]=null;
    try{
    	Connection con = DB.getConnection();
    	PreparedStatement ps=con.prepareStatement("Select * from Librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    	//The constant indicating the type for a ResultSet object that is scrollable and updateable
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();  // gives the information of data about data
        int i=rsmd.getColumnCount(); // returns the number of columns
        col=new String[i]; 
        for(int j=1;j<=i;j++){
        	col[j-1]=rsmd.getColumnName(j);// returns column name at specified index
        }
       rs.last();//moves the cursor to the last roe in the resultset object
        int rc=rs.getRow();//Recieve the current row  number
        rs.beforeFirst();// moves the cursor to the begining of result set(before first row)
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
    table.setCellSelectionEnabled(true); // allows row and column selection 
    table.setBounds(30,40,200,300);
    JScrollPane sp=new JScrollPane(table); // add scrollpane to the table
    contentPane.add(sp, BorderLayout.CENTER);
    jb=new JButton("BACK");
    jb.setBounds(110, 320, 200, 70);
    jb.addActionListener( new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		String args[]={};
    	    AdminSuccess.main(args);
    	    frame.dispose();

    	}
    });
    contentPane.add(jb,BorderLayout.SOUTH);
   /* try{
		Thread.sleep(1000);
		
	}catch(Exception ex){
		System.out.println(ex);
	}
    String args[]={};
    AdminSuccess.main(args);*/
}
}
