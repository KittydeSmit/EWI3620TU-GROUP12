package Visualiser.Editor;

public class Maze {
	
	private int[][] maze;
	private int dimension;
	
	public Maze(int dim){
		dimension = dim;
		maze = new int[dim][dim];
	}
	
	public void setMazeCoord(int one, int two, int bin){
		maze[one][two] = bin;
	}
	
	public int getMazeCoord(int one, int two){
		return maze[one][two];
	}
	
	public int getDim(){
		return dimension;
	}
	
	public void mirrorHorizontally(){
		int dim = this.getDim();
		int[][] mirror = new int[dim][dim];
		
		for(int i = 0; i < dim; i++){
			for(int j = 0; j < dim; j++){
				mirror[dim - (i + 1)][j] = this.maze[i][j];
				mirror[i][j] = this.maze[dim - (i + 1)][j];
			}
		}
		this.maze = mirror;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < this.getDim(); i++){
			for(int j = 0; j < this.getDim(); j++){
				str = str + this.maze[i][j] + " ";
			}
			str = str + "\n";
		}
		return null;
	}

}
