import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import javax.swing.*;
public class AddLibrarian extends JFrame{
       private JButton b1,b2;
       private JLabel jl;
       JTextField tf1,tf3,tf4,tf5;
       JPasswordField tf2;
      static AddLibrarian frame;
      public static void main(String args[]){
      EventQueue.invokeLater(new Runnable(){
    	 public void run(){
    		 try{
    		 frame=new AddLibrarian("Librarian Form");
    		 frame.setVisible(true);
    		 
    	 }catch(Exception e){e.printStackTrace();}
    	 }
    	 
      });
}
      public AddLibrarian(String s){
    	  super(s);
    	  jl=new JLabel("***ADD LIBRARIAN***");
    	  jl.setForeground(Color.DARK_GRAY);
    	  jl.setFont(new Font("Consolas", Font.PLAIN,18));
    	  jl.setBounds(120,10,400,30);
    	  add(jl);
    	  JLabel lblName = new JLabel("Name:");
    	  lblName.setFont(new Font("Consolas", Font.PLAIN,16));
    	  lblName.setBounds(20,40,100,25);
    	  
  		JLabel lblPassword = new JLabel("Password:");
  		lblPassword.setFont(new Font("Consolas", Font.PLAIN,16));
  		lblPassword.setBounds(20,75,100,25);
  	  
  		JLabel lblEmail = new JLabel("ID:");
  		lblEmail.setFont(new Font("Consolas", Font.PLAIN,16));
  		lblEmail.setBounds(20,110,100,25);
  	  
  		JLabel lblCity = new JLabel("City:");
  		lblCity.setFont(new Font("Consolas", Font.PLAIN,16));
  		lblCity.setBounds(20,145,100,25);
  	  
  		JLabel lblContactNo = new JLabel("Mob.No:");
  		lblContactNo.setFont(new Font("Consolas", Font.PLAIN,16));
  		lblContactNo.setBounds(20,180,100,25);
  	add(lblName);
  	add(lblPassword);
  	add(lblEmail);
  	add(lblCity);
  	add(lblContactNo);
  	
  	tf1=new JTextField();
  	tf1.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf1.setBounds(110, 40, 300, 25);
  	add(tf1);
  	tf2=new JPasswordField();
  	tf2.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf2.setBounds(110, 75, 300, 25);
  	add(tf2);

  	tf3=new JTextField();
  	tf3.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf3.setBounds(110, 110, 300, 25);
  	add(tf3);

  	tf4=new JTextField();
  	tf4.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf4.setBounds(110, 145, 300, 25);
  	add(tf4);

  	tf5=new JTextField();
  	tf5.setFont(new Font("Consolas", Font.PLAIN,14));
  	tf5.setBounds(110, 180, 300, 25);
  	add(tf5);
  	
  	 b1=new JButton("ADD LIBRARIAN");
	  b1.setBounds(130, 225, 200, 60);
	  b1.setFont(new Font("Consolas", Font.BOLD,16));
	  b2=new JButton("BACK");
	  b2.setBounds(130, 300,200, 50);
	  b2.setFont(new Font("Consolas", Font.BOLD,16));
	  b1.setForeground(Color.DARK_GRAY);
	  b2.setForeground(Color.DARK_GRAY);
	  b1.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
				String name=tf1.getText();
				String password=String.valueOf(tf2.getPassword());
				String Id=tf3.getText();
				String city=tf4.getText();
				String contact=tf5.getText();

				int i=LibrarianDatabase.saveData(name, password, Id, city, contact);
				if(i>0){
					JOptionPane.showMessageDialog(AddLibrarian.this,"Librarian added successfully!");
					AdminSuccess.main(new String[]{});
					frame.dispose();
					
			}
		  else{
					JOptionPane.showMessageDialog(AddLibrarian.this,"Sorry,Error Occured!");
					try{
						Thread.sleep(400);
						
					}catch(Exception ex){
						System.out.println(ex);
					}
					AddLibrarian.main(new String[]{});
				}
				}
			});
	  
	  b2.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
			  AdminSuccess.main(new String[]{});
				frame.dispose();
	  }});
	  add(b1);
	  add(b2);


  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     setLayout(null);
 	 // setLocation(240,300);
 	      setVisible(true);
 		 setSize(500,400);
 	
    	  
    	  
      }
}

