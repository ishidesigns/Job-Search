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

//import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AdminSignup extends JDialog implements ActionListener
{
	JLabel lbpage,lbuser,lbpass,lbadkey,lbgen,lbadd,lbdob,lbques,lbans;
	JTextField txuser,txpass,txadkey,txadd,txans;
	JComboBox cbdd,cbmm,cbyy,cbques;
	JRadioButton rbmale,rbfem;
	JPanel pn,pc,ps,p1,p2,p3;
	JButton btsignup,btclose;
	
	public AdminSignup()
	{
		Font f=new Font("Arial",Font.BOLD,34);
		lbpage=new JLabel("SignUp Page",JLabel.CENTER);
		lbpage.setFont(f);
		setSize(700,800);
		this.setLocationRelativeTo(null);
		lbuser=new JLabel("USERNAME");
		lbpass=new JLabel("PASSWORD");
		lbadkey=new JLabel("ADMIN KEY");
		lbgen=new JLabel("GENDER");
		lbadd=new JLabel("ADDRESS");
		lbdob=new JLabel("DATE OF BIRTH");
		lbques=new JLabel("QUESTION");
		lbans=new JLabel("ANSWER");
		
		txuser=new JTextField();
		txpass=new JTextField();
		txadd=new JTextField();
		txadkey=new JTextField();
		txans=new JTextField();
		
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
		
		rbmale=new JRadioButton("MALE");
		rbfem=new JRadioButton("FEMALE");
		
		btsignup=new JButton("SIGN UP");
		btclose=new JButton("CLOSE");
		
		pn=new JPanel();
		pn.setBackground(Color.CYAN);
		pn.add(lbpage);
		
		p1=new JPanel();
		p1.add(cbdd);
		p1.add(cbmm);
		p1.add(cbyy);
		
		p2=new JPanel();
		p2.add(rbmale);
		p2.add(rbfem);
		
		ps=new JPanel();
		ps.add(btsignup);
		ps.add(btclose);
		
		pc=new JPanel();
		pc.setLayout(new GridLayout(8,4,10,20));
		pc.add(new JLabel(""));
		pc.add(lbuser);
		pc.add(txuser);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbpass);
		pc.add(txpass);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbadkey);
		pc.add(txadkey);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbadd);
		pc.add(txadd);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbdob);
		pc.add(p1);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbgen);
		pc.add(p2);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbques);
		pc.add(cbques);
		pc.add(new JLabel(""));
		pc.add(new JLabel(""));
		pc.add(lbans);
		pc.add(txans);
		pc.add(new JLabel(""));
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		btsignup.addActionListener(this);
		btclose.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btsignup)
		{
			if(txuser.getText().equals("")|| txpass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"All fields are mandatory");
			}
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("create database if not exists SignUpDb");
				stmt.execute("use SignUpDb");
				stmt.executeUpdate("create table if not exists AdminSignUpTb(username varchar(20),password varchar(20),adminkey int default 121,gender varchar(15),dob date,address varchar(30),question varchar(20),answer varchar(15))");
				PreparedStatement pstmt=con.prepareStatement("insert into AdminSignUpTb(username,password,adminkey,gender,dob,address,question,answer) values(?,?,?,?,?,?,?,?)");
				pstmt.setString(1, txuser.getText());
				pstmt.setString(2, txpass.getText());
				pstmt.setString(3, txadkey.getText());
				if(rbmale.isSelected())
					pstmt.setString(4,"MALE");
				else
					pstmt.setString(4,"FEMALE");
				pstmt.setString(5, cbyy.getSelectedItem()+"-"+cbmm.getSelectedItem()+"-"+cbdd.getSelectedItem());
				pstmt.setString(6, txadd.getText());
				pstmt.setString(7, cbques.getSelectedItem().toString());
				pstmt.setString(8, txans.getText());
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
		if(src==btclose)
		{
			this.dispose();
		}
	}
	public static void main(String[]args)
	{
		new AdminSignup();
	}
}
