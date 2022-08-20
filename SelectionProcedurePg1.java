import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SelectionProcedurePg1 extends JDialog implements ActionListener
{
		JLabel lb1,lbicon,lbinfo;
		JTextArea txdescp;
		JButton btround,btclose;
		JPanel Pn,Pc,Ps,P1,P2,P3,Pdesc,Pbt;
		
		public SelectionProcedurePg1()
		{	
			this.setVisible(true);
			this.setSize(new Dimension(1800,1000));
			
			Font f=new Font("CASTELLAR",Font.BOLD,90);
			Font f1=new Font("Arial",Font.BOLD,30);
			
			lb1=new JLabel("Selection Procedure");
			lbinfo=new JLabel("In order to view the information about various rounds click on the buttons given below");
			
			lb1.setForeground(Color.RED);
			lb1.setFont(f);
			lbinfo.setForeground(Color.RED);
			lbinfo.setFont(f1);
			
			txdescp=new JTextArea("\t  There are basically four rounds in a company hiring process."
					+ "\nThese rounds include aptitude test, technical interview,"
					+ "a managerial interview, and an HR interview. ");
			txdescp.setFont(f1);
			txdescp.setForeground(Color.BLUE);
			
			btround=new JButton("Rounds");
			btclose=new JButton("Close");
			
			//setting size and text fonts
			btround.setFont(f1);
			btclose.setFont(f1);
			
			btround.setPreferredSize(new Dimension(400,50));
			btclose.setPreferredSize(new Dimension(400,50));
						
			lbicon=new JLabel();
			URL rURL1=getClass().getResource("Select_procedure_img.png");
			if(rURL1!= null)
				lbicon.setIcon(new ImageIcon(rURL1));
			
			Pn=new JPanel();
			Pn.add(lb1);

			P1=new JPanel();
			P1.setPreferredSize(new Dimension(400,500));
			P1.add(lbicon);
			
			P2=new JPanel();
			P2.add(lbinfo);
			
			P3=new JPanel();
			P3.add(txdescp);
			
			Pdesc=new JPanel();
			Pdesc.setLayout(new GridLayout(2,1));
			Pdesc.add(P3);
			Pdesc.add(P2);
			
			Pbt=new JPanel();
			Pbt.add(btround);
			Pbt.add(btclose);
			
			Ps=new JPanel();
			Ps.setLayout(new GridLayout(2,1));
			Ps.add(Pdesc);
			Ps.add(Pbt);
			
			Pc=new JPanel();
			Pc.setLayout(new FlowLayout());
			Pc.add(P1);
				
			
			Pn.setBackground(Color.WHITE);
			Pc.setBackground(Color.WHITE);
			Ps.setBackground(Color.WHITE);
			P1.setBackground(Color.WHITE);
			P2.setBackground(Color.WHITE);
			P3.setBackground(Color.WHITE);
			Pbt.setBackground(Color.WHITE);
			
			
			this.setLayout(new BorderLayout());
			add(Pn,BorderLayout.NORTH);
			add(Pc,BorderLayout.CENTER);
			add(Ps,BorderLayout.SOUTH);
			
			btround.addActionListener(this);
			btclose.addActionListener(this);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			// TODO Auto-generated method stub
			Object src=ae.getSource();
			if(src==btround)
			{
				new RoundsLayoutPg();
			}
			if(src==btclose)
			{
				this.dispose();
			}
			
		}

}