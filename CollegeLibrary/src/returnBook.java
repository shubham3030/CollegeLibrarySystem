import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class returnBook extends JFrame {
    static returnBook frame;
     private JLabel l1,l2,l3;
     private JTextField tf1,tf2;
     private JButton b1,b2;
     
     public static void main(String args[]){
    	 EventQueue.invokeLater(new Runnable(){
    		 public void run(){
    			 try{
    			 frame=new returnBook("NITJ LIBRARY :: RETURN BOOK");
    			// frame.dispose();
    			frame.setVisible(true);
    		 }catch(Exception ex){
    			 ex.printStackTrace();
    		 }
    	}
    		 
    	 });
     }
     public returnBook(String s){
    	 super(s);
    	 l1=new JLabel("***RETURN BOOKS***");
    	   l1.setForeground(Color.DARK_GRAY);
    	  l1.setFont(new Font("Consolas", Font.PLAIN,18));
    	  l1.setBounds(120,20,400,30);
    	  add(l1);
    	  l2= new JLabel("BOOK NO.:>");
    	  l2.setFont(new Font("Consolas", Font.PLAIN,16));
    	  l2.setBounds(20,80,150,30);
    	  
  		l3 = new JLabel("STUDENT ID :>");
  		l3.setFont(new Font("Consolas", Font.PLAIN,16));
  		l3.setBounds(20,130,150,30);
  		add(l2);
    	add(l3);
    	tf1=new JTextField();
     	tf1.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf1.setBounds(170, 80, 270, 30);
     	tf1.setToolTipText("Enter the book Account no.");
     	add(tf1);
     	tf2=new JTextField();
     	tf2.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf2.setBounds(170, 130, 270, 30);
     	tf2.setToolTipText("Enter Student Unique ID");
     	add(tf2);
     	b1=new JButton("RETURN BOOK");
     	  b1.setBounds(130, 200, 200, 70);
     	  b1.setFont(new Font("Consolas", Font.BOLD,16));
     	  b2=new JButton("BACK");
     	  b2.setBounds(130, 290,200, 70);
     	  b2.setFont(new Font("Consolas", Font.BOLD,16));
     	  b1.setForeground(Color.DARK_GRAY);
     	  b2.setForeground(Color.DARK_GRAY);
     	 b1.addActionListener(new ActionListener(){
      		  
      		  public void actionPerformed(ActionEvent e1) {
      				String Bookno=tf1.getText();
      				String studentid=tf2.getText();
      				int i=returnBookDatabase.delete(Bookno, studentid);
   			           if(i>0){
   				            JOptionPane.showMessageDialog(returnBook.this,"Book Returned successfully!");
   			              	LibrarianSection.main(new String[]{});
   				            frame.dispose();
   				
   			          }else{
   			               try{
   			                  Thread.sleep(400);
      					}catch(Exception e5){
      						System.out.println(e5);
      					}
   				         JOptionPane.showMessageDialog(returnBook.this,"Sorry, Unable to Return Book!");
   			           }
   					
   			}});
   			
      				
      	  b2.addActionListener(new ActionListener(){
      		  public void actionPerformed(ActionEvent e1) {
      			  LibrarianSection.main(new String[]{});
      				frame.dispose();
      	  }});
      	  add(b1);
      	  add(b2);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLayout(null);
           setVisible(true);
      	   setSize(500,450);


     }
}
