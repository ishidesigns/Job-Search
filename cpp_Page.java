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

public class cpp_Page extends JPanel
{
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14
				,lb15;
	JPanel Ps;
	
	public cpp_Page()
	{
		this.setSize(2400, 900);
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		
		Font F=new Font("Arial",Font.BOLD,24);
		this.setFont(F);
		
		lb1=new JLabel("Q1.What is a class?");
		lb2=new JLabel("Q2.What is Object?");
		lb3=new JLabel("Q3.List the types of inheritance supported in C++?");
		lb4=new JLabel("Q4.What is the role of protected access specifier?");
		lb5=new JLabel("Q5.What is encapsulation?");
		lb6=new JLabel("Q2.What is abstraction?");
		lb7=new JLabel("Q7.Explain the purpose of the keyword volatile.");
		lb8=new JLabel("Q8.What is an inline function?");
		lb9=new JLabel("Q9.What is a storage class?And mention them.");
		lb10=new JLabel("Q10.Distinguish between shallow copy and deep copy?");
		lb11=new JLabel("Q11.What is role of static keyword on class member variable?");
		lb12=new JLabel("Q12.Explain the static member function.?");
		lb13=new JLabel("Q13.What is a pure virtual function?");
		lb14=new JLabel("Q14.What is function overloading?");
		lb15=new JLabel("Q15.What is operator overloading?");
		
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
		   
		   
		setLayout(new GridLayout(15,2,10,20));
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