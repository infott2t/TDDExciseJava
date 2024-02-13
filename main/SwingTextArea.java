package main;
import javax.swing.*;

public class SwingTextArea extends JFrame{
    
    JPanel jp;
    JLabel jl;

    JTextArea jta;
    JTextField jtf;

    SwingTextArea(String title, String texting,int width, int height){

        jta = new JTextArea(10,10);
		jtf = new JTextField(20);
		
		this.add("Center", jta);
		this.add("South", jtf);
        
		jta.setText(texting);
		setBounds(300, 300, 370, 370);
		setTitle("TDD Excise Java:"+ title);
		setVisible(true);
		setResizable(true);
    }
}
