

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class AdminNewPassword extends JDialog implements ActionListener
{
	JLabel lbpage,lbnpass,lbuser;
	JTextField txnpass,txuser;
	JButton btchange,btclose;
	JPanel pn,pc,ps,ppass;
	
	public AdminNewPassword()
	{
		setSize(600,500);
		this.setLocationRelativeTo(null);
		Font f=new Font("Arial",Font.BOLD,34);
		lbpage=new JLabel("NEW PASSWORD",JLabel.CENTER);
		lbpage.setFont(f);
		lbuser=new JLabel("USERNAME");
		txuser=new JTextField(50);
		txnpass=new JTextField(35);
		lbnpass=new JLabel("NEW PASSWORD");
		btchange=new JButton("CHANGE");
		btclose=new JButton("CLOSE");
		
		pc=new JPanel();
		pc.setLayout(new GridLayout(2,3));
		pc.add(lbuser);
		pc.add(new JLabel(""));
		pc.add(txuser);
		pc.add(lbnpass);
		pc.add(new JLabel(""));
		pc.add(txnpass);
		
		ps=new JPanel();
		ps.add(btchange);
		ps.add(btclose);
		
		pn=new JPanel();
		pn.setLayout(new GridLayout(5,1));
		pn.add(lbpage);
		pn.add(new JLabel(""));
		pn.add(pc);
		pn.add(new JLabel(""));
		pn.add(ps);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		
		btchange.addActionListener(this);
		btclose.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btclose)
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
				PreparedStatement pstmt=con.prepareStatement("update AdminSignUpTb set password=? where username=?");
				pstmt.setString(1, txnpass.getText());
				pstmt.setString(2, txuser.getText());
				pstmt.executeUpdate();
				validate();
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
