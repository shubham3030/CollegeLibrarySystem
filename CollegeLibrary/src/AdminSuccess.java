import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import javax.swing.*;
public class AdminSuccess extends JFrame{
      JButton b1,b2,b3,b4;
      JLabel jl;
      static AdminSuccess frame;
      public static void main(String args[]){
      EventQueue.invokeLater(new Runnable(){
    	 public void run(){
    		 try{
    		 frame=new AdminSuccess("Admin Block::");
    		 frame.setVisible(true);
    		 
    	 }catch(Exception e){e.printStackTrace();}
    	 }
    	 
      });
}
      public AdminSuccess(String s){
    	  super(s);
    	  jl=new JLabel("***ADMIN SECTION***");
    	  jl.setForeground(Color.GRAY);
    	  jl.setFont(new Font("Consolas", Font.BOLD,16));
    	  jl.setBounds(120,10,400,30);
    	  add(jl);
    	  b1=new JButton("ADD LIBRARIAN");
    	  b1.setBounds(120, 40, 180, 60);
    	  b1.setFont(new Font("Consolas", Font.BOLD,14));
    	  b2=new JButton("VIEW LIBRARIAN");
    	  b2.setBounds(120, 110, 180, 60);
    	  b2.setFont(new Font("Consolas", Font.BOLD,14));
    	  b3=new JButton("REMOVE LIBRARIAN");
    	  b3.setBounds(120, 180, 180, 60);
    	  b3.setFont(new Font("Consolas", Font.BOLD,14));
    	  b4=new JButton("LOG OUT");
    	  b4.setBounds(120, 250, 180, 60);
    	  b4.setFont(new Font("Consolas", Font.BOLD,14));
    	  b1.addActionListener(new ActionListener(){
    		  public void actionPerformed(ActionEvent e) {
    			AddLibrarian.main(new String[]{});
    				frame.dispose();
    	  }});
    	  b2.addActionListener(new ActionListener(){
    		  public void actionPerformed(ActionEvent e) {
    			  ViewLibrarian.main(new String[]{});
    				frame.dispose();
    	  }});
    	  b3.addActionListener(new ActionListener(){
    		  public void actionPerformed(ActionEvent e) {
    				DeleteLibrarian.main(new String[]{});
    				frame.dispose();
    	  }});
    	  b4.addActionListener(new ActionListener(){
    		  public void actionPerformed(ActionEvent e) {
    			  NitjLibrary.main(new String[]{});
    				frame.dispose();
    	  }});
    	
    	  add(b1);
    	  add(b2);
    	  add(b3);
    	  add(b4);
    	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	     setLayout(null);
    	 // setLocation(240,300);
    	      setVisible(true);
    		 setSize(450,400);
    	  
      }
}