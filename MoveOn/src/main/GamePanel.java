 package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	final int originalTileSize = 16;
	final int scale =3;
	
	public final int tileSize = originalTileSize * scale; // 48 * 48
	
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	//Game assets
	TileManager tileM = new TileManager(this);
	KeyHandler keyHandler = new KeyHandler(this);
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	Sound music = new Sound();
	Sound soundEffects = new Sound();
	public UI ui = new UI(this);
	
	
	
	//Movable and Immovable Objects
	public Player player = new Player(this,keyHandler);
	public SuperObject[] obj = new SuperObject[10];
	
	static final int FPS = 60;
	
	
	//GAME STATE
	public int gameState;
	//TODO : Implement enum for this constants later, for readability
	public final int playState = 1;
	public final int pauseState =2;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void setupGame(){
		
		aSetter.setObject();
//		playMusic(0);
//		stopMusic();
		gameState = playState;
	}
	
	public void startGamethread() {
		gameThread = new Thread(this);
		gameThread.start();
	}


	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS; // draw 60 times per second
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer =0;
		long drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta>=1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
			
		}
	}
	
	public void update() {
		
		if(gameState == playState) {
			player.update();
		}
		if(gameState == pauseState) {
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//For debugging purpose
		long drawStart = 0;
		if(keyHandler.checkDrawtime) {
			drawStart = System.nanoTime();
		}
				
		tileM.draw(g2);

		for(int i=0; i<obj.length;i++){
			if(obj[i]!=null){
				obj[i].draw(g2,this);
			}
		}
		player.draw(g2);
		
		ui.draw(g2);
		
		if(keyHandler.checkDrawtime) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time:" + passed, 10, 400);
			System.out.println("Draw Time : " + passed);
		}
		
		
		g2.dispose();
		
	}
	
	public void playMusic(int musicFileNum) {
		music.setFile(musicFileNum);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	//playSE
	public void playSoundEffect(int musicFileNum) {
		soundEffects.setFile(musicFileNum);
		soundEffects.play();
	}

}
