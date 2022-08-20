import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UpDelInsertCompanies2 extends JPanel implements ItemListener,ActionListener
{
	JLabel lbcomp;
	JComboBox cbcomp;
	JTable table;
	JScrollPane jsp;
	JPanel p1,p2,pc,ptable;
	JButton btupdate,btdelete,btinsert;
	
	public UpDelInsertCompanies2()
	{
		this.setVisible(true);
		this.setSize(new Dimension(2500,1000));
		
		lbcomp=new JLabel("COMPANIES");
		cbcomp=new JComboBox();
		cbcomp.addItem("Select Company");
		jsp=new JScrollPane();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database if not exists CompanyDb");
			stmt.execute("use CompanyDb");
			stmt.executeUpdate("create table if not exists CompanyTb(Company_Name varchar(25),Company_ID int primary key, Company_CEO varchar(50), Company_Type varchar(100), Company_HeadOffice varchar(50), Company_Contact varchar(50), No_of_branches int, Company_Scope varchar(200))");
			
			ResultSet rs=stmt.executeQuery("Select distinct Company_Name from CompanyTb");
			while(rs.next())
			{
				cbcomp.addItem(rs.getString(1));
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
		p1=new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(lbcomp);
		p1.add(cbcomp);
		
		btupdate=new JButton("Update");
		btdelete=new JButton("Delete");
		btinsert=new JButton("Insert");
		
		p2=new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(btupdate);
		p2.add(btinsert);
		p2.add(btdelete);
		
		pc=new JPanel();
		pc.setLayout(new BorderLayout());
		pc.add(p2,BorderLayout.NORTH);
		
		this.setLayout(new BorderLayout());
		add(p1,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		
		cbcomp.addItemListener(this);
		btupdate.addActionListener(this);
		btinsert.addActionListener(this);
		btdelete.addActionListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		Font font=new Font("Arial", Font.PLAIN, 15);
		if(cbcomp.getSelectedIndex()==0 || ie.getStateChange()==ItemEvent.DESELECTED)
			return;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database if not exists CompanyDb");
			stmt.execute("use CompanyDb");
			stmt.executeUpdate("create table if not exists CompanyTb(Company_Name varchar(25),Company_ID int primary key, Company_CEO varchar(25), Company_Type varchar(25), Company_HeadOffice varchar(25), Company_Contact varchar(50), No_of_branches int, Company_Scope varchar(25))");
			
			String comp=cbcomp.getSelectedItem().toString()+"_Tb";
			
			PreparedStatement pstmt=con.prepareStatement("select count(*) from "+comp);
			
			ResultSet rs=pstmt.executeQuery();
			int c=0;
			while(rs.next())
			{
				c=rs.getInt(1);
			}
			
			Object[]cols= {"Posts","Salary","No. of posts available","Date","Type"};
			Object[][]rows=new Object[c][5];
			PreparedStatement pstmt1=con.prepareStatement("select * from "+comp);
			ResultSet rs1=pstmt1.executeQuery();
			int i=0;
			while(rs1.next())
			{
				rows[i][0]=rs1.getString(1);
				rows[i][1]=rs1.getString(2);
				rows[i][2]=rs1.getInt(3);
				rows[i][3]=rs1.getDate(4);
				rows[i][4]=rs1.getString(5);
				i++;
			}
			
			table=new JTable(rows,cols);
			table.setFont(font);
			table.setRowHeight(30);
			jsp=new JScrollPane(table);
			jsp.setPreferredSize(new Dimension(1000,800));
			ptable=new JPanel();
			ptable.add(jsp);
			pc.add(ptable,BorderLayout.CENTER);
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
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(cbcomp.getSelectedIndex()==0)
			return;
		if(src == btupdate)
		{
			
		}
		
		if(src==btdelete)
		{
			
		}
	}
}
