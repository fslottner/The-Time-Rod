package idunnoderp;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, int l, ID id, Handler handler) {
		super(x, y, l, id);
	}

	public void tickRT() {

	}

	public void tickAction() {

	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(100 * x, 100 * y, 100, 100);
	}

}
