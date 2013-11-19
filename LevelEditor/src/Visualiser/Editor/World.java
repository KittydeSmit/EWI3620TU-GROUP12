package Visualiser.Editor;

import Visualiser.Editor.WorldLayer;
import Writer.WriteWorld;
import java.util.*;
import java.io.*;
import Reader.ReadWorld;

//import Visualise.Assets;
/**
 * De klasse World is de hoofdklasse van de omgeving van het spel. Hierin kunnen werelden
 * aangemaakt en vervormd worden.
 * <p>
 * @author Gma-X
 *
 */
public class World {
	
	public ArrayList<Maze> level;
	public int dimension;
	public String name;
	
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
		level = new ArrayList<Maze>();
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
		level = new ArrayList<Maze>();
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
	
	public ArrayList<Maze> getLevel(){
		return level;
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
		return level.get(h).getMazeCoord(i, j);
	}
	
	/**
	 * Geeft de verticale laag van de wereld op de opgegeven i-coordinaat
	 * <p>
	 * @param iCoord De i-coordinaat van de opgevraagde verticale laag
	 * @return Retourneert de verticale laag
	 */
	public WorldLayer getVertLayerI(int iCoord){
		WorldLayer wl = new WorldLayer(this);
		return wl.getVerticalMazeI(iCoord, this);
	}
	
	/**
	 * Geeft de verticale laag van de wereld op de opgegeven j-coordinaat
	 * <p>
	 * @param jCoord De j-coordinaat van de opgevraagde verticale laag
	 * @return Retourneert de verticale laag
	 */
	public WorldLayer getVertLayerJ(int jCoord){
		WorldLayer wl = new WorldLayer(this);
		return wl.getVerticalMazeJ(jCoord, this);
	}
	
	/**
	 * Geeft de horizontale laag van de wereld op de opgegeven h-coordinaat
	 * <p>
	 * @param hCoord De h-coordinaat van de opgevraagde horizontale laag
	 * @return Retourneert de horizontale laag
	 */
	public WorldLayer getHoriLayerH(int hCoord){
		WorldLayer wl = new WorldLayer(this);
		return wl.getHorizontalMazeH(hCoord, this);
	}
	
	public boolean equals(Object obj){
		boolean theSame = true;
			
		if(obj instanceof World){
			World that = (World) obj;
			if(this.getDim() != that.getDim()){
				return !theSame;
			}else if(this.getDim() == that.getDim()){
				for(int hCoord = 0; hCoord < this.getDim(); hCoord++){
					if(!this.level.get(hCoord).equals(that.level.get(hCoord))){
						return !theSame;
					}
				}
			}
		}
		return !theSame;
	}
	
	public static World read(Scanner read) throws IOException{
		World world = ReadWorld.readWorld(read);
		return world;
	}

}