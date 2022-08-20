import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class onlineRound_pg extends JPanel
{
	JLabel lb1;
	JTextArea txdescp;
	JPanel Pn,Pc;
	
	public onlineRound_pg()
	{	
		this.setSize(1000,1000);
		this.setVisible(true);
		
		Font f=new Font("CASTELLAR",Font.BOLD,50);
		Font f1=new Font("Arial",Font.BOLD,25);
		
		lb1=new JLabel("Online Round");
		
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		
		txdescp=new JTextArea("Round-1:\n "
				+ "\n\tOnline Test (Duration: 1hr 15min)\n "
				+ "\nIt had various sections:\n"
				+ "\n1.Verbal Ability (had 4 subsection including passage reading,grammar checking, fill ups etc)\n"
				+ "\n 2.General Aptitude (logical, Maths, etc\n" + 
				"\n3.Technical Assessment (DBMS, OS, etc)\n "
				+ "\n4.Coding Assessment (questions on finding output for AVL, Trees, Graphs, etc\n"
				+ "\n5.Flow Chart problems The difficulty level of certain sections was hard.\n"
				+ "\n\tOverall difficulty was moderate. It is important to manage time.\n"
				+ "\nAfter this round, various students were shortlisted for the coding round/written test Round. ");
	
		txdescp.setFont(f1);
		
		Pn=new JPanel();
		Pn.add(lb1);

		Pc=new JPanel();
		Pc.add(txdescp);
		
		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		
	}
}