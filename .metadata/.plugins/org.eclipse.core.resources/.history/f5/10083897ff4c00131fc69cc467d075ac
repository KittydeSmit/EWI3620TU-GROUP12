package Visualiser.Editor;

import Visualise.Assets;

public class World {
	
	private int[][][] world;
	private int dimension;
	
	public Pixmap block; //gelijkstellen aan een Pixmap uit class Assets
	public Pixmap wall;  //gelijkstellen aan een Pixmap uit class Assets
	
	public World(int dim){
		dimension = dim;
		world = new int[dimension][dimension][dimension];
	}
	
	public static World newwWorld(int dimension){
		if(dimension > 0){
			return new World(dimension);
		}
		return null;
	}
	
	public void resizeWorld(int dimension){
		world = new int[dimension][dimension][dimension];
	}
	
	public int getDim(){
		return dimension;
	}
	
	public int getCoordValue(int i, int j, int h){
		return world[i][j][h];
	}

}
