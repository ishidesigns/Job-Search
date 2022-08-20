import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompanyInsertPage extends JPanel implements ActionListener
{
	JLabel lbpage,lbname,lbpost,lbsalary,lbnum,lbtype,lbdate;
	JTextField txpost,txsal,txnum,txtype;
	JComboBox cbname,cbdd,cbmm,cbyy;
	JButton btinsert,btclose;
	JPanel pn,ps,pc,p1;
	
	public CompanyInsertPage()
	{
		this.setSize(1000,1000);
		this.setVisible(true);
		
		Font f=new Font("Arial",Font.BOLD,34);
		lbpage=new JLabel("INSERT DETAILS");
		lbpage.setFont(f);
		lbname=new JLabel("COMPANY NAME");
		lbpost=new JLabel("POST AVAILABLE");
		lbsalary=new JLabel("SALARY");
		lbnum=new JLabel("NUMBER OF SEATS");
		lbtype=new JLabel("POST TYPE");
		lbdate=new JLabel("PRESENT DATE");
		
		txpost=new JTextField(20);
		txsal=new JTextField(10);
		txnum=new JTextField(5);
		txtype=new JTextField(20);
		cbdd=new JComboBox();
		cbdd.addItem("dd");
		for(int i=1;i<=31;i++)
			cbdd.addItem(i);
		cbmm=new JComboBox();
		cbmm.addItem("mm");
		for(int i=1;i<=12;i++)
			cbmm.addItem(i);
		cbyy=new JComboBox();
		cbyy.addItem("yy");
		for(int i=2000;i<=2020;i++)
			cbyy.addItem(i);
		
		cbname=new JComboBox();
		cbname.addItem("Select Company");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database if not exists CompanyDb");
			stmt.execute("use CompanyDb");
			stmt.executeUpdate("create table if not exists CompanyTb(Company_Name varchar(50),Company_ID int primary key, Company_CEO varchar(50), Company_Type varchar(100), Company_HeadOffice varchar(25), Company_Contact varchar(50), No_of_branches int, Company_Scope varchar(200))");
			ResultSet rs=stmt.executeQuery("Select Company_Name from CompanyTb");
			while(rs.next())
			{
				cbname.addItem(rs.getString(1));
			}
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
		
		btinsert=new JButton("INSERT");
		btclose=new JButton("CLOSE");
		
		pn=new JPanel();
		pn.setBackground(Color.CYAN);
		pn.add(lbpage);
		
		p1=new JPanel();
		p1.add(cbdd);
		p1.add(cbmm);
		p1.add(cbyy);
		
		pc=new JPanel();
		pc.setLayout(new GridLayout(7,4,10,20));
		pc.add(new JLabel(""));
		pc.add(lbname);
		pc.add(cbname);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbdate);
		pc.add(p1);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbpost);
		pc.add(txpost);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbsalary);
		pc.add(txsal);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbnum);
		pc.add(txnum);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbtype);
		pc.add(txtype);
		pc.add(new JLabel(""));
		
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		
		ps=new JPanel();
		ps.add(btinsert);
		ps.add(btclose);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		this.setVisible(true);
		btinsert.addActionListener(this);
		btclose.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btinsert)
		{
			try
			{
				String cname=cbname.getSelectedItem().toString();
				String tablenm=cname+"_Tb";
				cname=cname.replace(' ', '_');
				cname=cname.replace('.', '_');
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt1=con.createStatement();
				stmt1.executeUpdate("create database if not exists CompanyDb");
				stmt1.execute("use CompanyDb");
				stmt1.executeUpdate("create table if not exists "+tablenm+"(Posts varchar(50),salary varchar(10), number_of_posts int,date date, type varchar(20))");
				PreparedStatement pstmt1=con.prepareStatement("insert into " +tablenm+"(Posts,salary,number_of_posts,date,type) values(?,?,?,?,?)");
				pstmt1.setString(1, txpost.getText());
				pstmt1.setString(2, txsal.getText());
				pstmt1.setInt(3, Integer.parseInt(txnum.getText()));
				pstmt1.setString(4, cbyy.getSelectedItem()+"-"+cbmm.getSelectedItem()+"-"+cbdd.getSelectedItem());
				pstmt1.setString(5, txtype.getText());
				pstmt1.executeUpdate();
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
		new CompanyInsertPage();
	}
}
