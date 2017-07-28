import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LibrarianLogin extends JFrame{
	static LibrarianLogin frame;
   private	JLabel l1,l2,l3;
   private JTextField tf;
   private JPasswordField pw;
   private JButton b1;
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					frame=new LibrarianLogin("LIBRARIAN LOGIN");
					frame.setVisible(true);
				}catch(Exception e){e.printStackTrace();}
			}
		});
		
	}
	public LibrarianLogin(String s){
		super(s);
		l1=new JLabel("***Librarian login Portal***");
		l1.setForeground(Color.darkGray);
		l1.setFont(new Font("Consolas", Font.BOLD,18));
		l1.setBounds(120,10,300,40);
		add(l1);
		l2 = new JLabel("User Name::>");
		l2.setFont(new Font("Consolas", Font.PLAIN,16));
		l2.setBounds(30,80,130,30);
		add(l2);
		l3 = new JLabel("Password::>");
		l3.setFont(new Font("Consolas", Font.PLAIN,16));
		l3.setBounds(30,130,130,30);
		add(l3);
		tf=new JTextField();
		tf.setToolTipText("Enter the name here(case sensitive)!!");
		//tf.setBackground(getForeground());
		tf.setBounds(160,80,250,30);
		add(tf);
		pw=new JPasswordField();
		pw.setToolTipText("Enter your login password...");
		pw.setForeground(Color.LIGHT_GRAY);
		pw.setBounds(160, 130, 250, 30);
		add(pw);
		b1=new JButton("LOGIN");
		b1.setBounds(180, 200, 220, 40);
	    b1.setFont(new Font("Consolas", Font.BOLD,16));
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				String name=tf.getText();
				String password=String.valueOf(pw.getPassword());
				if(LibrarianDatabase.checkAuthentication(name, password)){
					LibrarianSection.main(new String[]{});
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(LibrarianLogin.this, "Sorry!!\n\t,Incorrect Username or Password","Login Error!", JOptionPane.ERROR_MESSAGE);
					tf.setText("");
					pw.setText("");
				}
				
			}
		});
		add(b1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setLayout(null);
	 // setLocation(240,300);
	      setVisible(true);
		 setSize(500,400);

	}

}
