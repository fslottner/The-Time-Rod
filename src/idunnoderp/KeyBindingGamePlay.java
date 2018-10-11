package idunnoderp;

import java.awt.event.KeyEvent;

public class KeyBindingGamePlay extends KeyBinding {

	private Handler handler;
	private Player player;
	
	public KeyBindingGamePlay(Player player, Handler  handler) {
		this.handler  = handler;
		this.player = player;
	}
	
	public void keyPressed(int key) {
		switch (key) {
		case KeyEvent.VK_UP:
			player.moveY(-1);
			break;
		
		case KeyEvent.VK_DOWN:
			player.moveY(1);
			break;
			
		case KeyEvent.VK_LEFT:
			player.moveX(-1);
			break;
			
		case KeyEvent.VK_RIGHT:
			player.moveX(1);
			break;
		
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
		}
		
	}

	public void keyReleased(int key) {

	}

	public void keyTyped(int key) {

	}

}
