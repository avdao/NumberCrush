package GUI;

import java.awt.Color;
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
public class NextLevelPanel extends JFrame {

	JLabel text;
	JButton nextLevel;
	JButton exit;
	MyPanel panel;
	MakeBoard mb;
	/**
	 * Constructor for desing JFrame
	 *  @param text is text "Level Complete"
	 * @param nextLevel is the button for new Level
	 * @param exit is for exit game
	 */
	public  NextLevelPanel() {
		mb=new MakeBoard();
		text=new JLabel("Level Complete!");
		nextLevel=new JButton("Go to next Level :)");
		exit=new JButton("Exit");
		this.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
	
		c.gridx=0;
		c.gridy=0;
		
		c.fill=GridBagConstraints.HORIZONTAL;
		this.add(text,c);
		
		c.gridx=0;
		c.gridy=1;

		c.fill=GridBagConstraints.HORIZONTAL;
		this.add(nextLevel,c);
		c.gridx=0;
		c.gridy=3;

		c.fill=GridBagConstraints.HORIZONTAL;
		this.add(exit,c);
		/**
		 * ActionListener for new Level
		 */
		nextLevel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MyPanel panel = new MyPanel(7,7,7);
				panel.reset();
				
						panel.mustHavePoints=panel.mustHavePoints+2;
						dispose();
				
			
			
			}
		
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
			}
		
		});

		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		text.setForeground(Color.black);
		nextLevel.setBackground(Color.LIGHT_GRAY);
		exit.setBackground(Color.LIGHT_GRAY);
		text.setForeground(Color.black);
		this.setSize(400,400);
		this.setTitle("Level Complete!");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
