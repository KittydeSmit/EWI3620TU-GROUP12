/**
 * Camera represents the camera player in MazeRunner.
 * <p>
 * This class extends GameObject to take advantage of the already implemented location 
 * functionality. Furthermore, it also contains the orientation of the Camera, ie. 
 * where it is looking at. 
 * <p>
 * All these variables can be adjusted freely by MazeRunner. They could be accessed
 * by other classes if you pass a reference to them, but this should be done with 
 * caution.
 * 
 * @author Bruno Scheele
 *
 */
public class Camera extends GameObject {
	private Point VuV,VRP;
	private Control control = null;
	private double speed = 0.01, rotatespeed = 0.002;
	
	
	public Camera( double x, double y, double z, double h, double v ) {
		// Set the initial position and viewing direction of the player.
		super( x, y, z );
		
		// Calculate a likely view reference point and
		// Set the view up vector to be parallel to the y-axis of the world.
		VuV=new Point(0.0,1.0,0.0);
		VRP=new Point(0.0,0.0,1.0);
	}
	
	/** Roteert de camera linksom of rechtsom
	 * @param a De hoek waarmee de camera links(+) of rechts(-) geroteerd moet worden.
	 */
	public void rotateLR(double a){
		double[] VRPloc = rotate(a,VRP.getLocationX(),VRP.getLocationY(),VRP.getLocationZ(),VuV.getLocationX(),VuV.getLocationY(),VuV.getLocationZ());
		VRP.setLocationX(VRPloc[0]);
		VRP.setLocationY(VRPloc[1]);
		VRP.setLocationZ(VRPloc[2]);
	}
	
	/** Roteert de camera omlaag of omhoog
	 * @param a De hoek waarmee de camera omhoog(+) of omlaag(-) geroteerd moet worden.
	 */
	public void rotateUD(double a){ 
		// xVieuw is een vector loodrecht op de VRP en de VuV.(x cooordinaat in vieuwing cooordinaten)
		Point xVieuw = VuV.innerProduct(VRP);
		// rotate VRP
		double[] VRPloc = rotate(a,VRP.getLocationX(),VRP.getLocationY(),VRP.getLocationZ(),xVieuw.getLocationX(),xVieuw.getLocationY(),xVieuw.getLocationZ());
		VRP.setLocationX(VRPloc[0]);
		VRP.setLocationY(VRPloc[1]);
		VRP.setLocationZ(VRPloc[2]);
		// rotate VuV
		double[] VuVloc = rotate(a,VuV.getLocationX(),VuV.getLocationY(),VuV.getLocationZ(),xVieuw.getLocationX(),xVieuw.getLocationY(),xVieuw.getLocationZ());
		VuV.setLocationX(VuVloc[0]);
		VuV.setLocationY(VuVloc[1]);
		VuV.setLocationZ(VuVloc[2]);
		
		
		
		//Bereken nieuw VuV met inner product van VRP en xVieuw
		
	
	}
	
	
	/** rotate the point (x,y,z) about the vector u,v,w by the angle a
	 * @param a radialen die gedraaid moeten worden
	 * @param x x cooordinaat die geroteerd moet worden
	 * @param y y cooordinaat die geroteerd moet worden
	 * @param z z cooordinaat die geroteerd moet worden
	 * @param u x cooordinaat van de vector waarom geroteerd wordt
	 * @param v y cooordinaat van de vector waarom geroteerd wordt
	 * @param w z cooordinaat van de vector waarom geroteerd wordt
	 * @return de nieuwe coordinaten [x,y,z] als double[]
	 */
		public double[] rotate(double a, double x, double y, double z, double u, double v, double w){
			double newx = ( u*(u*x+v*y+w*z)*(1-Math.cos(a)) + (u*u+v*v+w*w)*x*Math.cos(a) + Math.sqrt(u*u+v*v+w*w)*(v*z-w*y)*Math.sin(a) )/( u*u+v*v+w*w);
			double newy = ( v*(u*x+v*y+w*z)*(1-Math.cos(a)) + (u*u+v*v+w*w)*y*Math.cos(a) + Math.sqrt(u*u+v*v+w*w)*(w*x-u*z)*Math.sin(a) )/( u*u+v*v+w*w);
			double newz = ( w*(u*x+v*y+w*z)*(1-Math.cos(a)) + (u*u+v*v+w*w)*z*Math.cos(a) + Math.sqrt(u*u+v*v+w*w)*(u*y-v*x)*Math.sin(a) )/( u*u+v*v+w*w);
			double[] newlocs = {newx,newy,newz};
			return newlocs;
		}
	
