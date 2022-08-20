import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Java_Page extends JPanel
{	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15;

	public Java_Page()
	{
		this.setSize(2400, 900);
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		
		Font F=new Font("Arial",Font.BOLD,24);
		this.setFont(F);
		
		lb1=new JLabel("Q1.What do you understand by Java virtual machine?\r\n"); 
		lb2=new JLabel("Q2.What is the difference between JDK, JRE, and JVM?");
		lb3=new JLabel("Q3.How many types of memory areas are allocated by JVM?");
		lb4=new JLabel("Q4.What gives Java its 'write once and run anywhere' nature?");
		lb5=new JLabel("Q5.What are the advantages of Packages in Java?");
		lb6=new JLabel("Q6.What is object-oriented paradigm?");
		lb7=new JLabel("Q7.What do you understand by copy constructor in Java?");
		lb8=new JLabel("Q8.Can we override the static methods?");
		lb9=new JLabel("Q9.Can we assign the reference to this variable?");
		lb10=new JLabel("Q10.Which class is the superclass for all the classes?");
		lb11=new JLabel("Q11.What is the final variable?");
		lb12=new JLabel("Q12.What are the differences between StringBuffer and StringBuilder?");
		lb13=new JLabel("Q13.What is multithreading?");
		lb14=new JLabel("Q14.What is the thread?");
		lb15=new JLabel("Q15.What is the difference between wait() and sleep() method?");
		
		   lb1.setFont(F);	  
		   lb2.setFont(F);	          
		   lb3.setFont(F);	          
		   lb4.setFont(F);	          
		   lb5.setFont(F);	          
		   lb6.setFont(F);	          
		   lb7.setFont(F);	          
		   lb8.setFont(F);	          
		   lb9.setFont(F);	          
		   lb10.setFont(F);	          
		   lb11.setFont(F);	  
		   lb12.setFont(F);	          
		   lb13.setFont(F);	          
		   lb14.setFont(F);	          
		   lb15.setFont(F);	          
		  
		   lb2.setBackground(Color.WHITE);
		   
		   
		setLayout(new GridLayout(15,1,10,20));
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(lb6);
		add(lb7);
		add(lb8);
		add(lb9);
		add(lb10);
		add(lb11);
		add(lb12);
		add(lb13);
		add(lb14);
		add(lb15);
	}
}