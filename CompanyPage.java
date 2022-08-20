import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanyPage extends JPanel
{
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15;
	JLabel lbcompany;
	JPanel pc,pn;
	
	public CompanyPage()
	{
		setVisible(true);
		this.setSize(2500,1000);
		
		Font f=new Font("Elephant",Font.BOLD,30);
		lbcompany=new JLabel("COMPANIES");
		lbcompany.setFont(f);
		lbcompany.setForeground(Color.WHITE);
		
		bt1=new JButton(" + ");
		URL rURL1=getClass().getResource("accenture1.png");
		if(rURL1!= null)
			bt1.setIcon(new ImageIcon(rURL1));
		bt1.setBackground(Color.WHITE);
		bt1.setFont(f);
		
		bt2=new JButton(" + ");
		URL rURL2=getClass().getResource("amazon.jpg");
		if(rURL2!= null)
			bt2.setIcon(new ImageIcon(rURL2));
		bt2.setBackground(Color.WHITE);
		bt2.setFont(f);
		
		bt3=new JButton(" + ");
		URL rURL3=getClass().getResource("apple.jpg");
		if(rURL3!= null)
			bt3.setIcon(new ImageIcon(rURL3));
		bt3.setBackground(Color.WHITE);
		bt3.setFont(f);
		
		bt4=new JButton(" + ");
		URL rURL4=getClass().getResource("capgemini.jpg");
		if(rURL4!= null)
			bt4.setIcon(new ImageIcon(rURL4));
		bt4.setBackground(Color.WHITE);
		bt4.setFont(f);
		
		bt5=new JButton(" + ");
		URL rURL5=getClass().getResource("cognizant.png");
		if(rURL5!= null)
			bt5.setIcon(new ImageIcon(rURL5));
		bt5.setBackground(Color.WHITE);
		bt5.setFont(f);
		
		bt6=new JButton(" + ");
		URL rURL6=getClass().getResource("dell.jpg");
		if(rURL6!= null)
			bt6.setIcon(new ImageIcon(rURL6));
		bt6.setBackground(Color.WHITE);
		bt6.setFont(f);
		
		bt7=new JButton(" + ");
		URL rURL7=getClass().getResource("flipkart.png");
		if(rURL7!= null)
			bt7.setIcon(new ImageIcon(rURL7));
		bt7.setBackground(Color.WHITE);
		bt7.setFont(f);
		
		bt8=new JButton(" + ");
		URL rURL8=getClass().getResource("google.jpg");
		if(rURL8!= null)
			bt8.setIcon(new ImageIcon(rURL8));
		bt8.setBackground(Color.WHITE);
		bt8.setFont(f);
		
		bt9=new JButton(" + ");
		URL rURL9=getClass().getResource("hp.png");
		if(rURL9!= null)
			bt9.setIcon(new ImageIcon(rURL9));
		bt9.setBackground(Color.WHITE);
		bt9.setFont(f);
		
		bt10=new JButton(" + ");
		URL rURL10=getClass().getResource("IBM.png");
		if(rURL10!= null)
			bt10.setIcon(new ImageIcon(rURL10));
		bt10.setBackground(Color.WHITE);
		bt10.setFont(f);
		
		bt11=new JButton(" + ");
		URL rURL11=getClass().getResource("infosys.jpg");
		if(rURL11!= null)
			bt11.setIcon(new ImageIcon(rURL11));
		bt11.setBackground(Color.WHITE);
		bt11.setFont(f);
		
		bt12=new JButton(" + ");
		URL rURL12=getClass().getResource("microsoft.jpg");
		if(rURL12!= null)
			bt12.setIcon(new ImageIcon(rURL12));
		bt12.setBackground(Color.WHITE);
		bt12.setFont(f);
		
		bt13=new JButton(" + ");
		URL rURL13=getClass().getResource("tcs.png");
		if(rURL13!= null)
			bt13.setIcon(new ImageIcon(rURL13));
		bt13.setBackground(Color.WHITE);
		bt13.setFont(f);
		
		bt14=new JButton(" + ");
		URL rURL14=getClass().getResource("wipro.png");
		if(rURL14!= null)
			bt14.setIcon(new ImageIcon(rURL14));
		bt14.setBackground(Color.WHITE);
		bt14.setFont(f);
		
		bt15=new JButton(" + ");
		URL rURL15=getClass().getResource("yahoo.png");
		if(rURL15!= null)
			bt15.setIcon(new ImageIcon(rURL15));
		bt15.setBackground(Color.WHITE);
		bt15.setFont(f);
		
		pn=new JPanel();
		pn.setBackground(Color.BLUE);
		pn.add(lbcompany);
		
		pc=new JPanel();
		pc.setBackground(Color.GREEN);
		pc.setLayout(new GridLayout(4,4,50,50));
		pc.add(bt1);
		pc.add(bt2);
		pc.add(bt3);
		pc.add(bt4);
		pc.add(bt5);
		pc.add(bt6);
		pc.add(bt7);
		pc.add(bt8);
		pc.add(bt9);
		pc.add(bt10);
		pc.add(bt11);
		pc.add(bt12);
		pc.add(bt13);
		pc.add(bt14);
		pc.add(bt15);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
	}
}
