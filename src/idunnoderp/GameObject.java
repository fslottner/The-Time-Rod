package idunnoderp;

import java.awt.Graphics; 

public abstract class GameObject {
	
	protected int x, y, layer;
	protected ID id;
	
	public GameObject(int x, int y, int layer, ID id) {
		this.x = x;
		this.y = y;
		this.layer = layer;
		this.id = id;
	}
	
	public void moveX(int d) {
		x += d;
	}
	
	public void moveY(int d) {
		y += d;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLayer() {
		return layer;
	}
	
	public ID getID() {
		return id;
	}

	public abstract void tickRT();
	
	public abstract void tickAction();
	
	public abstract void render(Graphics g);
	
}
