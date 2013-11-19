package Visualiser.Editor;


/**
 * De klasse Maze heeft alle bewerkingen en uitvoeringen van een maze in zich
 * @author Gma-X
 *
 */
public class Maze {
	
	public int[][] maze;
	private int dimension;
	
	/**
	 * Hier wordt een nieuwe Maze aangemaakt
	 * <p>
	 * @param dim De dimensie van de Maze
	 */
	public Maze(int dim){
		dimension = dim;
		maze = new int[dim][dim];
	}
	/**
	 * Deze methode geeft de mogelijkheid om elke invoer op elke index van een 2D maze te kunnen aanpassen
	 * <p>
	 * @param one De eerste index die aangeeft in welke rij van de Maze een aanpassing wordt aangebracht
	 * @param two De tweede index die aangeeft in welke kolom van de Maze een aanpassing wordt aangebracht
	 * @param bin De (binaire) waarde die op de aangegeven plek in de Maze wordt neergezet
	 */
	public void setMazeCoord(int one, int two, int bin){
		maze[one][two] = bin;
	}
	
	/**
	 * Hiermee kan de waarde van elke index van een Maze worden opgevraagd
	 * <p>
	 * @param one De eerste index die aangeeft in welke rij de waarde opgevraagd dient te worden
	 * @param two De tweede index die aangeeft in welke kolom de waarde opgevraagd dient te worden
	 * @return Retourneert de (binaire) waarde van dat punt
	 */
	public int getMazeCoord(int one, int two){
		return maze[one][two];
	}
	
	/**
	 * Geeft de dimensie van de Maze waarmee wordt gewerkt
	 * <p>
	 * @return Retourneert de dimensie van de Maze
	 */
	public int getDim(){
		return dimension;
	}
	
	/**
	 * Deze methode spiegelt de huidige Maze rond een horizontale as. Dit, omdat in de methode get*LayerMaze* de
	 * van boven naar beneden wordt ingelezen, maar van beneden naar boven wordt geschreven. Deze methode zorgt 
	 * ervoor dat de uiteindelijke laag die geretourneerd wordt eerst goed gedraaid wordt.
	 * 
	 * *note* Deze methode is van een oplossing van stackoverflow.com
	 */
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
	/**
	 * Geeft een String representatie van de opgegeven Maze
	 * <p>
	 * @return Retourneert de Maze als String
	 */
	public String toString(){
		String str = "";
		for(int i = 0; i < this.getDim(); i++){
			for(int j = 0; j < this.getDim(); j++){
				str = str + this.maze[i][j] + " ";
			}
			str = str + "\n";
		}
		return str;
	}
	
	public boolean equals(Object obj){
		boolean theSame = true;
		
		if(obj instanceof Maze){
			Maze that = (Maze) obj;
			for(int iCoord = 0; iCoord < this.getDim(); iCoord++){
				for(int jCoord = 0; jCoord < this.getDim(); jCoord++){
					if(this.maze[iCoord][jCoord] != that.maze[iCoord][jCoord]){
						return !theSame;
					}
				}
			}
		}
		return theSame;
	}

}