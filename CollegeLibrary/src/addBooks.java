import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import javax.swing.*;
public class addBooks  extends JFrame{
	static addBooks frame;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	private JButton b1,b2;
	
	 public static void main(String args[]){
	      EventQueue.invokeLater(new Runnable(){
	    	 public void run(){
	    		 try{
	    		 frame=new addBooks("NITJ BOOKS");
	    		 frame.setVisible(true);
	    		 
	    	 }catch(Exception e){e.printStackTrace();}
	    	 }
	    	 
	      });
	}
	 public addBooks(String s){
		 super(s);
	   l1=new JLabel("***ADD BOOKS***");
   	   l1.setForeground(Color.DARK_GRAY);
   	  l1.setFont(new Font("Consolas", Font.PLAIN,18));
   	  l1.setBounds(120,10,400,30);
   	  add(l1);
   	  l2= new JLabel("Book No:>");
   	  l2.setFont(new Font("Consolas", Font.PLAIN,16));
   	  l2.setBounds(20,60,100,25);
   	  
 		l3 = new JLabel("Book Name:>");
 		l3.setFont(new Font("Consolas", Font.PLAIN,16));
 		l3.setBounds(20,95,100,25);
 	  
 		l4 = new JLabel("Author:>");
 		l4.setFont(new Font("Consolas", Font.PLAIN,16));
 		l4.setBounds(20,130,100,25);
 	  
 		l5 = new JLabel("Publisher:>");
 		l5.setFont(new Font("Consolas", Font.PLAIN,16));
 		l5.setBounds(20,165,100,25);
 	  
 	    l6 = new JLabel("Quantity:>");
 		l6.setFont(new Font("Consolas", Font.PLAIN,16));
 		l6.setBounds(20,200,100,25);
 		 l7 = new JLabel("Serial no:>");
  		l7.setFont(new Font("Consolas", Font.PLAIN,16));
  		l7.setBounds(20,235,100,25);
 	add(l2);
 	add(l3);
 	add(l4);
 	add(l5);
 	add(l6);
 	add(l7);
  	tf1=new JTextField();
  	tf1.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf1.setBounds(150, 60, 300, 25);
  	tf1.setToolTipText("Enter book Account no.");
  	add(tf1);
  	tf2=new JTextField();
  	tf2.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf2.setBounds(150, 95, 300, 25);
  	add(tf2);

  	tf3=new JTextField();
  	tf3.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf3.setBounds(150, 130, 300, 25);
  	add(tf3);

  	tf4=new JTextField();
  	tf4.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf4.setBounds(150, 165, 300, 25);
  	add(tf4);

  	tf5=new JTextField();
  	tf5.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf5.setBounds(150, 200, 300, 25);
  	add(tf5);
  	tf6=new JTextField();
  	tf6.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf6.setBounds(150, 235, 300, 25);
  	tf6.setToolTipText("Enter serial number of book");
  	add(tf6);
  	
 	 b1=new JButton("ADD BOOK");
	  b1.setBounds(150, 290, 200, 50);
	  b1.setFont(new Font("Consolas", Font.BOLD,16));
	  b2=new JButton("BACK");
	  b2.setBounds(150, 360,200, 50);
	  b2.setFont(new Font("Consolas", Font.BOLD,16));
	  b1.setForeground(Color.DARK_GRAY);
	  b2.setForeground(Color.DARK_GRAY);
	   
	  b1.addActionListener(new ActionListener(){
		  
		  public void actionPerformed(ActionEvent e) {
				String Bookno=tf1.getText();
				String Bookname=tf2.getText();
				String author=tf3.getText();
				String publisher=tf4.getText();
				int quantity=Integer.parseInt(tf5.getText());
				int id=Integer.parseInt(tf6.getText());
				int issued =0;
				int i=BooksDatabase.saveData( id,Bookno,Bookname, author,  publisher, quantity,issued);
				if(i>0){
					JOptionPane.showMessageDialog(addBooks.this,"Books added successfully!");
					try{
						Thread.sleep(400);
						
					}catch(Exception ex){
						System.out.println(ex);
					}
				LibrarianSection.main(new String[]{});
				frame.dispose();
					
			}
		  else{
					JOptionPane.showMessageDialog(addBooks.this,"Sorry,Unable to Save!");
					try{
						Thread.sleep(400);
						
					}catch(Exception ex){
						System.out.println(ex);
					}
					addBooks.main(new String[]{});
				}
				}
			});
	  
	  b2.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
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