	/**
	 * Returns the x-coordinate of the view reference point.
	 * @return the vrpX
	 */
	public double getVrpX() {
		return VRP.locationX;
	}

	/**
	 * Sets the x-coordinate of the view reference point.
	 * @param vrpX the vrpX to set
	 */
	public void setVrpX(double vrpX) {
		this.VRP.setLocationX(vrpX);
	}

	/**
	 * Returns the y-coordinate of the view reference point.
	 * @return the vrpY
	 */
	public double getVrpY() {
		return VRP.locationY;
	}

	/**
	 * Sets the y-coordinate of the view reference point.
	 * @param vrpY the vrpY to set
	 */
	public void setVrpY(double vrpY) {
		this.VRP.setLocationY(vrpY);
	}

	/**
	 * Returns the z-coordinate of the view reference point.
	 * @return the vrpZ
	 */
	public double getVrpZ() {
		return VRP.locationZ;
	}

	/**
	 * Sets the z-coordinate of the view reference point.
	 * @param vrpZ the vrpZ to set
	 */
	public void setVrpZ(double vrpZ) {
		this.VRP.setLocationZ(vrpZ);
	}

	/**
	 * Returns the x-coordinate of the view up vector.
	 * @return the vuvX
	 */
	public double getVuvX() {
		return VuV.locationX;
	}

	/**
	 * Sets the x-coordinate of the view up vector.
	 * @param vuvX the vuvX to set
	 */
	public void setVuvX(double vuvX) {
		this.VuV.setLocationX(vuvX);
	}

	/**
	 * Returns the y-coordinate of the view up vector.
	 * @return the vuvY
	 */
	public double getVuvY() {
		return VuV.locationY;
	}

	/**
	 * Sets the y-coordinate of the view up vector.
	 * @param vuvY the vuvY to set
	 */
	public void setVuvY(double vuvY) {
		this.VuV.setLocationY(vuvY);
	}

	/**
	 * Returns the z-coordinate of the view up vector.
	 * @return the vuvZ
	 */
	public double getVuvZ() {
		return VuV.locationZ;
	}

	/**
	 * Sets the z-coordinate of the view up vector.
	 * @param vuvZ the vuvZ to set
	 */
	public void setVuvZ(double vuvZ) {
		this.VuV.setLocationZ(vuvZ);
	}
	
	/**
	 * Sets the Control object that will control the camera's motion
	 * <p>
	 * The control must be set if the object should be moved.
	 * @param input
	 */
	public void setControl(Control control)
	{
		this.control = control;
	}
	
	/**
	 * Gets the Control object currently controlling the camera
	 * @return
	 */
	public Control getControl()
	{
		return control;
	}
	/**
	 * Updates the physical location and orientation of the player
	 * @param deltaTime The time in milliseconds since the last update.
	 */
	public void update(int deltaTime)
	{
		if(control != null){
			control.update();
			//als je op b drukt begint hij te lopen
			if(control.begin){
				System.out.println("VRP: "+VRP.getLocationX()+" "+VRP.getLocationY()+" "+VRP.getLocationZ());
				VRP.makeUnitVector();
				System.out.println("VRP: "+VRP.getLocationX()+" "+VRP.getLocationY()+" "+VRP.getLocationZ());
				System.out.println("VuV: "+VuV.getLocationX()+" "+VuV.getLocationY()+" "+VuV.getLocationZ());
				
				
				locationX = locationX + VRP.getLocationX()*speed*deltaTime;
				locationY = locationY + VRP.getLocationY()*speed*deltaTime;
				locationZ = locationZ + VRP.getLocationZ()*speed*deltaTime;
			}
			//moeten view gaan fixen, iets met setVrpX, setVrpY, setVrpZ
			if(control.up){
				rotateUD(-rotatespeed*deltaTime);
			}
			if(control.left){
				rotateLR(rotatespeed*deltaTime);
			}
			if(control.right){
				rotateLR(-rotatespeed*deltaTime);
			}
			if(control.down){
				rotateUD(rotatespeed*deltaTime);
			}
		}
	}
}