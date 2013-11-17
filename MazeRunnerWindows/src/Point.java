


	/** Dit punt object is een simpel punt met x,y en z cooordinaat. de class heeft enkele functies die helpen bij bla bla bla
	 * 
	 * @author Bart Boogmans 
	 */
public class Point extends GameObject {

	
	/** Dit punt object is een simpel punt met x,y en z cooordinaat.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point(double x,double y, double z){
		super.locationX=x;
		super.locationY=y;
		super.locationZ=z;
	}
	
	/** geeft de afstand van de cooordinaten tot het nulpunt(origin)
	 * @return double de afstand tot de origin
	 */
	public double distanceToOrigin(){
		return Math.sqrt(locationX*locationX+locationY*locationY+locationZ*locationZ);
	}
	
	/**deze functie maakt van de punten, een nieuwe set met punten, waarbij de vectorlengte tot de origin 1 is.
	 * het maakt ookwel van een vector, een unitvector
	 */
	public void makeUnitVector(){
		locationX=locationX/this.distanceToOrigin();
		locationX=locationX/this.distanceToOrigin();
		locationX=locationX/this.distanceToOrigin();
	}
	
	
	/**
	 * berekent en returnt het inner product tussen Vectoren(points) This en p.
	 * @param p De vector(point) waarmee this een inner product moet vormen
	 * @return Het inner Product, dus een vector(point).
	 */
	public Point innerProduct(Point p){
		return new Point(locationY*p.getLocationZ()-p.getLocationY()*locationZ,  locationX*p.getLocationZ()-p.getLocationX()*locationZ,  locationX*p.getLocationY()-p.getLocationX()*locationY);
	}
}
