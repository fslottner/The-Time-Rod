package idunnoderp;

import java.awt.Color;
import java.awt.Graphics;

public class FloorTile extends Tile {

	public FloorTile(int x, int y, int l, ID id) {
		super(x, y, l, id);
	}

	public void tickRT() {

	}

	public void tickAction() {

	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(100 * x, 100 * y, 100, 100);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(100 * x, 100 * y, 100, 100);
	}

}
