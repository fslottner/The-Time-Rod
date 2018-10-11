package idunnoderp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BasicEnemy extends GameObject {

	Handler handler;
	Random r = new Random();

	int actionCounter = 0;

	GameObject target;

	public BasicEnemy(int x, int y, int layer, ID id, Handler handler) {
		super(x, y, layer, id);
		this.handler = handler;
	}

	public void setTarget(GameObject target) {
		this.target = target;
	}

	private void brain() {
		if (actionCounter >= 100) {
			actionCounter = 0;
			if (target == null) {

			} else {

				int dx = this.getX() - target.getX();
				int dy = this.getY() - target.getY();
				if (dx == 0 || dy == 0) {
					moveX(-Integer.signum(dx));
					moveY(-Integer.signum(dy));
				} else {

					double dir = Math.atan(dy / dx) / (Math.PI / 2);
					
					System.out.println("dy:" + dy);
					System.out.println("dx:" + dx);
					System.out.println("dir:" + dir);
					
					if (dir > 0.5) {
						if (r.nextDouble() > dir) {
							moveY(-Integer.signum(dy));
						} else {
							moveX(-Integer.signum(dx));
							moveY(-Integer.signum(dy));
						}
					} else {
						if (r.nextDouble() < dir) {
							moveX(-Integer.signum(dx));
						} else {
							moveX(-Integer.signum(dy));
							moveY(-Integer.signum(dy));

						}
					}

					
				}

			}

		} else {
			actionCounter += 1;
		}

	}

	@Override
	public void tickRT() {
		brain();
	}

	@Override
	public void tickAction() {
		// TODO Auto-generated method stub

	}

	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(100 * x, 100 * y, 100, 100);
	}

}
