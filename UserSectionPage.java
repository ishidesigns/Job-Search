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

public class UserSectionPage extends JDialog implements ActionListener
{
	JLabel lb1,lbuser,lbicon;
	JButton bt1,bt2,bt3,bt4;
	JPanel Pn,Pc,Ps,P1,P2,P3,P4,Pbutton;
	
	public UserSectionPage()
	{	
		this.setVisible(true);
		this.setSize(new Dimension(1800,1000));
		this.setLocationRelativeTo(null);
		
		Font f=new Font("CASTELLAR",Font.BOLD,90);
		Font f1=new Font("Arial",Font.BOLD,30);
		
		lb1=new JLabel("Welcome to User Section");
		lbuser=new JLabel();
		URL rURL1=getClass().getResource("userpic.jpeg");
		if(rURL1!= null)
			lbuser.setIcon(new ImageIcon(rURL1));
		
		bt1=new JButton("Job Brochure");
		bt1.setFont(f1);
		bt1.setPreferredSize(new Dimension(400,50));
		
		bt2=new JButton("Selection Procedure");
		bt2.setFont(f1);
		bt2.setPreferredSize(new Dimension(400,50));
		
		bt3=new JButton("Logout");
		bt3.setFont(f1);
		bt3.setPreferredSize(new Dimension(400,50));
		
		bt4=new JButton("Close");
		bt4.setFont(f1);
		bt4.setPreferredSize(new Dimension(400,50));
				
		Pn=new JPanel();
		Pn.setBackground(Color.WHITE);
		Pn.add(lb1);
		
		P1=new JPanel();
		P1.setBackground(Color.WHITE);
		P1.add(bt1);
		
		P2=new JPanel();
		P2.setBackground(Color.WHITE);
		P2.add(bt2);
		
		P3=new JPanel();
		P3.setBackground(Color.WHITE);
		P3.add(bt3);
		
		P4=new JPanel();
		P4.setBackground(Color.WHITE);
		P4.add(bt4);
		
		Pbutton=new JPanel();
		Pbutton.setLayout(new GridLayout(4,1));
		Pbutton.add(P1);
		Pbutton.add(P2);
		Pbutton.add(P3);
		Pbutton.add(P4);
		
		Pc=new JPanel();
		Pc.setBackground(Color.WHITE);
		Pc.add(lbuser);
		
		Ps=new JPanel();
		Ps.setLayout(new BorderLayout());
		Ps.add(Pbutton,BorderLayout.SOUTH);
		
		Pn.setBackground(Color.WHITE);
		Ps.setBackground(Color.WHITE);
		Pbutton.setBackground(Color.WHITE);
		
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		add(Ps,BorderLayout.SOUTH);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		if(src==bt1)
		{
			new BrochurePage();
		}
		else if(src==bt2)
		{
			new SelectionProcedurePg1();
		}
		else if(src==bt3)
		{
			this.dispose();
		}
		else if(src==bt4)
		{
			lbicon=new JLabel();
			URL rURL1=getClass().getResource("error404,gif");
			if(rURL1!= null)
				lbicon.setIcon(new ImageIcon(rURL1));
			
			JOptionPane.showMessageDialog(null, "Log Out First", "Log Out", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void main(String[]args)
	{
		new UserSectionPage();
	}
}