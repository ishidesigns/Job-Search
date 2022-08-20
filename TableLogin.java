import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableLogin extends JPanel
{
	JLabel lblogins;
	JTable table;
	JScrollPane jsp;
	JPanel pn,pc;
	
	public TableLogin()
	{
		this.setVisible(true);
		this.setSize(new Dimension(2500,1000));
	
		Font f=new Font("Arial",Font.BOLD,24);
		lblogins=new JLabel("All Logins");
		lblogins.setFont(f);
		pn=new JPanel();
		pn.setBackground(Color.CYAN);
		pn.add(lblogins);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database if not exists SignUpDb");
			stmt.execute("use SignUpDb");
			stmt.executeUpdate("create table if not exists SignUpTb(username varchar(150) primary key,password varchar(100),mobile_number varchar(15),address varchar(25),dob date,gender varchar(10),college_name varchar(100),branch varchar(30),state varchar(25),passing_year int, experience int,question varchar(100),answer varchar(100))");
			
			ResultSet rs=stmt.executeQuery("Select count(*) from SignUpTb");
			int c=0;
			while(rs.next())
			{
				c=rs.getInt(1);
			}
			Object []cols= {"Name","Password","Mobile Number","Address","DOB","Gender","College","Branch","State","Passing Year","Experience","Question","Answer"};
			Object [][]rows=new Object[c][13];
			PreparedStatement pstmt=con.prepareStatement("Select * from SignUpTb");
			
			ResultSet rs1=pstmt.executeQuery();
			int i=0;
			while(rs1.next())
			{
				rows[i][0]=rs1.getString(1);
				rows[i][1]=rs1.getString(2);
				rows[i][2]=rs1.getString(3);
				rows[i][3]=rs1.getString(4);
				rows[i][4]=rs1.getDate(5);
				rows[i][5]=rs1.getString(6);
				rows[i][6]=rs1.getString(7);
				rows[i][7]=rs1.getString(8);
				rows[i][8]=rs1.getString(9);
				rows[i][9]=rs1.getInt(10);
				rows[i][10]=rs1.getInt(11);
				rows[i][11]=rs1.getString(12);
				rows[i][12]=rs1.getString(13);
			}
			
			table=new JTable(rows,cols);
			jsp=new JScrollPane(table);
			jsp.setPreferredSize(new Dimension(1000,400));
			pc=new JPanel();
			pc.add(jsp);
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
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
	}
}
