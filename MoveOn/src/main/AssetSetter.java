package main;


import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import entity.Vehicle;
import model.VehicleModel;

public class AssetSetter {
    GamePanel gp;
    List<VehicleModel> vehicles;
    
    private static final String ASSETS_FILE_PATH = "MoveOn/res/Assets/assets.json";
    
    public AssetSetter(GamePanel gp){
        this.gp =gp;
        loadAssets();
    }

    public void setObject(){
//		int mapNum =0;
//        int i =0;
//        gp.obj[mapNum][i] = new OBJ_Coin_Bronze(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*25;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*23;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_Coin_Bronze(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*21;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*19;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_Coin_Bronze(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*26;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*21;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_Axe(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*33;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*21;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*35;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*21;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_Heart(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*22;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*27;
//        i++;
//        gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
//    	gp.obj[mapNum][i].worldX = gp.tileSize*22;
//    	gp.obj[mapNum][i].worldY = gp.tileSize*31;
//        i++;
    }
    
//    public void setNPC() {
//        int i =0;
//		int mapNum =0;
//
//        gp.npc[mapNum][i] = new NPC_OldMan(gp);
//    	gp.npc[mapNum][i].worldX = gp.tileSize*45;
//    	gp.npc[mapNum][i].worldY = gp.tileSize*18;
//        i++;
//
//    }
    public void setMonster(){
		int mapNum =0;
    	int i=0;
//        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
//        gp.monster[mapNum][i].worldX = gp.tileSize*23;
//        gp.monster[mapNum][i].worldY = gp.tileSize*36;
//        i++;
//        
//        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
//        gp.monster[mapNum][i].worldX = gp.tileSize*23;
//        gp.monster[mapNum][i].worldY = gp.tileSize*37;
//        i++;
//        
//        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
//        gp.monster[mapNum][i].worldX = gp.tileSize*24;
//        gp.monster[mapNum][i].worldY = gp.tileSize*37;
//        i++;
//
//        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
//        gp.monster[mapNum][i].worldX = gp.tileSize*34;
//        gp.monster[mapNum][i].worldY = gp.tileSize*42;
//        i++;
//        
//        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
//        gp.monster[mapNum][i].worldX = gp.tileSize*38;
//        gp.monster[mapNum][i].worldY = gp.tileSize*42;

    }
    
    public void setInteractiveTile() {
//    	int i =0;
//		int mapNum =0;
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,27,12);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] =new IT_DryTree(gp,28,12);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,29,12);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,30,12);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] =new IT_DryTree(gp,31,12);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,32,12);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,33,12);
//    	i++;
//
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,30,20);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] =new IT_DryTree(gp,30,21);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,30,22);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,20,20);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] =new IT_DryTree(gp,20,21);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,20,22);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,22,24);
//    	i++;
//    	
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,23,24);
//    	i++;
//    	gp.iTile[mapNum][i] = new IT_DryTree(gp,24,24);
//    	i++;
    	
    }
    
    public void loadAssets() {
    	Gson gson = new Gson();
    	try (FileReader reader = new FileReader(ASSETS_FILE_PATH)) {
            Type listType = new TypeToken<List<VehicleModel>>(){}.getType();
            vehicles = gson.fromJson(reader, listType);
            for (VehicleModel vehicle : vehicles) {
                System.out.println(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public void setNPC() {
    	
    	int i = 0;
    	for (VehicleModel vehicle : vehicles) {
    		gp.vehicle[0][i] = new Vehicle(gp, vehicle.getImageName(),vehicle.getDirection(),vehicle.getSourceDestinationX(),vehicle.getSourceDestinationY(),vehicle.getSourceCurrentX(),vehicle.getSourceCurrentY(),vehicle.getTargetDestinationX(),vehicle.getTargetDestinationY(),vehicle.getTargetCurrentX(),vehicle.getTargetCurrentY());
    		gp.vehicle[2][i] = new Vehicle(gp, vehicle.getImageName(),vehicle.getDirection(),vehicle.getSourceDestinationY(),vehicle.getSourceDestinationY(),vehicle.getSourceCurrentX(),vehicle.getSourceCurrentY(),vehicle.getTargetDestinationX(),vehicle.getTargetDestinationY(),vehicle.getTargetCurrentX(),vehicle.getTargetCurrentY());
    		i++;
    	}
    }

}
