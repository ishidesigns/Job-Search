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

public class TechInterviewRound_pg extends JPanel
{
	JLabel lb1;
	JTextArea txdescp;
	JPanel Pn,Pc;
	
	public TechInterviewRound_pg()
	{	
		this.setSize(1000,1000);
		this.setVisible(true);
		
		Font f=new Font("CASTELLAR",Font.BOLD,50);
		Font f1=new Font("Arial",Font.BOLD,25);
		
		lb1=new JLabel("Technical Interview Round");
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		txdescp=new JTextArea(" Round-3:\n"
				+ "\n\tTechnical Interview(Duration: 1hr)\n"
				+ "\n In this round, every interviewer had 2 candidates.\n"
				+ "\nThe students who clear the written round are called for Technical Interview.\n"
				+ "\nThere is no hard & fast rule for which questions will be asked in this round\n"
				+ "you can expect questions on any topic depending on the panel.\n"
				+ "\nTo clear this round you should be clear with your basics.\n"
				+ "\nYou should be prepared with Data structures and Algorithms, DBMS,Operating System\n"
				+ ",Networking, OOPs concepts and a programming language of your choice.\n"
				+ "\nStudents from branches other than CS should prepare for other two subjects related to their branch.\n"
				+ "\nCS students will be expected to write codes in the interview.\n"
				+ "\nThey also ask questions from resume."
				+ "You may be asked puzzles in this round.");
				
		
		txdescp.setFont(f1);
		
		Pn=new JPanel();
		Pn.add(lb1);

		Pc=new JPanel();
		Pc.add(txdescp);
		
		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//new HRInterviewRound_pg();
		
	}
}
