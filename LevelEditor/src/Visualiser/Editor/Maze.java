package Visualiser.Editor;

public class Maze {
	
	private int[][] maze;
	
	public Maze(int i, int j){
		maze = new int[i][j];
	}
	
	public void setMazeCoord(int one, int two, int bin){
		maze[one][two] = bin;
	}

}
