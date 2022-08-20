
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

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignUpPage extends JDialog implements ActionListener
{
	JLabel lbpage,lbuser,lbpassword,lbmob,lbdob,lbgender,lbques,lbans,lbadd,lbstate,lbclg,lbpassyr,lbexp,lbbranch;
	JTextField txuser,txpassword,txmob,txans,txstate,txclg,txpassyr,txexp,txbranch;
	JTextArea txadd;
	JComboBox cbdd,cbmm,cbyy,cbques;
	JRadioButton rdmale,rdfemale;
	ButtonGroup bg;
	JButton btsign,btclose;
	JPanel p1,p2,p3,p4,pn,pc,ps,pc23,pdate,pgen;
	
	public SignUpPage()
	{
		Font f=new Font("Arial",Font.BOLD,24);
		lbpage=new JLabel("SIGN UP",JLabel.CENTER);
		lbpage.setFont(f);
		 
		setSize(700,800);
		this.setLocationRelativeTo(null);
		lbuser=new JLabel("USERNAME / E-MAIL ID");
		lbpassword=new JLabel("PASSWORD");
		lbmob=new JLabel("MOBILE NUMBER");
		lbdob=new JLabel("DATE OF BIRTH");
		lbgender=new JLabel("GENDER");
		lbques=new JLabel("QUESTION");
		lbans=new JLabel("ANSWER");
		lbadd=new JLabel("ADDRESS");
		lbclg=new JLabel("COLLEGE NAME");
		lbbranch=new JLabel("BRANCH");
		lbstate=new JLabel("STATE");
		lbpassyr=new JLabel("PASSING YEAR");
		lbexp=new JLabel("EXPERIENCE(digit in years)");
		
		txuser=new JTextField(40);
		txpassword=new JTextField(15);
		txmob=new JTextField(15);
		txans=new JTextField(30);
		txclg=new JTextField(50);
		txbranch=new JTextField(30);
		txstate=new JTextField(20);
		txpassyr=new JTextField(10);
		txexp=new JTextField(5);
		
		txadd=new JTextArea(3,25);
		
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
		for(int i=1950;i<=2020;i++)
			cbyy.addItem(i);
		
		cbques=new JComboBox();
		cbques.addItem("Select Question");
		cbques.addItem("Favorite Sport?");
		cbques.addItem("Pet Name?");
		cbques.addItem("Hometown?");
		cbques.addItem("Favorite Place?");
		
		rdmale=new JRadioButton("MALE");
		rdfemale=new JRadioButton("FEMALE");
		
		bg=new ButtonGroup();
		bg.add(rdfemale);
		bg.add(rdmale);
		
		btsign=new JButton("SIGN UP");
		btclose=new JButton("CLOSE");
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		pc23=new JPanel();
		
		pdate=new JPanel();
		pdate.add(cbyy);
		pdate.add(cbmm);
		pdate.add(cbdd);
		
		pgen=new JPanel();
		pgen.add(rdmale);
		pgen.add(rdfemale);
		
		pn=new JPanel();
		pn.setBackground(Color.CYAN);
		pn.add(lbpage);
		
		p1.setLayout(new GridLayout(4,4,10,20));
		p1.add(new JLabel(""));
		p1.add(lbuser);
		p1.add(txuser);
		p1.add(new JLabel(""));
		p1.add(new JLabel(""));
		p1.add(lbpassword);
		p1.add(txpassword);
		p1.add(new JLabel(""));
		p1.add(new JLabel(""));
		p1.add(lbmob);
		p1.add(txmob);
		p1.add(new JLabel(""));
		p1.add(new JLabel(""));
		p1.add(lbadd);
		p1.add(txadd);
		p1.add(new JLabel(""));
		
		p2.setLayout(new GridLayout(1,4));
		p2.add(new JLabel(""));
		p2.add(lbdob);
		p2.add(pdate);
		p2.add(new JLabel(""));
	
		p3.setLayout(new GridLayout(1,4,10,20));
		p3.add(new JLabel(""));
		p3.add(lbgender);
		p3.add(pgen);
		p3.add(new JLabel(""));
		
		pc23.setLayout(new GridLayout(2,1));
		pc23.add(p2);
		pc23.add(p3);

		p4.setLayout(new GridLayout(7,4,10,20));
		p4.add(new JLabel(""));
		p4.add(lbclg);
		p4.add(txclg);
		p4.add(new JLabel(""));
		p4.add(new JLabel(""));
		p4.add(lbstate);
		p4.add(txstate);
		p4.add(new JLabel(""));
		p4.add(new JLabel(""));
		p4.add(lbbranch);
		p4.add(txbranch);
		p4.add(new JLabel(""));
		p4.add(new JLabel(""));
		p4.add(lbpassyr);
		p4.add(txpassyr);
		p4.add(new JLabel(""));
		p4.add(new JLabel(""));
		p4.add(lbexp);
		p4.add(txexp);
		p4.add(new JLabel(""));
		p4.add(new JLabel(""));
		p4.add(lbques);
		p4.add(cbques);
		p4.add(new JLabel(""));
		p4.add(new JLabel(""));
		p4.add(lbans);
		p4.add(txans);
		p4.add(new JLabel(""));
		
		ps=new JPanel();
		ps.add(btsign);
		ps.add(btclose);
		
		pc=new JPanel();
		pc.setLayout(new GridLayout(3,1,10,30));
		pc.add(p1);
		pc.add(pc23);
		pc.add(p4);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		btsign.addActionListener(this);
		btclose.addActionListener(this);
		
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
		if(src==btsign)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("create database if not exists SignUpDb");
				stmt.execute("use SignUpDb");
				stmt.executeUpdate("create table if not exists SignUpTb(username varchar(150) primary key,password varchar(100),mobile_number varchar(15),address varchar(25),dob date,gender varchar(10),college_name varchar(100),branch varchar(30),state varchar(25),passing_year int, experience int,question varchar(100),answer varchar(100))");		
				PreparedStatement pstmt=con.prepareStatement("insert into SignUpTb(username,password,mobile_number,address,dob,gender,college_name,branch,state,passing_year,experience,question,answer) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, txuser.getText());
				pstmt.setString(2, txpassword.getText());
				pstmt.setString(3, txmob.getText());
				pstmt.setString(4, txadd.getText());
				int yy=Integer.parseInt(cbyy.getSelectedItem().toString());
				int mm=Integer.parseInt(cbmm.getSelectedItem().toString());
				int dd=Integer.parseInt(cbdd.getSelectedItem().toString());
				java.sql.Date dob=new java.sql.Date(yy-1900,mm-1,dd);
				pstmt.setDate(5, dob);
				
				if(rdmale.isSelected())
					pstmt.setString(6,"MALE");
				else
					pstmt.setString(6,"FEMALE");
				
				pstmt.setString(7, txclg.getText());
				pstmt.setString(8, txbranch.getText());
				pstmt.setString(9, txstate.getText());
				pstmt.setInt(10, Integer.parseInt(txpassyr.getText().toString()));
				pstmt.setInt(11, Integer.parseInt(txexp.getText().toString()));
				pstmt.setString(12, cbques.getSelectedItem().toString());
				pstmt.setString(13, txans.getText());
				pstmt.executeUpdate();
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
