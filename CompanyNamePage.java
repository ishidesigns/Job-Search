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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompanyNamePage extends JPanel implements ActionListener
{
	JLabel lbcompID,lbcompname,lbcompCEO,lbcomptype,lbheadoffice,lbcontact,lbcompnum,lbscope,lbpage;
	JComboBox cbname;
	JTextField txid,txname,txceo,txtype,txheadoffice,txcontact,txcompnum,txscope;
	JPanel pn,pc,ps;
	JButton btsubmit,btclose;
	
	public CompanyNamePage()
	{
		this.setSize(1000,1000);
		this.setVisible(true);
		
		Font f=new Font("Arial",Font.BOLD,34);
		lbpage=new JLabel("COMPANY DETAILS",JLabel.CENTER);
		lbpage.setFont(f);
		lbcompname=new JLabel("COMPANY NAME");
		lbcompID=new JLabel("COMPANY ID");
		lbcompCEO=new JLabel("COMPANY CEO");
		lbcomptype=new JLabel("COMPANY TYPE");
		lbheadoffice=new JLabel("COMPANY'S HEAD OFFICE");
		lbcontact=new JLabel("COMPANY CONTACT NUMBER");
		lbcompnum=new JLabel("NUMBER OF BRANCHES");
		lbscope=new JLabel("SCOPE");
		
		txid=new JTextField(10);
		txname=new JTextField(20);
		txceo=new JTextField(25);
		txtype=new JTextField(20);
		txheadoffice=new JTextField(20);
		txcontact=new JTextField(15);
		txcompnum=new JTextField(5);
		txscope=new JTextField(25);
		
		btsubmit=new JButton("SUBMIT");
		btclose=new JButton("CLOSE");
		
		pn=new JPanel();
		pn.setBackground(Color.CYAN);
		pn.add(lbpage);
		
		pc=new JPanel();
		pc.setLayout(new GridLayout(9,4,10,20));
		pc.add(new JLabel(""));
		pc.add(lbcompname);
		pc.add(txname);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbcompID);
		pc.add(txid);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbcompCEO);
		pc.add(txceo);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbcomptype);
		pc.add(txtype);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbheadoffice);
		pc.add(txheadoffice);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbcontact);
		pc.add(txcontact);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbcompnum);
		pc.add(txcompnum);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbscope);
		pc.add(txscope);
		pc.add(new JLabel(""));
		
		ps=new JPanel();
		ps.add(btsubmit);
		ps.add(btclose);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		btsubmit.addActionListener(this);
		btclose.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btsubmit)
		{
			
			try
			{
				String cname=txname.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("create database if not exists CompanyDb");
				stmt.execute("use CompanyDb");
				stmt.executeUpdate("create table if not exists CompanyTb(Company_Name varchar(25),Company_ID int primary key, Company_CEO varchar(50), Company_Type varchar(100), Company_HeadOffice varchar(50), Company_Contact varchar(50), No_of_branches int, Company_Scope varchar(200))");
				PreparedStatement pstmt=con.prepareStatement("insert into CompanyTb(Company_Name,Company_ID,Company_CEO,Company_Type,Company_HeadOffice,Company_Contact,No_of_branches,Company_Scope) values(?,?,?,?,?,?,?,?)");
				pstmt.setString(1, txname.getText());
				pstmt.setInt(2, Integer.parseInt(txid.getText()));
				pstmt.setString(3, txceo.getText());
				pstmt.setString(4, txtype.getText());
				pstmt.setString(5, txheadoffice.getText());
				pstmt.setDouble(6, Double.parseDouble(txcontact.getText()));
				pstmt.setInt(7, Integer.parseInt(txcompnum.getText()));
				pstmt.setString(8, txscope.getText());
				pstmt.executeUpdate();
				String tablenm=cname+"_Tb";
				Statement stmt1=con.createStatement();
				stmt1.executeUpdate("create database if not exists CompanyDb");
				stmt1.execute("use CompanyDb");
				stmt1.executeUpdate("create table if not exists " + tablenm+"(Posts varchar(20),salary double, number_of_posts int,date date,type varchar(20))");
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
		new CompanyNamePage();
	}
}
