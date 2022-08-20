import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CodingRound_pg extends JPanel
{
	JLabel lb1;
	JTextArea txdescp;
	JPanel Pn,Pc;
	
	public CodingRound_pg()
	{
		this.setSize(1000,1000);
		this.setVisible(true);
		
		Font f=new Font("CASTELLAR",Font.BOLD,50);
		Font f1=new Font("Arial",Font.BOLD,25);
		
		lb1=new JLabel("Written Round");
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		txdescp=new JTextArea("Round-2: \n"
				+ "\n\tCoding Round(Duration: 2hr)\n"
				+ "\n Coding round was conducted on any online platform or in wriiten mode.\n"
				+ "It is dependent on companies choice.\n"
				+ "\nThis round had 2 coding questions of moderate difficulty\n" + 
				"\nThe round was non-eliminating.");
		
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