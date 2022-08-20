
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CompanyTable extends JPanel 
{
	JLabel lbcomp;
	JTable table;
	JScrollPane jsp;
	JPanel pn,pc;
	
	public CompanyTable()
	{
		Font f=new Font("Arial",Font.BOLD,24);
		lbcomp=new JLabel("All Companies");
		lbcomp.setFont(f);
		pn=new JPanel();
		pn.setBackground(Color.CYAN);
		pn.add(lbcomp);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database if not exists CompanyDb");
			stmt.execute("use CompanyDb");
			stmt.executeUpdate("create table if not exists CompanyTb(Company_Name varchar(25),Company_ID int primary key, Company_CEO varchar(25), Company_Type varchar(25), Company_HeadOffice varchar(25), Company_Contact varchar(50), No_of_branches int, Company_Scope varchar(25))");
			ResultSet rs=stmt.executeQuery("Select count(*) from CompanyTb");
			int c=0;
			while(rs.next())
			{
				c=rs.getInt(1);
			}
			Object[]cols= {"Company Name","Company ID","CEO","Type","Head Office","Contact Number","Number of Branches","Scope"};
			Object[][]rows=new Object[c][8];
			PreparedStatement pstmt1=con.prepareStatement("select * from CompanyTb");
			ResultSet rs1=pstmt1.executeQuery();
			int i=0;
			while(rs1.next())
			{
				rows[i][0]=rs1.getString(1);
				rows[i][1]=rs1.getInt(2)+"";
				rows[i][2]=rs1.getString(3);
				rows[i][3]=rs1.getString(4);
				rows[i][4]=rs1.getString(5);
				rows[i][5]=rs1.getString(6);
				rows[i][6]=rs1.getInt(7)+"";
				rows[i][7]=rs1.getString(8);
				i++;
			}
	
			table=new JTable(rows,cols);
			table.setRowHeight(30);
			jsp=new JScrollPane(table);
			jsp.setPreferredSize(new Dimension(1200,800));
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
