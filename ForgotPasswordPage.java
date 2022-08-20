
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgotPasswordPage extends JDialog implements ActionListener
{
	JLabel lbpage,lbuser,lbques,lbans,lbmsg;
	JTextField txuser,txans;
	JComboBox cbques;
	JButton btsubmit,btclose;
	JPanel pn,pc,ps,p1,p2,p3,p4,pbutton;
	
	public ForgotPasswordPage()
	{
		 setSize(600,600);
		 this.setLocationRelativeTo(null);
		 Font f=new Font("Arial",Font.BOLD,34);
		 lbpage=new JLabel("FORGOT PASSWORD",JLabel.CENTER);
		 lbpage.setFont(f);
		 lbuser=new JLabel("USERNAME");
		 lbques=new JLabel("QUESTION");
		 lbans=new JLabel("ANSWER");
		 lbmsg=new JLabel("\n",JLabel.CENTER);
		 lbmsg.setForeground(Color.RED);
		 txuser=new JTextField(25);
		 txans=new JTextField(20);
		 cbques=new JComboBox();
		 cbques.addItem("Select Question");
		 cbques.addItem("Favorite Sport?");
		 cbques.addItem("Pet Name?");
		 cbques.addItem("Hometown?");
		 cbques.addItem("Favorite Place?");
		 btsubmit=new JButton("SUBMIT");
		 btclose=new JButton("CLOSE");
		 
		 pbutton=new JPanel();
		 pbutton.add(btsubmit);
		 pbutton.add(btclose);
		  
		 p2=new JPanel();
		 p2.setLayout(new GridLayout(1,4));
		 p2.add(new JLabel(""));
		 p2.add(lbuser);
		 p2.add(txuser);
		 p2.add(new JLabel(""));
		 
		 p3=new JPanel();
		 p3.setLayout(new GridLayout(1,4));
		 p3.add(new JLabel(""));
		 p3.add(lbques);
		 p3.add(cbques);
		 p3.add(new JLabel(""));
		 
		 p4=new JPanel();
		 p4=new JPanel();
		 p4.setLayout(new GridLayout(1,4));
		 p4.add(new JLabel(""));
		 p4.add(lbans);
		 p4.add(txans);
		 p4.add(new JLabel(""));
		 
		 pn=new JPanel();
		 pn.setBackground(Color.CYAN);
		 pn.add(lbpage);
		 
		 ps=new JPanel();
		 ps.setLayout(new GridLayout(2,1));
		 ps.add(pbutton);
		 ps.add(lbmsg);
		 
		 this.setLayout(new BorderLayout());
		 
		 pc=new JPanel();
		 pc.setLayout(new GridLayout(6,2,0,50));
		 pc.add(pn,BorderLayout.NORTH);
		 pc.add(p2);
		 pc.add(p3);
		 pc.add(p4);
		 pc.add(ps,BorderLayout.SOUTH);
		 
		 add(pc,BorderLayout.CENTER);
		 
		 this.setVisible(true);
		 
		 btclose.addActionListener(this);
		 btsubmit.addActionListener(this);
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
		if(src==btsubmit)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("create database if not exists SignUpDb");
				stmt.execute("use SignUpDb");
				stmt.executeUpdate("create table if not exists SignUpTb(username varchar(150) primary key,password varchar(100),mobile_number int,address varchar(25),dob date,gender varchar(10),college_name varchar(100),state varchar(25),passing_year int, experience int,question varchar(100),answer varchar(100))");		
				PreparedStatement pstmt=con.prepareStatement("select count(*) from SignUpTb where username=? and question=? and answer=?");
				pstmt.setString(1,txuser.getText());
				pstmt.setString(2,cbques.getSelectedItem().toString());
				pstmt.setString(3, txans.getText());
				//pstmt.setString(3,txans.getText());
				ResultSet rs=pstmt.executeQuery();
				int c=0;
				while(rs.next())
					c=rs.getInt(1);
				if(c==1)
				{
					new NewPasswordPage();
				}
				if(c==0)
					lbmsg.setText("incorrect user details");
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
