
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
import javax.swing.JTextField;

public class AdminChangePassword extends JDialog implements ActionListener
{
	JLabel lbuser,lbopass,lbnpass,lbpage,lbmsg;
	JTextField txuser,txopass,txnpass;
	JButton btchange,btexit;
	JPanel pn,ps,pc,p1,pbutton;
	
	 public AdminChangePassword()
	 {
		 setSize(600,400);
		 this.setLocationRelativeTo(null);
		 Font f=new Font("Arial",Font.BOLD,34);
		 lbpage=new JLabel("CHANGE PASSWORD",JLabel.CENTER);
		 lbpage.setFont(f);
		 lbuser=new JLabel("USERNAME");
		 lbopass=new JLabel("OLD PASSWORD");
		 lbnpass=new JLabel("NEW PASSWORD");
		 lbmsg=new JLabel();
		 txuser=new JTextField(15);
		 txopass=new JTextField(15);
		 txnpass=new JTextField(15);
		 btchange=new JButton("CHANGE");
		 btexit=new JButton("CLOSE");
		 pn=new JPanel();
		 ps=new JPanel();
		 pc=new JPanel();
		 p1=new JPanel();
		 pbutton=new JPanel();
		 pbutton.add(btchange);
		 pbutton.add(btexit);
		 
		 pn=new JPanel();
		 pn.setBackground(Color.CYAN);
		 pn.add(lbpage);
		 
		 p1.setLayout(new GridLayout(3,2,10,20));
		 p1.add(lbuser);
		 p1.add(txuser);
		 p1.add(lbopass);
		 p1.add(txopass);
		 p1.add(lbnpass);
		 p1.add(txnpass);
		 
		 this.setLayout(new BorderLayout(30,50));
		 ps.setLayout(new GridLayout(2,1));
		 ps.add(pbutton);
		 ps.add(lbmsg);
		 pc.setLayout(new GridLayout(2,1,10,40));
		 pc.add(p1);
		 pc.add(ps,BorderLayout.SOUTH);
		 
		 add(pn,BorderLayout.NORTH);
		 add(pc,BorderLayout.CENTER);
		 
		 this.setVisible(true);
		 
		 btexit.addActionListener(this);
		 btchange.addActionListener(this);
	 }

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btexit)
		{
			this.dispose();
		}
		if(src==btchange)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("create database if not exists SignUpDb");
				stmt.execute("use SignUpDb");
				stmt.executeUpdate("create table if not exists AdminSignUpTb(username varchar(20),password varchar(20),adminkey int default 121,gender varchar(15),dob date,address varchar(30),question varchar(20),answer varchar(15))");
				PreparedStatement pstmt=con.prepareStatement("select count(*) from AdminSignUpTb where username=? and password=?");
				pstmt.setString(1,txuser.getText());
				pstmt.setString(2,txopass.getText());
				ResultSet rs=pstmt.executeQuery();
				int c=0;
				while(rs.next())
				{
					c=rs.getInt(1);
				}
				if(c==1)
				{
					PreparedStatement pstmt1=con.prepareStatement("update AdminSignUpTb set password=? where username=?");
					pstmt1.setString(1, txnpass.getText());
					pstmt1.setString(2, txuser.getText());
					pstmt1.executeUpdate();
					validate();
				}
				else
					JOptionPane.showMessageDialog(null,"your Old Password is incoorect");
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
}
