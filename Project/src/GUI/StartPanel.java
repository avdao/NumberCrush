package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
public class StartPanel extends JFrame{

	JLabel text;
	Button start;
	Button aboutUs;
	/**
	 * Constructor for make a design of StartPanel
	 *  @param text is text
	 * @param start Button for play a game
	 * @param aboutUs Button for for roles how to play a game
	 */
	public StartPanel() {
		text=new JLabel("Welcome to NumberCrush");
		
		start=new Button("Start Game");
		aboutUs=new Button("About US");
		this.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;c.weighty=0.5;
		c.fill=GridBagConstraints.HORIZONTAL;
		this.add(text,c);
		
		c.gridx=0;
		c.gridy=2;

		c.fill=GridBagConstraints.HORIZONTAL;
		this.add(start,c);
		c.gridx=0;
		c.gridy=4;

		c.fill=GridBagConstraints.HORIZONTAL;
		this.add(aboutUs,c);
	/**
	 * ActionListener when we click a start ,game will be start
	 */
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				MakeBoard mb=new MakeBoard();
				mb.makePanel();
				dispose();
			
			}

		
			
			
		});
		/**
		 * If you want know how to play a game
		 */
		
		aboutUs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AboutUs();
				dispose();
			}
			
		});
		text.setFont(new Font("Monospaced",Font.PLAIN,20));
		start.setFont(new Font("Monospaced",Font.PLAIN,20));
		aboutUs.setFont(new Font("Monospaced",Font.PLAIN,20));
	start.setBackground(Color.LIGHT_GRAY);
	aboutUs.setBackground(Color.LIGHT_GRAY);
	

	start.setForeground(Color.black);
	aboutUs.setForeground(Color.black);
	text.setForeground(Color.black);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
	    this.setBackground(Color.red);
		this.setLocation(400,150);
		this.setVisible(true);
		this.setTitle("Start Panel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
	}


	


}
