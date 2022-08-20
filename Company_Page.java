import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Company_Page extends JApplet {
	
	JLabel lbcname,lbOwner,lbcomtype,lbhours,lbpost,lbsal,lbdes,lbcity;
	JPanel Pn,Pc;
	
	public void init()
	{
		Font F=new Font("Arial",Font.ITALIC,35);
		this.setFont(F);
		
		Font F1=new Font("BROADWAY",Font.BOLD,50);
		//set("CompanyName",JLabel.CENTER);
		lbcname=new JLabel("Company Name");
		lbOwner=new JLabel("Owner Name:");
		lbcomtype=new JLabel("Company type:");
		lbpost=new JLabel("Post Avialable:");
		lbhours=new JLabel("Timing Hours:");
		lbsal=new JLabel("Salary:");
		lbdes=new JLabel("Job Descrption:");
		lbcity=new JLabel("Job Locations:");
		
		lbcname.setFont(F1);
		lbOwner.setFont(F);
		lbcomtype.setFont(F);
		lbhours.setFont(F);
		lbpost.setFont(F);
		lbsal.setFont(F);
		lbdes.setFont(F);
		lbcity.setFont(F);
		
		
		Pn=new JPanel();
		Pn.add(lbcname);
		
		Pc=new JPanel();
		Pc.setLayout(new GridLayout(7,1,10,20));
		Pc.add(lbOwner);
		Pc.add(lbcomtype);
		Pc.add(lbpost);
		Pc.add(lbhours);
		Pc.add(lbsal);
		Pc.add(lbdes);
		Pc.add(lbcity);
		
		Pn.setBackground(Color.PINK);
		Pc.setBackground(Color.YELLOW);
		
		
		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		
	}
	

}