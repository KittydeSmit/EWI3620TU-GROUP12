import java.awt.event.*;

import javax.media.opengl.GLCanvas;

/**
 * The UserInput class is an extension of the Control class. It also implements three 
 * interfaces, each providing handler methods for the different kinds of user input.
 * <p>
 * For making the assignment, only some of these handler methods are needed for the 
 * desired functionality. The rest can effectively be left empty (i.e. the methods 
 * under 'Unused event handlers').  
 * <p>
 * Note: because of how java is designed, it is not possible for the game window to
 * react to user input if it does not have focus. The user must first click the window 
 * (or alt-tab or something) before further events, such as keyboard presses, will 
 * function.
 * 
 * @author Mattijs Driel
 *
 */
public class UserInput extends Control 
		implements MouseListener, MouseMotionListener, KeyListener
{
	int mouseX;
	int mouseY;
	int mousedX;
	int mousedY;
	int mouseadX;
	int mouseadY;
	
	/**
	 * UserInput constructor.
	 * <p>
	 * To make the new UserInput instance able to receive input, listeners 
	 * need to be added to a GLCanvas.
	 * 
	 * @param canvas The GLCanvas to which to add the listeners.
	 */
	public UserInput(GLCanvas canvas)
	{
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		canvas.addKeyListener(this);
	}
	
	/*
	 * **********************************************
	 * *				Updating					*
	 * **********************************************
	 */

	@Override
	public void update()
	{
		dX = mousedX;
		dY = mousedY;
	}

	/*
	 * **********************************************
	 * *		Input event handlers				*
	 * **********************************************
	 */

	@Override
	public void mousePressed(MouseEvent event)
	{
		//mouseX = event.getX();
		//mouseY = event.getY();
		
		//mouseadX = mousedX;
		//mouseadY = mousedY;
	}

	@Override
	public void mouseDragged(MouseEvent event)
	{		
		//mousedX = mouseX - event.getX() + mouseadX;
		//mousedY = mouseY - event.getY() + mouseadY;
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if(event.getKeyCode() == KeyEvent.VK_W){
			up = true;
			left = false;
			right = false;
			down = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_A){
			left = true;
			up = false;
			right = false;
			down = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_D){
			right = true;
			up = false;
			left = false;
			down = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_S){
			down = true;
			up = false;
			right = false;
			left = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_B){
			begin = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		//if(event.getKeyCode() == KeyEvent.VK_W){
			//up = false;
		//}
		//if(event.getKeyCode() == KeyEvent.VK_A){
			//left = false;
		//}
		//if(event.getKeyCode() == KeyEvent.VK_D){
			//right = false;
		//}
		//if(event.getKeyCode() == KeyEvent.VK_S){
			//down = false;
		//}
	}

	/*
	 * **********************************************
	 * *		Unused event handlers				*
	 * **********************************************
	 */
	
	@Override
	public void mouseMoved(MouseEvent event)
	{
	}

	@Override
	public void keyTyped(KeyEvent event)
	{
	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
	}

	@Override
	public void mouseEntered(MouseEvent event)
	{
	}

	@Override
	public void mouseExited(MouseEvent event)
	{
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
	}


}
