import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {

	public Button(){
	}
	
	public static JButton newButton(String filename1, String filename2, String filename3){
		JButton button = new JButton();
		Image plaatje=Toolkit.getDefaultToolkit().getImage(filename1);
		Icon icoon=new ImageIcon(plaatje);
		button.setIcon(icoon);
		button.setFocusable(false);
		Image a=Toolkit.getDefaultToolkit().getImage(filename2);
		Icon icoon2=new ImageIcon(a);
		Image b=Toolkit.getDefaultToolkit().getImage(filename3);
		Icon icoon3=new ImageIcon(b);
		button.setRolloverIcon(icoon2);
		button.setPressedIcon(icoon3);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		return button;
	}
}
