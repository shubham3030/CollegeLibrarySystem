import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import javax.swing.*;
public class issueBook extends JFrame{
       private JButton b1,b2;
       private JLabel l1,l2,l3,l4,l5,l6,l7;
       JTextField tf1,tf2,tf3,tf4,tf5,tf6;
      static issueBook frame;
      public static void main(String args[]){
      EventQueue.invokeLater(new Runnable(){
    	 public void run(){
    		 try{
    		 frame=new issueBook("NITJ LIBRARY");
    		 frame.setVisible(true);
    		 
    	 }catch(Exception e){e.printStackTrace();}
    	 }
    	 
      });
}
      public issueBook(String s){
    	  super(s);
    	  l1=new JLabel("***ISSUE BOOKS***");
      	   l1.setForeground(Color.DARK_GRAY);
      	  l1.setFont(new Font("Consolas", Font.PLAIN,18));
      	  l1.setBounds(120,10,400,30);
      	  add(l1);
      	  l2= new JLabel("Serial no:>");
      	  l2.setFont(new Font("Consolas", Font.PLAIN,16));
      	  l2.setBounds(20,60,150,25);
      	  
    		l3 = new JLabel("BOOK NO:>");
    		l3.setFont(new Font("Consolas", Font.PLAIN,16));
    		l3.setBounds(20,95,150,25);
    	  
    		l4 = new JLabel("Student ID:>");
    		l4.setFont(new Font("Consolas", Font.PLAIN,16));
    		l4.setBounds(20,130,150,25);
    	  
    		l5 = new JLabel("Student Name:>");
    		l5.setFont(new Font("Consolas", Font.PLAIN,16));
    		l5.setBounds(20,165,150,25);
    	  
    	    l6 = new JLabel("Branch:>");
    		l6.setFont(new Font("Consolas", Font.PLAIN,16));
    		l6.setBounds(20,200,150,25);
    		 l7 = new JLabel("Student Mob.No:>");
     		l7.setFont(new Font("Consolas", Font.PLAIN,16));
     		l7.setBounds(20,235,150,25);
    	add(l2);
    	add(l3);
    	add(l4);
    	add(l5);
    	add(l6);
    	add(l7);
     	tf1=new JTextField();
     	tf1.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf1.setBounds(170, 60, 300, 25);
     	tf1.setToolTipText("Must be unique");
     	add(tf1);
     	tf2=new JTextField();
     	tf2.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf2.setBounds(170, 95, 300, 25);
     	tf2.setToolTipText("Enter book Account no.");
     	add(tf2);

     	tf3=new JTextField();
     	tf3.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf3.setBounds(170, 130, 300, 25);
     	add(tf3);

     	tf4=new JTextField();
     	tf4.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf4.setBounds(170, 165, 300, 25);
     	add(tf4);

     	tf5=new JTextField();
     	tf5.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf5.setBounds(170, 200, 300, 25);
     	add(tf5);
     	tf6=new JTextField();
     	tf6.setFont(new Font("Consolas", Font.PLAIN,14));
     	tf6.setBounds(170, 235, 300, 25);
     	//tf6.setToolTipText("Enter serial number of book");
     	add(tf6);
     	
      b1=new JButton("ISSUE BOOK");
   	  b1.setBounds(130, 290, 200, 50);
   	  b1.setFont(new Font("Consolas", Font.BOLD,16));
   	  b2=new JButton("BACK");
   	  b2.setBounds(130, 360,200, 50);
   	  b2.setFont(new Font("Consolas", Font.BOLD,16));
   	  b1.setForeground(Color.DARK_GRAY);
   	  b2.setForeground(Color.DARK_GRAY);
   	   
   	 b1.addActionListener(new ActionListener(){
   		  
   		  public void actionPerformed(ActionEvent e1) {
   				String Bookno=tf2.getText();
   				String student_id=tf3.getText();
   				String student_name=tf4.getText();
   				String branch=tf5.getText();
   				String mob_no =tf6.getText();
   				int id=Integer.parseInt(tf1.getText());
   				if(issueBookDatabase.checkBook(Bookno)){
			
	           int i=issueBookDatabase.saveData(id,Bookno, student_id, student_name,branch, mob_no);
			           if(i>0){
				            JOptionPane.showMessageDialog(issueBook.this,"Book issued successfully!");
			              	LibrarianSection.main(new String[]{});
				            frame.dispose();
				
			          }else{
				         JOptionPane.showMessageDialog(issueBook.this,"Sorry, Unable to issue!");
			           }
			
			}else{
			       try{
   						Thread.sleep(400);
   						
   					}catch(Exception ex){
   						System.out.println(ex);
   					}
   			
				JOptionPane.showMessageDialog(issueBook.this,"Sorry, Book doesn't exist!");
				frame.dispose();
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
   	 setSize(500,480);

      }
}
