import java.io.BufferedWriter;
import java.io.FileWriter;
import Visualiser.Editor.World;

public class WriteMaze {
	
	public void writeToFile(World maze){
		BufferedWriter bw = new BufferedWriter(new FileWriter("EditorMaze.txt"));
		bw.write(maze.getDim() + ";\r\n");
		bw.newLine();
		for(int h = 0; h < maze.getDim(); h++){
			bw.write("{     ");
			for(int i = 0; i < maze.getDim(); i++){
				for(int j = 0; j < maze.getDim(); j++){
					if(!(i == maze.getDim() -1) && !(j == maze.getDim() - 1)){
						if(maze[i][j].isWall()){
							bw.write(1 + " ");
						}
						else{
							bw.write(0 + " ");
						}
					}
					else{
						if(maze[i][j].isWall()){
							bw.write(1 + "}");
						}
						else{
							bw.write(0 + "}");
						}
					}
				}
				bw.newLine(); bw.write("      ");
			}
			bw.newLine(); bw.newLine();
		}
	}
}
