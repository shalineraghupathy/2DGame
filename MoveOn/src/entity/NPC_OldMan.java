package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity{

	public NPC_OldMan(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width=32;
		solidArea.height = 32;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		up1 = setup("/npc/oldman_up_1",gp.tileSize,gp.tileSize);
		up2 = setup("/npc/oldman_up_2",gp.tileSize,gp.tileSize);
		down1 = setup("/npc/oldman_down_1",gp.tileSize,gp.tileSize);
		down2 = setup("/npc/oldman_down_1",gp.tileSize,gp.tileSize);
		left1 = setup("/npc/oldman_left_1",gp.tileSize,gp.tileSize);
		left2 = setup("/npc/oldman_left_2",gp.tileSize,gp.tileSize);
		right1 = setup("/npc/oldman_right_1",gp.tileSize,gp.tileSize);
		right2 = setup("/npc/oldman_right_2",gp.tileSize,gp.tileSize);
	}
	public void setDialogue(){
		dialogues[0] = "Hello!, Lad.";
		dialogues[1] = "You are at home now";
		dialogues[2] = "You need to go to school and you have four possible transportation";
		dialogues[3] = "Good luck on you.";
	}
	public void setAction() {
		// actionLockCounter++;
		// if(actionLockCounter ==120) {
		// 	Random random = new Random();
		// int i = random.nextInt(100)+1;
		// if(i<=25) {
		// 	direction = "up";		
		// 	}
		// if(i>25 && i<=50) {
		// 	direction = "down";		
		// 	}
		// if(i>50 && i<=75) {
		// 	direction = "left";		
		// 	}
		// if(i>75 && i<=100) {
		// 	direction = "up";		
		// 	}
		// actionLockCounter =0;
		//  }
		
		
	}      
	
	public void speak(){
		super.speak();

	}
	
	

}
