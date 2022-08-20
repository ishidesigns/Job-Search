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

public class HRInterviewRound_pg extends JPanel
{
	JLabel lb1;
	JTextArea txdescp;
	JPanel Pn,Pc;
	
	public HRInterviewRound_pg()
	{	
		this.setSize(1000,1000);
		this.setVisible(true);

		Font f=new Font("CASTELLAR",Font.BOLD,50);
		Font f1=new Font("Arial",Font.BOLD,25);
		
		lb1=new JLabel("HR Interview Round");
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		txdescp=new JTextArea(" Round-4:\n"
				+ "\n\tHR Interview(Duration: 30mins)\n"
				+ "\nThis round also began with a brief discussion on my major project.\n"
				+ "\nYou can expect HR questions like :\n"
				+ "\n1.Tell me about yourself.\n"
				+ "\n2.What made you Apply?\n"
				+ "\n3.How you see yourself after five years from now ?\n"
				+ "\n4.What are your strengths and weaknesses ?\n"
				+ "\n5.What have you learned over the last 3 years in college (Nothing technical please).\n"
				+ "\n6.Questions form resume" 
				
				);
		
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
/*
14 students were shortlisted.
As a suggestion, be confident while explaining your approach to the interviewer. 
Work on your communication skills. Be honest. 
Take time, dry run your code before giving final code. Even if you are stuck,
		discuss your approach with the interviewer.
*/