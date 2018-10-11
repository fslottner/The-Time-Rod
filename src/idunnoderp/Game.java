package idunnoderp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9091729403409228960L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private KeyInput keyInput;
	private KeyBinding keyBinding;
	
	private Player player;
	
	public Game() {
		
		handler = new Handler();
		
		new Window(WIDTH, HEIGHT, "Posessed", this);
		
		keyInput = new KeyInput();
		
		this.addKeyListener(keyInput);
		
		player = new Player(5, 5, 4, ID.Player, handler);
		
		handler.addObject(player);
		
		handler.addObject(new FloorTile(4, 4, 0, ID.FloorTile));
		handler.addObject(new FloorTile(4, 5, 0, ID.FloorTile));
		handler.addObject(new FloorTile(4, 6, 0, ID.FloorTile));
		handler.addObject(new FloorTile(5, 4, 0, ID.FloorTile));
		handler.addObject(new FloorTile(5, 5, 0, ID.FloorTile));
		handler.addObject(new FloorTile(5, 6, 0, ID.FloorTile));
		handler.addObject(new FloorTile(6, 4, 0, ID.FloorTile));
		handler.addObject(new FloorTile(6, 5, 0, ID.FloorTile));
		handler.addObject(new FloorTile(6, 6, 0, ID.FloorTile));
		
		BasicEnemy enemy =new BasicEnemy(1, 1, 1, ID.Enemy, handler);
		enemy.setTarget(player);

		handler.addObject(enemy);
		
		
		keyBinding = new KeyBindingGamePlay(player, handler);
		keyInput.setKeyBinding(keyBinding);
		
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				//System.out.println("player: " + player.getX() + ", " + player.getY());
				//System.out.println("npc: " + handler.object.get(1).getVelX() + ", " + handler.object.get(1).getVelY());
				frames = 0;

			}
		}
		stop();

	}
	
	private void tick() {
		handler.tickRT();
		handler.tickAction();
		//hud.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
				
		handler.render(g);
		
		//hud.render(g);

		g.dispose();
		bs.show();

	}
	
	public static void main(String[] args) {
		new Game();
	}

}
