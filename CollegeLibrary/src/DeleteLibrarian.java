import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DeleteLibrarian extends JFrame {
	static DeleteLibrarian frame;
	private JLabel l1 ,l2 ;
	private JTextField tf;
	private JButton b1,b2;
	public static void main(String args[]){
	      EventQueue.invokeLater(new Runnable(){
	    	 public void run(){
	    		 try{
	    		 frame=new DeleteLibrarian("Remove Librarian");
	    		 frame.setVisible(true);
	    		 
	    	 }catch(Exception e){e.printStackTrace();}
	    	 }
	    	 
	      });
	}
	public DeleteLibrarian(String s){
		super(s);
		l1=new JLabel("***REMOVE LIBRARIAN***");
		l1.setForeground(Color.darkGray);
		l1.setFont(new Font("Consolas", Font.BOLD,18));
		l1.setBounds(120,10,300,40);
		add(l1);
		l2 = new JLabel("Enter id::>");
		l2.setFont(new Font("Consolas", Font.PLAIN,16));
		l2.setBounds(40,60,100,30);
		add(l2);
		tf=new JTextField();
		tf.setToolTipText("Enter the id here!!");
		tf.setBackground(getForeground());
		tf.setBounds(150,60,250,30);
		add(tf);
		 b1=new JButton("DELETE");
		  b1.setBounds(130, 125, 200, 60);
		  b1.setFont(new Font("Consolas", Font.BOLD,16));
		  b2=new JButton("BACK");
		  b2.setBounds(130, 200,200, 60);
		  b2.setFont(new Font("Consolas", Font.BOLD,16));
		  b1.setForeground(Color.darkGray);
		  b2.setForeground(Color.darkGray);
		  b1.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
					{
						String L_id=tf.getText();
						if(L_id==null||L_id.trim().equals("")){
							JOptionPane.showMessageDialog(DeleteLibrarian.this,"Id can't be blank");}
						else{
							int id=Integer.parseInt(L_id);
							int i = LibrarianDatabase.Delete(id);
							if(i>0){
								JOptionPane.showMessageDialog(DeleteLibrarian.this,"Record deleted successfully!");
							}else{
								JOptionPane.showMessageDialog(DeleteLibrarian.this,"Unable to delete given id!");
							}
							}
							
						}
			  }});			  
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
	 		 setSize(450,360);
	}

}
