package Visualiser.Editor;

import Visualiser.Editor.WorldLayer;

//import Visualise.Assets;
/**
 * De klasse World is de hoofdklasse van de omgeving van het spel. Hierin kunnen werelden
 * aangemaakt en vervormd worden.
 * <p>
 * @author Gma-X
 *
 */
public class World {
	
	private Maze[] world;
	private int dimension;
	private String name;
	
	//public Pixmap block; //gelijkstellen aan een Pixmap uit class Assets
	//public Pixmap wall;  //gelijkstellen aan een Pixmap uit class Assets
	
	/**
	 * Maakt een 3D wereld aan met een dimensie en een naam
	 * <p>
	 * @param dim De dimensie van de wereld
	 * @param naam De naam van de wereld
	 */
	public World(int dim, String naam){
		dimension = dim;
		name = naam;
		world = new Maze[dim];
	}
	
	/**
	 * Maakt een nieuwe wereld aan, mits de dimensie groter is dan nul
	 * <p>
	 * @param dim De dimensie van de nieuwe wereld
	 * @param naam De naam van de nieuwe wereld
	 * @return Retourneert de nieuwe wereld die het heeft aangemaakt
	 */
	public static World newWorld(int dim, String naam){
		if(dim > 0){
			return new World(dim, naam);
		}
		return null;
	}
	
	/**
	 * Vervormt de wereld en maakt het leeg
	 * <p>
	 * @param dim De dimensie die de vervormde wereld moet hebben
	 */
	public void resizeWorld(int dim){
		dimension = dim;
		world = new Maze[dim];
	}
	
	/**
	 * Geeft de dimensie van de wereld waarmee wordt gewerkt
	 * <p>
	 * @return Retourneert de dimensie van de wereld
	 */
	public int getDim(){
		return dimension;
	}
	
	/**
	 * Geeft de naam van de wereld waarmee wordt gewerkt
	 * <p>
	 * @return Retourneert de naam van de wereld
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Geeft de (binaire) waarde terug van een specifiek punt van de wereld
	 * <p>
	 * @param i De i-coordinaat van het punt
	 * @param j De j-coordinaat van het punt
	 * @param h De h-coordinaat van het punt
	 * @return Retourneert de (binaire) waarde gevonden op het gespecifeerde punt
	 */
	public int getCoordValue(int i, int j, int h){
		return world[h].getMazeCoord(i, j);
	}
	
	public WorldLayer getVertLayerI(int iCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		return wl.getVerticalMazeI(iCoord, wor);
	}
	
	public WorldLayer getVertLayerJ(int jCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		return wl.getVerticalMazeJ(jCoord, wor);
	}
	
	public WorldLayer getHoriLayerH(int hCoord, World wor){
		WorldLayer wl = new WorldLayer(wor);
		return wl.getHorizontalMazeH(hCoord, wor);
	}

}
