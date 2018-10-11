package idunnoderp;

import java.awt.Graphics;

public abstract class Tile extends GameObject {

	public Tile(int x, int y, int l, ID id) {
		super(x, y, l, id);
	}

	public abstract void tickRT();

	public abstract void tickAction();

	public abstract void render(Graphics g);

}
