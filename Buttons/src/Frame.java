import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame {

	public static void main(String[] args) {
		JFrame test= new JFrame("test");
		JButton button=Button.newButton("plaatje.png","plaatje2.png","plaatje3.png");
		JPanel paneel=new JPanel();
		test.setContentPane(paneel);
		paneel.setBackground(Color.black);
		paneel.setLayout(new BoxLayout(paneel,BoxLayout.Y_AXIS));
		paneel.add(Box.createRigidArea(new Dimension(20,20)));
		button.setAlignmentX(paneel.CENTER_ALIGNMENT);
		paneel.add(button);
		paneel.add(Box.createRigidArea(new Dimension(20,20)));
		paneel.add(new JLabel("button2"));
		paneel.add(Box.createRigidArea(new Dimension(20,20)));
		paneel.add(new JLabel("button3"));
		paneel.add(Box.createRigidArea(new Dimension(20,20)));
		paneel.add(new JLabel("button4"));
		paneel.add(Box.createRigidArea(new Dimension(20,20)));
		paneel.add(new JLabel("button5"));
		test.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		test.setVisible(true); 
		
		//Add action listener to button
		button.addActionListener(new ActionListener() {
		
		      public void actionPerformed(ActionEvent e)
		      {
		          //Execute when button is pressed
		          System.out.println("You clicked the button");
		      }
		  }); 
		
	}
	
	
   
}
