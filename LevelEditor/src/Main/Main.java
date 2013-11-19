package Main;

import Reader.*;
import Writer.WriteWorld;
import Visualiser.Editor.*;
import java.io.*;

public class Main {
	
	private static BufferedWriter out;

	public static void main(String[] args) throws IOException{
		MissionPack mp = null;
		out = new BufferedWriter(new FileWriter("TestResult.txt"));
		
		try{
			mp = MissionPack.readMissions("TestMissions.txt");
		}catch(FileNotFoundException excepzione){
			System.out.println("The file you specified can not be found, please check your file.");
			return;
		}
		
		mp.writeMissionPack(out);
	}

}