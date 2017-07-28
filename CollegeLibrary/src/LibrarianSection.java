import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LibrarianSection extends JFrame{
    static LibrarianSection frame;
    private JLabel l1;
    private JButton b1,b2,b3,b4,b5,b6;
    
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					frame=new LibrarianSection("LIBRARIAN SECTION");
					frame.setVisible(true);
				}catch(Exception e){e.printStackTrace();}
			}
		});
		
	}
	public LibrarianSection(String s){
		super(s);
		l1=new JLabel("***Librarian Work Space***");
		l1.setForeground(Color.darkGray);
		l1.setFont(new Font("Consolas", Font.BOLD,18));
		l1.setBounds(120,10,300,40);
		add(l1);
	  b1=new JButton("ADD BOOKS");
   	  b1.setBounds(130, 60, 220, 40);
   	  b1.setFont(new Font("Consolas", Font.BOLD,14));
   	  b2=new JButton("VIEW BOOKS");
   	  b2.setBounds(130, 120, 220, 40);
   	  b2.setFont(new Font("Consolas", Font.BOLD,14));
   	  b3=new JButton("ISSUE BOOKS");
   	  b3.setBounds(130, 180, 220, 40);
   	  b3.setFont(new Font("Consolas", Font.BOLD,14));
   	  b4=new JButton("VIEW ISSUED BOOKS");
   	  b4.setBounds(130, 240, 220, 40);
   	  b4.setFont(new Font("Consolas", Font.BOLD,14));
   	  b5=new JButton("RETURN BOOK");
   	  b5.setBounds(130, 300, 220, 40);
 	  b5.setFont(new Font("Consolas", Font.BOLD,14));
 	  b6=new JButton("LOG-OUT");
 	  b6.setBounds(130, 360, 220, 40);
 	  b6.setFont(new Font("Consolas", Font.BOLD,14));
 	  
   	  b1.addActionListener(new ActionListener(){
   		  public void actionPerformed(ActionEvent e) {
   			try{
				Thread.sleep(300);
				
			}catch(Exception ex){
				System.out.println(ex);
			}
			
   			addBooks.main(new String[]{});
   				frame.dispose();
   	  }});
   	  b2.addActionListener(new ActionListener(){
   		  public void actionPerformed(ActionEvent e) {
   			try{
				Thread.sleep(300);
				
			}catch(Exception ex){
				System.out.println(ex);
			}
			
   			 viewBooks.main(new String[]{});
   				frame.dispose();
   	  }});
   	  b3.addActionListener(new ActionListener(){
   		  public void actionPerformed(ActionEvent e) {
   			try{
				Thread.sleep(300);
				
			}catch(Exception ex){
				System.out.println(ex);
			}
			
   				issueBook.main(new String[]{});
   				frame.dispose();
   	  }});
   	  b4.addActionListener(new ActionListener(){
   		  public void actionPerformed(ActionEvent e) {
   			try{
				Thread.sleep(300);
				
			}catch(Exception ex){
				System.out.println(ex);
			}
			
   			  viewIssuedBooks.main(new String[]{});
   				frame.dispose();
   	  }});
   	b5.addActionListener(new ActionListener(){
 		  public void actionPerformed(ActionEvent e) {
 			 try{
					Thread.sleep(300);
					
				}catch(Exception ex){
					System.out.println(ex);
				}
				
 			returnBook.main(new String[]{});
 				frame.dispose();
 	  }});
 	  b6.addActionListener(new ActionListener(){
 		  public void actionPerformed(ActionEvent e) {
 			 try{
					Thread.sleep(400);
					
				}catch(Exception ex){
					System.out.println(ex);
				}
				
 			 NitjLibrary.main(new String[]{});
 				frame.dispose();
 	  }});
 	  
   	  add(b1);
   	  add(b2);
   	  add(b3);
   	  add(b4);
   	  add(b5);
  	  add(b6);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setLayout(null);
	 // setLocation(240,300);
	      setVisible(true);
		 setSize(500,490);

		
	}
	
}
