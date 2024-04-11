package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	//Debug
	boolean checkDrawtime = Boolean.FALSE;
	
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W 
				|| code == KeyEvent.VK_UP) {
			upPressed = Boolean.TRUE;
		}
		if(code == KeyEvent.VK_S
				|| code == KeyEvent.VK_DOWN) {
			downPressed = Boolean.TRUE;		
		}
		if(code == KeyEvent.VK_A
				|| code == KeyEvent.VK_LEFT) {
			leftPressed = Boolean.TRUE;
		}
		if(code == KeyEvent.VK_D
				|| code == KeyEvent.VK_RIGHT) {
			rightPressed = Boolean.TRUE;
		}
		
		if(code == KeyEvent.VK_P) {
			if(gp.gameState == gp.playState) {
				gp.gameState= gp.pauseState;
			}
			else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
			}
		}
		
		
		if(code == KeyEvent.VK_T) {
			if(!checkDrawtime) {
				checkDrawtime = Boolean.TRUE;
			}else {
				checkDrawtime = Boolean.FALSE;
			}
		}
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W
				|| code == KeyEvent.VK_UP) {
			upPressed = Boolean.FALSE;
		}
		if(code == KeyEvent.VK_S
				|| code == KeyEvent.VK_DOWN) {
			downPressed = Boolean.FALSE;		
		}
		if(code == KeyEvent.VK_A
				|| code == KeyEvent.VK_LEFT) {
			leftPressed = Boolean.FALSE;
		}
		if(code == KeyEvent.VK_D
				|| code == KeyEvent.VK_RIGHT) {
			rightPressed = Boolean.FALSE;
		}
		
	}

}
