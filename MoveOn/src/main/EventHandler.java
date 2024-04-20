package main;


public class EventHandler {
	
	GamePanel gp;
	EventRect eventRect[][];

	int previousEventX, previousEventY;
	boolean canTouchEvent = true;

	public EventHandler(GamePanel gp) {
		this.gp = gp;
		eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
		int col=0;
		int row=0;
		while(col<gp.maxWorldCol&& row<gp.maxWorldRow){
			eventRect[col][row] = new EventRect();
			eventRect[col][row].x = 23;
			eventRect[col][row].y = 23;
			eventRect[col][row].width = 2;
			eventRect[col][row].height =2;
			eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
			eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
			col++;
			if(col==gp.maxWorldCol){
				col=0;
				row++;
			}

		}
		
		
	}
	
	public void checkEvent() {

		// check player distance from last event
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance>gp.tileSize){
			canTouchEvent = true;
		}
		if(canTouchEvent){
			if(hit(27,16,"right")) {
				damagePit(27,16,gp.dialougeState);
			}
			if(hit(23,19,"any")) {
				damagePit(23,19,gp.dialougeState);
			}
			if(hit(23,12,"up")) {
				healingPool(23,12,gp.dialougeState);
			}
		}
		
	}
	
	public boolean hit(int col, int row, String reqDirection) {
		boolean hit = Boolean.FALSE;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
		eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;
		
		if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
			if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
				hit = Boolean.TRUE;

				previousEventX = gp.player.worldX;
				previousEventY=gp.player.worldY;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
		eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
		
		
		return hit;
	}
	
	public void damagePit(int col, int row,int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "You fall into a pit!";
		gp.player.life -= 1;
		// eventRect[col][row].eventDone = true;
		canTouchEvent=false;
	}
	
	public void healingPool(int col, int row,int gameState) {
		if(gp.keyHandler.enterPressed) {
			gp.gameState = gameState;
			gp.ui.currentDialogue = "You are Healed";
			gp.player.life = gp.player.maxLife;
		}
		
	}
}
