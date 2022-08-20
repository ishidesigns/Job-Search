import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManageCandidate extends JDialog implements ActionListener
{
	JTabbedPane jtp;
	JButton btback;
	JPanel ps;
	
	public ManageCandidate()
	{
		this.setVisible(true);
		this.setSize(new Dimension(1800,1000));
		this.setLocationRelativeTo(null);
		
		Font f1=new Font("Arial",Font.BOLD,30);
		
		jtp=new JTabbedPane();
		jtp.setBackground(Color.GREEN);
		setLayout(new BorderLayout());
		jtp.addTab("Student Logins", new TableLogin());
		jtp.addTab("Update or Delete", new UpDelCandidate());
		add(jtp,BorderLayout.CENTER);
		
		btback=new JButton("Back");
		btback.setFont(f1);
		btback.setPreferredSize(new Dimension(300,50));
		
		ps=new JPanel();
		ps.add(btback);
		
		add(ps,BorderLayout.SOUTH);
		
		btback.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
