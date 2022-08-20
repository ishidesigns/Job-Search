import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BrochurePage  extends JDialog implements ActionListener
{
	JTabbedPane jtp;
	JButton btback;
	JPanel ps;
	
	public BrochurePage()
	{
		
		this.setSize(1800,1000);
		this.setLocationRelativeTo(null);
		
		Font f1=new Font("Arial",Font.BOLD,30);
		
		btback=new JButton("BACK");
		btback.setFont(f1);
		
		ps=new JPanel();
		ps.add(btback);
		ps.setBackground(Color.BLUE);
		
		jtp=new JTabbedPane();
		jtp.setBackground(Color.GREEN);
		jtp.addTab("Companies", new CompanyPage());
		jtp.addTab("About Companies", new CompanyTable());
		jtp.addTab("Particular Company", new TableCompanies());
		add(jtp);
		add(ps,BorderLayout.SOUTH);
		this.setVisible(true);
		
		btback.addActionListener(this);
	}
	public static void main(String[]arg)
	{
		new BrochurePage();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
