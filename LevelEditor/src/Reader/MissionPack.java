package Reader;

import Visualiser.Editor.*;
import java.util.*;
import java.io.*;
import Reader.ReadWorld;
import Writer.WriteWorld;

public class MissionPack {
	
	public ArrayList<World> worlds;
	private static Scanner read;
	
	public MissionPack(){
		
	}
	
	public void addWorld(World world){
		if(!this.worlds.contains(world)){
			this.worlds.add(world);
		}
	}
	
	public World getWorld(int index){
		return worlds.get(index);
	}
	
	public int getSize(){
		return worlds.size();
	}
	
	public static MissionPack readMissions(String file) throws IOException{
		MissionPack mp = new MissionPack();
		try{
			read = new Scanner(new File(file));
		}catch(FileNotFoundException excepzione){
			System.out.println("The file with name " + file + " does not exist, please check your filename.");
			return null;
		}
		mp = ReadWorld.readMissionPack(read);
		return mp;
	}
	
	public void writeMissionPack(BufferedWriter out) throws IOException{
		WriteWorld.missionPackWriter(out, this);
	}

}
