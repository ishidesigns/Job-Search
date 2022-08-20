import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomeScreen extends JApplet implements ActionListener
{
	JButton btabout,btlogin,btalogin,btclose,btcontact;
	JLabel lbhead,lb1;
	JPanel pn,pc,ps;
	
	
	public void init()
	{
		this.setSize(2500,900);
		Font f1=new Font("CASTELLAR",Font.BOLD,80);
		Font f2=new Font("Comic Sans",Font.BOLD,24);
		
		lbhead=new JLabel("JOB HUNT",JLabel.CENTER);
		lbhead.setForeground(Color.WHITE);
		lbhead.setFont(f1);
		
		lb1=new JLabel("",JLabel.CENTER);
		ImageIcon icon1=new ImageIcon("job2.jpg");
		lb1.setIcon(icon1);
		
		btabout=new JButton("ABOUT US");
		btabout.setFont(f2);
		btlogin=new JButton("USER LOGIN");
		btlogin.setFont(f2);
		btalogin=new JButton("ADMIN LOGIN");
		btalogin.setFont(f2);
		btclose=new JButton("CLOSE");
		btclose.setFont(f2);
		btcontact=new JButton("CONTACT US");
		btcontact.setFont(f2);
		
		pn=new JPanel();
		pn.setBackground(Color.BLUE);
		pn.add(lbhead);
		
		pc=new JPanel();
		pc.setBackground(Color.GREEN);
		pc.add(lb1);
		
		ps=new JPanel();
		ps.setBackground(Color.BLUE);
		ps.add(btabout);
		ps.add(btcontact);
		ps.add(btlogin);
		ps.add(btalogin);
		ps.add(btclose);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		btabout.addActionListener(this);
		btcontact.addActionListener(this);
		btlogin.addActionListener(this);
		btalogin.addActionListener(this);
		btclose.addActionListener(this);
		
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		if(src==btabout)
		{
			new HomePage1();
		}
		if(src==btcontact)
		{
			new ContactUsPage();
		}
		if(src==btlogin)
		{
			new LoginPage();
		}
		if(src==btalogin)
		{
			new AdminLogin();
		}
		if(src==btclose)
		{
			System.exit(1);
		}
	}
}
