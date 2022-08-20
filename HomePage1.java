import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HomePage1 extends JDialog implements ActionListener
{
	JLabel lbobjective,lbdescription,lbabout;
	JTextArea ta1,ta2;
	JScrollPane jsp1,jsp2;
	JButton btclose,btlogin;
	JPanel pn,pc,ps;
	
	public HomePage1()
	{
		this.setSize(1900,1000);
		this.setLocationRelativeTo(null);
		
		Font f1=new Font("Elephant",Font.BOLD,40);
		Font f2=new Font("Arial",Font.BOLD,18);
		
		lbobjective=new JLabel("OBJECTIVE : ");
		lbobjective.setFont(f1);
		
		ta1=new JTextArea("This project is aimed at developing a web-based and central recruitment process system."+
		"\nThis project deals with providing job seekers an idea to compare various IT companies. \nSimultaneously companies also get employees."
				+"");
		ta1.setFont(f2);
		
		lbdescription=new  JLabel("DESCRIPTION : ");
		lbdescription.setFont(f1);
		
		ta2=new JTextArea("Some features of this system are you can search for jobs in a company, you can know about the tests and interviews patterns of an IT company, "
				+ "a company's basic details,company's locations and starting packages."
				+"\nJob Seeker has to provide his complete details and the skills he possess with an attached resume."
				+"\nModules in this project \n1.Administrator \n2.Job Seeker"
				+"\nAdministrator has full authority over the project.he can view all registered used and has power to delete those enteries."
				+"\nJob seeker can register himself.After registration,he will be directed to home page.\nHe can search for jobs."+
				"\nHe can see examination and interview details");
		ta2.setFont(f2);
		
		lbabout=new JLabel("ABOUT US");
		lbabout.setFont(f1);
		btclose=new JButton("CLOSE");
		btclose.setFont(f2);
		btlogin=new JButton("LOGIN");
		btlogin.setFont(f2);
		
		pn=new JPanel();
		pn.setBackground(Color.BLUE);
		pn.add(lbabout);
		
		ps=new JPanel();
		ps.add(btlogin);
		ps.add(btclose);
		
		pc=new JPanel();
		pc.setLayout(new GridLayout(4,1));
		pc.setBackground(Color.YELLOW);
		pc.add(lbobjective);
		pc.add(ta1);
		pc.add(lbdescription);
		pc.add(ta2);
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(ps,BorderLayout.SOUTH);
		
		btlogin.addActionListener(this);
		btclose.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		Object src=ae.getSource();
		if(src==btlogin)
		{
			new LoginPage();
		}
		if(src==btclose)
		{
			this.dispose();
		}
	}
}
