import java.awt.*;

import javax.swing.*;

public class Frame {

	public static void main(String[] args) {
		JFrame test= new JFrame("test");
		JButton button=Button.newButton("plaatje.png","plaatje2.png","plaatje3.png");
		test.setBackground(Color.orange);
		test.setLayout(new GridLayout(2,3,5,5));
		test.add(new JLabel(""));
		test.add(button);
		test.add(new JLabel("test1"));
		test.add(new JLabel("test2"));
		test.add(new JLabel("test3"));
		test.add(new JLabel("test4"));
		test.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		test.setVisible(true);
	}

}
