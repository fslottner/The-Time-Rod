package idunnoderp;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	ArrayList<GameObject> objects = new ArrayList<GameObject>();

	public void tickRT() {
		for (GameObject object : objects) {
			object.tickRT();
		}
	}

	public void tickAction() {
		for (GameObject object : objects) {
			object.tickAction();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < 10; i++)
			for (GameObject object : objects) {
				if (i == object.getLayer()) {
					object.render(g);
				}
				
			}
		
	}

	public void addObject(GameObject object) {
		objects.add(object);
	}

	public void removeObject(GameObject object) {
		objects.remove(object);
	}

}
