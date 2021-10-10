package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author Avdo Dzanic
 *
 */
public class AboutUs  extends JFrame{

	JLabel text;
	JButton goBack;
	JLabel textGame;
	JLabel textGame1;
	JLabel textGame2;
	JLabel textGame3;
	JLabel textGame4;
	JLabel textGame5;
	/**
	 * Constructor who make this Jframe,and users can read how to play a game
	 * @param text is heading 
	 * @param goBack id Button for back to play game,after you reading how to play game
	 * @param textGame,textGame1,textGame2,textGame3,textGame4,textGame5 is paragraf who explain how to play a game
	 */
	public AboutUs() {
		text=new JLabel("Welcome to NumberCrush!");
		textGame=new JLabel("This game is played by clicking on one button");
			textGame1=new JLabel(" and making a move with another,in case the move");
			textGame2=new JLabel("is valid you destroy a row of three identical numbers.");
				textGame3=new JLabel("For each intersection of three numbers you have");
				textGame4=new JLabel("an increase in points by 1.At 6 Points you go to the nextLevel ") ;
				textGame5=new JLabel("and for the next Level you have to have plus two more points");
		goBack=new JButton("Go back");
		
		this.setLayout(new GridLayout(8,1));
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				StartPanel sp=new StartPanel();
				dispose();
			}
			
		});
		this.add(text);
		this.add(textGame);
		this.add(textGame1);
		this.add(textGame2);
		this.add(textGame3);
		this.add(textGame4);
		this.add(textGame5);
		this.add(goBack);
		this.setSize(400,200);
		this.setLocation(400,150);
		this.setTitle("About Us");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		goBack.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		
		
	}

}
