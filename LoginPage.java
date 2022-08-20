
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JDialog implements ActionListener
{
	JLabel lbpage,lbuser,lbpass,lbmsg;
	JTextField txuser;
	JPasswordField txpass;
	JButton btlogin,btclose,btsignup,btforgot,btchange;
	JPanel pn,pc,ps,p1,p2,p3,ps1,ps2;
	
	 public LoginPage()
	 {
		 setSize(600,600);
		 this.setLocationRelativeTo(null);
		 Font f=new Font("Arial",Font.BOLD,30);
		 Font f1=new Font("comic sans",Font.BOLD,16);
		 lbpage=new JLabel("LOGIN OR CREATE ACCOUNT",JLabel.CENTER);
		 lbpage.setFont(f);
		 lbuser=new JLabel("USERNAME");
		 lbpass=new JLabel("PASSWORD");
		 lbmsg=new JLabel();
		 lbmsg.setForeground(Color.RED);
		 txuser=new JTextField(15);
		 txpass=new JPasswordField(15);
		 txpass.setEchoChar('*');
		 btlogin=new JButton("LOGIN");
		 btclose=new JButton("CLOSE");
		 btsignup=new JButton("Sign Up");
		 btsignup.setFont(f1);
		 btsignup.setForeground(Color.BLUE);
		 btforgot=new JButton("Forgot Password");
		 btforgot.setFont(f1);
		 btforgot.setForeground(Color.BLUE);
		 btchange=new JButton("Change Password");
		 btchange.setFont(f1);
		 btchange.setForeground(Color.BLUE);
		 
		 p1=new JPanel();
		 p1.setLayout(new GridLayout(1,4,10,20));
		 p1.add(new JLabel(""));
		 p1.add(lbuser);
		 p1.add(txuser);
		 p1.add(new JLabel(""));
		 
		 p2=new JPanel();
		 p2.setLayout(new GridLayout(1,4,10,20));
		 p2.add(new JLabel(""));
		 p2.add(lbpass);
		 p2.add(txpass);
		 p2.add(new JLabel(""));
		 
		 p3=new JPanel();
		 p3.add(btlogin);
		 p3.add(btclose);
		 
		 pn=new JPanel();
		 pn.setBackground(Color.CYAN);
		 pn.add(lbpage);
		 
		 ps1=new JPanel();
		 ps1.setLayout(new GridLayout(1,3,10,20));
		 ps1.add(btsignup);
		 ps1.add(btforgot);
		 ps1.add(btchange);
		  
		 ps2=new JPanel();
		 ps2.add(lbmsg);
		 
		 ps=new JPanel();
		 ps.setLayout(new GridLayout(2,1,10,20));
		 ps.add(ps1);
		 ps.add(ps2);
		 
		 this.setLayout(new BorderLayout());
		 
		 pc=new JPanel();
		 pc.setLayout(new GridLayout(6,2,10,20));
		 pc.add(p1);
		 pc.add(p2);
		 pc.add(p3);
		 pc.add(ps,BorderLayout.SOUTH);
		 
		 add(pn,BorderLayout.NORTH);
		 add(pc,BorderLayout.CENTER);
		 
		 btlogin.addActionListener(this);
		 btclose.addActionListener(this);
		 btsignup.addActionListener(this);
		 btforgot.addActionListener(this);
		 btchange.addActionListener(this);
		 
		 this.setVisible(true);
	 }

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btsignup)
		{
			new SignUpPage();
		}
		if(src==btforgot)
		{
			new ForgotPasswordPage();
		}
		if(src==btchange)
		{
			new ChangePasswordPage();
		}
		if(src==btclose)
		{
			this.dispose();
		}
		if(src==btlogin)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("create database if not exists SignUpDb");
				stmt.execute("use SignUpDb");
				stmt.executeUpdate("create table if not exists SignUpTb(username varchar(150) primary key,password varchar(100),mobile_number int,address varchar(25),dob date,gender varchar(10),college_name varchar(100),state varchar(25),passing_year int, experience int,question varchar(100),answer varchar(100))");		
				PreparedStatement pstmt=con.prepareStatement("select count(*) from SignUpTb where username=? and password=?");
				pstmt.setString(1,txuser.getText());
				pstmt.setString(2,txpass.getText());
				ResultSet rs=pstmt.executeQuery();
				int c=0;
				while(rs.next())
				{
					c=rs.getInt(1);
				}
				if(c==1)
				{
					JOptionPane.showMessageDialog(null,"WELCOME");
					new UserSectionPage();
				}
				else
					lbmsg.setText("\nusername or password is incorrect");
				
				con.close();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[]args)
	{
		new LoginPage();
	}
}
