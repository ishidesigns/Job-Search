import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class C_Page extends JPanel
{
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15;
	
	public C_Page()
	{
		this.setSize(2400, 900);
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		
		Font F=new Font("Arial",Font.BOLD,24);
		this.setFont(F);
		Font F1=new Font("Arial",Font.BOLD,16);
		
		lb1=new JLabel("Q1. What is a pointer on pointer?");
		lb2=new JLabel("Q2. Distinguish between malloc() and calloc().");
		lb3=new JLabel("Q3. What is Keyword Auto For?");
		lb4=new JLabel("Q4. What is Static Variable");
		lb5=new JLabel("Q5. Why we Use Register Storage Specifier?");
		lb6=new JLabel("Q6. What is dangling Pointer");
		lb7=new JLabel("Q7. What is the purpose of keyword typedef?");
		lb8=new JLabel("Q8. Can a Program be completed without main()?");
		lb9=new JLabel("Q9. What is self-refrential Structure?");
		lb10=new JLabel("Q10. What Is Token?");
		lb11=new JLabel("Q11. When to use ->(arrow) operator?");
		lb12=new JLabel("Q12. Describe the file opening mode 'w+'?");
		lb13=new JLabel("Q13. Is file a built in datatype?");
		lb14=new JLabel("Q14. Which function is used to close the file stream?");
		lb15=new JLabel("Q15. What is the output file generated by the linker?");
			   
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