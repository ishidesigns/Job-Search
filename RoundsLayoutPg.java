
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundsLayoutPg extends JDialog implements ActionListener
{
	JButton btprev,btnext,btsuggestion,btback;
	JLabel lbhead;
	JPanel pn,pc,ps1,ps2,ps;
	CardLayout CLO;
	
	public RoundsLayoutPg()
	{
		this.setVisible(true);
		this.setSize(new Dimension(1900,1000));
		
		Font f=new Font("CASTELLAR",Font.BOLD,90);
		Font f1=new Font("Arial",Font.BOLD,25);
		
		btprev=new JButton("PREVIOUS");
		btprev.setPreferredSize(new Dimension(400,50));
		btprev.setFont(f1);
		btprev.setForeground(Color.BLUE);
		
		btnext=new JButton("NEXT");
		btnext.setPreferredSize(new Dimension(400,50));
		btnext.setFont(f1);
		btnext.setForeground(Color.BLUE);
		
		btsuggestion=new JButton("SUGGESTIONS");
		btsuggestion.setPreferredSize(new Dimension(400,50));
		btsuggestion.setFont(f1);
		btsuggestion.setForeground(Color.BLUE);
		
		btback=new JButton("BACK");
		btback.setPreferredSize(new Dimension(400,50));
		btback.setFont(f1);
		btback.setForeground(Color.BLUE);
		
		lbhead=new JLabel("SELECTION ROUNDS");
		lbhead.setForeground(Color.RED);
		lbhead.setFont(f);
		
		CLO=new CardLayout();
		
		pn=new JPanel();
		pn.add(lbhead);
		
		ps1=new JPanel();
		ps1.add(btprev);
		ps1.add(btnext);
		ps1.add(btsuggestion);
		
		ps2=new JPanel();
		ps2.add(btback);
		
		ps=new JPanel();
		ps.setLayout(new GridLayout(2,1));
		ps.add(ps1);
		ps.add(ps2);
		
		pc=new JPanel();
		pc.setLayout(CLO);
		pc.add("Online Round", new onlineRound_pg());
		pc.add("Written Round", new CodingRound_pg());
		pc.add("Technical Round", new TechInterviewRound_pg());
		pc.add("Hiring Round", new HRInterviewRound_pg());
		pc.add("Suggestions", new SuggestionJob_pg());
		
		this.setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc, BorderLayout.CENTER);
		add(ps, BorderLayout.SOUTH);
		
		btprev.addActionListener(this);
		btnext.addActionListener(this);
		btsuggestion.addActionListener(this);
		btback.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		Object src=ae.getSource();
		if(src==btprev)
		{
			CLO.previous(pc);
		}
		else if(src==btnext)
		{
			CLO.next(pc);
		}
			else if(src==btsuggestion)
			{
				CLO.last(pc);
			}
			else
			{
				this.dispose();
			}
	}
}
