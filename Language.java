import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Language extends JDialog implements ItemListener,ActionListener {
	
	JPanel Pn,Pc,Pe,Pw,Ps,Pbt;
	JComboBox cbselect;
	JLabel lb1,lbcourse,lb2;
	CardLayout CLO;
	JButton btback;
	
	public Language()
	{
		this.setSize(1800, 1000);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		Font F=new Font("ARIAL",Font.ITALIC,60);
			
		Font F1=new Font("ARIAL",Font.ITALIC,30);
			
		lb1=new JLabel("Language Selection");
		lb1.setFont(F);
		lbcourse=new JLabel("LANGUAGE");
		lbcourse.setFont(F1);
		lb2=new JLabel("In order to view sample paper page,Please select any Language given above");
		lb2.setFont(F1);
		
		cbselect=new JComboBox();
		cbselect.addItem("Select Language");
		cbselect.addItem("C");
		cbselect.addItem("C++");
		cbselect.addItem("Java");
		
		cbselect.addItemListener(this);
		cbselect.setFont(F1);
		
		btback=new JButton("BACK");
		btback.setPreferredSize(new Dimension(300,50));
		btback.setFont(F1);
		
		Pbt=new JPanel();
		Pbt.add(btback);
		
		Pn=new JPanel();
		Pn.add(lb1);
		Pn.add(lb2);
		
		Pw=new JPanel();
		Pw.setLayout(new FlowLayout());
		Pw.add(lbcourse);
		Pw.add(cbselect);
		
		Pc=new JPanel();
		CLO=new CardLayout();
		Pc.setLayout(CLO);
		Pc.add("C",new C_Page());
		Pc.add("C++",new cpp_Page());
		Pc.add("Java",new Java_Page());
		
		
		Ps=new JPanel();
		Ps.setLayout(new GridLayout(2,1));
		Ps.add(lb2);
		Ps.add(Pbt);
		
		Pn.setBackground(Color.RED);
		Ps.setBackground(Color.BLUE);
		Pbt.setBackground(Color.BLUE);
		Pw.setBackground(Color.PINK);
		lb2.setForeground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		add(Pn,BorderLayout.NORTH);
		add(Pc,BorderLayout.CENTER);
		add(Pw,BorderLayout.WEST);
		add(Ps,BorderLayout.SOUTH);
		
		btback.addActionListener(this);
}

	public void itemStateChanged(ItemEvent e) 
	 {
		if(cbselect.getSelectedIndex()==0  || e.getStateChange()==ItemEvent.DESELECTED)
		{
			return;
		}
		CLO.show(Pc,cbselect.getSelectedItem().toString());
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		this.dispose();
	}
	public static void main(String[]args)
	{
		new Language();
	}
}