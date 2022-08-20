import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminSectionPage extends JDialog implements ActionListener
{
	JLabel lb1,lbadmin;
	JButton bt1,bt2,bt3,bt4,bt5;
	JPanel Pn,Pc,Ps,P1,P2,P3,P4,P5,Pbt;
	
	public AdminSectionPage()
	{	
		this.setVisible(true);
		this.setSize(new Dimension(1800,1000));
		this.setLocationRelativeTo(null);
		
		Font f=new Font("CASTELLAR",Font.BOLD,90);
		Font f1=new Font("Arial",Font.BOLD,30);
		
		lb1=new JLabel("Welcome to Admin Panel");
		
		bt1=new JButton("Update Company");
		bt2=new JButton("Update Users");
		bt3=new JButton("Feedback queries");//if including this one optional
		bt4=new JButton("Logout");
		bt5=new JButton("Close");
		
		bt1.setPreferredSize(new Dimension(400,50));
		bt2.setPreferredSize(new Dimension(400,50));
		bt3.setPreferredSize(new Dimension(400,50));
		bt4.setPreferredSize(new Dimension(400,50));
		bt5.setPreferredSize(new Dimension(400,50));
		
		//image icon for admin
		lbadmin=new JLabel();
		URL rURL1=getClass().getResource("icon_Admin.png");
		if(rURL1!= null)
			lbadmin.setIcon(new ImageIcon(rURL1));
		
		Pn=new JPanel();
		Pn.add(lb1);
		
		P1=new JPanel();
		P1.add(bt1);
		
		P2=new JPanel();
		P2.add(bt2);
		
		P3=new JPanel();
		P3.add(bt3);
		
		P4=new JPanel();
		P4.add(bt4);
		
		P5=new JPanel();
		P5.add(bt5);
		
		Pbt = new JPanel();
		Pbt.setLayout(new GridLayout(5,1));
		Pbt.add(P1);
		Pbt.add(P2);
		Pbt.add(P3);
		Pbt.add(P4);
		Pbt.add(P5);
		
		Pc=new JPanel();
		Pc.add(lbadmin);
		
		Ps=new JPanel();
		Ps.setLayout(new BorderLayout());
		Ps.add(Pbt, BorderLayout.SOUTH);
		
		
		Pn.setBackground(Color.WHITE);
		Pc.setBackground(Color.WHITE);
		Ps.setBackground(Color.WHITE);
		P1.setBackground(Color.WHITE);
		P2.setBackground(Color.WHITE);
		P3.setBackground(Color.WHITE);
		P4.setBackground(Color.WHITE);
		P5.setBackground(Color.WHITE);
		
		
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		bt1.setFont(f1);
		bt2.setFont(f1);
		bt3.setFont(f1);
		bt4.setFont(f1);
		bt5.setFont(f1);
		
		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		add(Ps,BorderLayout.SOUTH);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		if(src==bt1)
		{
			new ManageComp();
		}
		else if(src==bt2)
		{
			new ManageCandidate();
		}
		else if(src==bt3)
		{
			
		}
		else if(src==bt4)
		{
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Log Out First");
		}	
	}
	
	public static void main(String[]arg)
	{
		new AdminSectionPage();
	}
}
