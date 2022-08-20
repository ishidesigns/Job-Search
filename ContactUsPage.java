import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ContactUsPage extends JDialog implements ActionListener
{
	JLabel lbhead,lb1,lb2,lbname1,lbname2,lbdeg1,lbdeg2,lbcon1,lbcon2,lbdob1,lbdob2,lbem1,lbem2;
	JSplitPane jsp;
	JPanel p1,p2,p3,p4,pi,pp,pn,pc,ps;
	JButton btback;
	
	public ContactUsPage()
	{
		this.setVisible(true);
		this.setSize(1900, 1000);
		this.setLocationRelativeTo(null);
		
		Font F=new Font("Arial",Font.BOLD,20);
		Font F1=new Font("Arial",Font.ITALIC,45);
		this.setFont(F);
		
		lb1=new JLabel("",JLabel.CENTER);
		lbname1=new JLabel("NAME: ISHIKA JAIN",JLabel.CENTER);
		lbname1.setFont(F);
		lbdob1=new JLabel("DOB: 12-01-2000",JLabel.CENTER);
		lbdob1.setFont(F);
		lbdeg1=new JLabel("DEGREE: B.Tech. in CSE,UCET,Bikaner 2nd Year",JLabel.CENTER);
		lbdeg1.setFont(F);
		lbcon1=new JLabel("CONTACT NUMBER: +918005585796",JLabel.CENTER);
		lbcon1.setFont(F);
		lbem1=new JLabel("E-MAIL: jishika089@gmail.com",JLabel.CENTER);
		lbem1.setFont(F);
		//ImageIcon icon1=new ImageIcon("ishika.jpeg");
		//lb1.setIcon(icon1);
		URL rURL1=getClass().getResource("ishika.jpeg");
		if(rURL1!= null)
			lb1.setIcon(new ImageIcon(rURL1));
		p1=new JPanel();
		p1.add(lb1);
		p2=new JPanel();
		p2.setLayout(new GridLayout(5,1));
		p2.add(lbname1);
		p2.add(lbdob1);
		p2.add(lbdeg1);
		p2.add(lbcon1);
		p2.add(lbem1);
		pi=new JPanel();
		pi.setLayout(new GridLayout(2,1,10,20));
		pi.add(p1);
		pi.add(p2);
		
		lb2=new JLabel("",JLabel.CENTER);
		lbname2=new JLabel("NAME: PRIYA ISSAR",JLabel.CENTER);
		lbname2.setFont(F);
		lbdob2=new JLabel("DOB: 18-06-2000",JLabel.CENTER);
		lbdob2.setFont(F);
		lbdeg2=new JLabel("DEGREE: B.Tech. in CSE,UCET,Bikaner 2nd Year",JLabel.CENTER);
		lbdeg2.setFont(F);
		lbcon2=new JLabel("CONTACT NUMBER: +917023270249",JLabel.CENTER);
		lbcon2.setFont(F);
		lbem2=new JLabel("E-MAIL: priyaix13@gmail.com",JLabel.CENTER);
		lbem2.setFont(F);
		URL rURL2=getClass().getResource("priya.jpeg");
		if(rURL2!= null)
			lb2.setIcon(new ImageIcon(rURL2));
		//ImageIcon icon2=new ImageIcon("priya.jpeg");
		//lb2.setIcon(icon2);
		p3=new JPanel();
		p3.add(lb2);
		p4=new JPanel();
		p4.setLayout(new GridLayout(5,1));
		p4.add(lbname2);
		p4.add(lbdob2);
		p4.add(lbdeg2);
		p4.add(lbcon2);
		p4.add(lbem2);
		pp=new JPanel();
		pp.setLayout(new GridLayout(2,1));
		pp.add(p3);
		pp.add(p4);
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pi,pp);
		jsp.setResizeWeight(0.5);
		
		btback=new JButton("BACK");
		btback.setFont(F);
		
		lbhead=new JLabel("CONTACT US");
		lbhead.setFont(F1);
		pn=new JPanel();
		pn.setBackground(Color.BLUE);
		pn.add(lbhead);
		
		pc=new JPanel();
		pc.setBackground(Color.YELLOW);
		pc.add(jsp);
		
		ps=new JPanel();
		ps.setBackground(Color.BLUE);
		ps.add(btback);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		btback.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		this.dispose();
	}
}
