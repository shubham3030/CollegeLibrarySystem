import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class NitjLibrary extends JFrame {
	 public  JLabel jb1;
	 public JButton b1 ,b2,b3;
	 
	static NitjLibrary frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Creating a new thread
			public void run() { // call will not initialise a new call stack
				try {
					frame= new NitjLibrary("NITJ LIBRARY MANAGEMENT SYSTEM");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

  public NitjLibrary(String s){
	  super(s);
	  jb1=new JLabel("***WELCOME TO NITJ LIBRARY***");
	  jb1.setForeground(Color.GRAY);
	  jb1.setFont(new Font("Consolas", Font.BOLD,16));
	  jb1.setBounds(90,10,400,30);
	  add(jb1);
	  b1=new JButton("ADMIN LOGIN");
	  b1.setFont(new Font("Consolas", Font.BOLD,14));
	  b1.setBounds(110, 55, 200, 70);
	  
	  b2=new JButton("LIBRARIAN LOGIN");
	  b2.setFont(new Font("Consolas", Font.BOLD,14));
	  b2.setBounds(110, 135, 200, 70);
	  b1.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
				frame.dispose();
	  }});
	  
	  b2.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e1) {
				LibrarianLogin.main(new String[]{});
				frame.dispose();
	  }});
	  b3=new JButton("EXIT");
	  b3.setFont(new Font("Consolas", Font.BOLD,14));
	  b3.setBounds(110, 215, 200, 70);
	  b3.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
			  JOptionPane.showMessageDialog(NitjLibrary.this,"THANKU....\n\t NITJ LIBRARY!!!");
				//System.exit(0);
				frame.dispose();
	  }});
	
	  
	  add(b1);
	  add(b2);
	  add(b3);
	  
	  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(null);
 // setLocation(240,300);
      setVisible(true);
	 setSize(450,350);
		
	  
}
}