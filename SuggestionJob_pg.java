import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SuggestionJob_pg extends JPanel implements ActionListener
{
	JLabel lb1,lbicon;
	JTextArea txdescp,txques;
	JPanel Pn,Pc,Ps;
	JButton btnext;
	
	public SuggestionJob_pg()
	{	
		this.setSize(1000,1000);
		this.setVisible(true);
		
		Font f=new Font("CASTELLAR",Font.BOLD,50);
		Font f1=new Font("Arial",Font.BOLD,25);
		
		lb1=new JLabel("SUGGESTION");
		lb1.setForeground(Color.RED);
		lb1.setFont(f);
		
		
		txdescp=new JTextArea(" As a suggestion,\n"
				+ "\nBe confident while explaining your approach to the interviewer.\n"
				+ "\nWork on your communication skills.\n"
				+ "\nBe honest.\n"
				+ "\nTake time, dry run your code before giving final code.\n"
				+ "\nEven if you are stuck," + 
				"discuss your approach with the interviewer.\n"
				+ "\n\n\n\n"
				
				+"\nThere are sample question available for online round.\n"
				+ "\nThis page contains questions asked in different programming language."
				+ "To view these questions click on the given button.");
		
		
		txdescp.setFont(f1);
		
		btnext=new JButton("GO TO SAMPLE PAPER PAGE");
		btnext.setFont(f1);
		btnext.setForeground(Color.RED);
		btnext.setPreferredSize(new Dimension(500,50));
		
		Pn=new JPanel();
		Pn.add(lb1);

		Pc=new JPanel();
		Pc.add(txdescp);
		
		Ps=new JPanel();
		Ps.add(btnext);

		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		add(Ps,BorderLayout.SOUTH);
		
		btnext.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new Language();
		
	}
}