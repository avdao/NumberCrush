package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import Logic.NumberCrush;
/**
 * 
 * @author Avdo Dzanic
 *
 */
public class MakeBoard extends JFrame{
	
	JLabel textOne;
	
	JTextField text;

	JLabel textTwo;
	
	JTextField text1;
	
	JLabel textThree;
	
	JTextField text2;
	
	JButton OK;
	
	
	int n;
	
	int m;
	
	int m1;
/**
 * constructor for make this panel
 *  @param textOne is text for input text
 *  @param text we enter rows as we want
 *  @param textTwo is text for input text1
 *  @param text1 we enter cols as we want
 *  @param  textThree is text for input text2
 *  @param text2 we enter number as we want in the game
 *  @param OK is submitButton
 *  @param  n getValue of text
 *  @param  m getValue of text1
 *  @param m1 getValue of text2
 */
	public MakeBoard() {
	
		textOne=new JLabel("Enter the number of rows:");
		text=new JTextField(5);
		textTwo=new JLabel("Enter the number of columns:");
		text1=new JTextField(5);
		textThree=new JLabel("Enter the number in game(1-7):");
		text2=new JTextField(5);
		OK=new JButton("OK");
		/**
		 * design Panel
		 */
		this.setLayout(new GridLayout(6,1));
		this.add(textOne);
		this.add(text);
		this.add(textTwo);
		this.add(text1);
		this.add(textThree);
		this.add(text2);
		OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				n=Integer.parseInt(text.getText());
			  m=Integer.parseInt(text1.getText());
			  m1=Integer.parseInt(text2.getText());
		
				MyPanel mP=new MyPanel(n,m,m1);
			
				dispose();
			}
			
		});
		
		
		
		this.add(OK);
		this.setLocation(400,150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setTitle("Make Board");
		
		
		
	}

	public void makePanel() {
		this.setVisible(true);
	}
	
	
	
}
