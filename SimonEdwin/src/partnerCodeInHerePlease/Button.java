package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import gui6.components.Action;
import gui6.components.Component;
import simon.ButtonInterfaceEdwin;

public class Button extends Component implements ButtonInterfaceEdwin {

	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	private Color color;
	private Color displayColor;
	private Action action;
	
	public Button() {
		super(0, 0, WIDTH, HEIGHT);
		update();
	}

	public void act() {
		action.act();
	}

	public boolean isHovered(int arg0, int arg1) {
		double distance = Math.sqrt((Math.pow(x-(getX()+WIDTH/2), 2)+Math.pow(y-(getY()+HEIGHT/2), 2)));
		return distance < WIDTH/2;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}

	public void setColor(Color color) {
		this.color = color;
		displayColor = color;
		update();
	}

	public void setAction(Action a) {
		this.action = a;
	}

	public void dim() {
		displayColor = Color.BLACK;
		update();
	}

	public void update(Graphics2D g) {
		if(displayColor != null){
			g.setColor(displayColor);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillOval(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, WIDTH-1, HEIGHT-1);
	}
}
