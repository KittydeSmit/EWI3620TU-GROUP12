import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {

	public Button(){
	}
	
	public static JButton newButton(String buttonfile, String buttonrolloverfile, String buttonpressedfile){
		JButton button = new JButton();
		//Geef de button zelfde grootte als het plaatje
		Dimension d=new Dimension(151,89);
		button.setMaximumSize(d);
		//Maakt van de button een plaatje
		Image plaatje=Toolkit.getDefaultToolkit().getImage(buttonfile);
		Icon icoon=new ImageIcon(plaatje);
		button.setIcon(icoon);
		//Maakt van de button een ander plaatje wanneer de muis eroverheen gaat
		Image a=Toolkit.getDefaultToolkit().getImage(buttonrolloverfile);
		Icon icoon2=new ImageIcon(a);
		button.setRolloverIcon(icoon2);
		//Maak van de button een ander plaatje wanneer deze ingedrukt wordt
		Image b=Toolkit.getDefaultToolkit().getImage(buttonpressedfile);
		Icon icoon3=new ImageIcon(b);
		button.setPressedIcon(icoon3);
		//Zorgt ervoor dat van de button alleen het plaatje te zien is
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(false);
		
		
		
		//button.addActionListener(Actionlistener a);
		return button;
	}
}
