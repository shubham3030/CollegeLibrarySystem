import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
 public class AdminLogin extends JFrame  {
	 static AdminLogin frame; 
	 private JPanel jp;
	 private JPasswordField pw;
	 private JTextField tf;
	 
	 public static void main(String args[]){
		 //static method can call only static variable;
		 EventQueue.invokeLater(new Runnable() {  // This method add thread in a queue and it is processed after all pending event occours)
			 public void run() {//overriding of run method of runnable interface
					try {
						frame = new AdminLogin("Admin Login");
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace(); // this method is used to trace the path of exception(where the exception occured)
					}
				}
		 });
	 }
	 
	 public AdminLogin(String s) {
		 super(s); // calling JFrame class constructor
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(100, 100, 450, 300);
		 jp=new JPanel();
		 jp.setBorder(new EmptyBorder(5,5,5,5));// sets the border of the pane
		 setContentPane(jp);
		 JLabel jb =new JLabel(" ***ADMIN LOGIN*** ");
		 jb.setForeground(Color.GRAY);
		 jb.setFont(new Font("Consolas", Font.BOLD,16));
		 
		 JLabel adminid= new JLabel("Enter Admin Id::>");
		 adminid.setFont(new Font("Consolas", Font.PLAIN, 14));
		 
		 JLabel adpass= new JLabel("Enter Password::>");
		 adpass.setFont(new Font("Consolas", Font.PLAIN, 14));
		 
		 tf= new JTextField();
			tf.setColumns(10);//Sets the number of columns in this TextField, and then invalidate the layout.
			
			tf.setToolTipText("Enter authorised admin id");
			
			JButton btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String name=tf.getText();
				String password=String.valueOf(pw.getPassword());
				if(name.equals("CSE15103030")&&password.equals("PASSWORD")){
				AdminSuccess.main(new String[]{});
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					tf.setText("");
					pw.setText("");
				}
				}
			});
			
			pw= new JPasswordField();
			pw.setToolTipText("Enter your login password...");
			GroupLayout gl= new GroupLayout(jp);// creating Horizontal and vertical groups
			gl.setHorizontalGroup(
					gl.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl.createSequentialGroup()
							.addGroup(gl.createParallelGroup(Alignment.LEADING)
								.addGroup(gl.createSequentialGroup()
									.addGap(124)
									.addComponent(jb))
								.addGroup(gl.createSequentialGroup()
									.addGap(19)
									.addGroup(gl.createParallelGroup(Alignment.LEADING)
										.addComponent(adminid)
										.addComponent(adpass))
									.addGap(50)
									.addGroup(gl.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pw)
										.addComponent(tf, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
							.addContainerGap(107, Short.MAX_VALUE))
						.addGroup(gl.createSequentialGroup()
							.addContainerGap(187, Short.MAX_VALUE)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(180))
				);
				gl.setVerticalGroup(
					gl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl.createSequentialGroup()
							.addComponent(jb)
							.addGap(26)
							.addGroup(gl.createParallelGroup(Alignment.BASELINE)
								.addComponent(adminid)
								.addComponent(tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl.createParallelGroup(Alignment.BASELINE)
								.addComponent(adpass)
								.addComponent(pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(80, Short.MAX_VALUE))
				);
				jp.setLayout(gl);
			}
		}
			
	 
	 


