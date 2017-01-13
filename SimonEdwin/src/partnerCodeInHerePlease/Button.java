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
	private boolean highlight;
	
	public Button() {
		super(0, 0, WIDTH, HEIGHT);
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

	public BufferedImage getImage() {
		return null;
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

	public void highlight() {
		if(color != null){
			displayColor = color;
		}
		highlight = true;
		update();
	}

	public void dim() {
		displayColor = Color.BLACK;
		highlight = false;
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
		if(highlight){
			g.setColor(Color.white);
			Polygon p = new Polygon();
			
			int s = (int)(5/8.0 * WIDTH);
			int t = (int)(1.0/5*HEIGHT)+4;
			p.addPoint(s-4, t-4);
			p.addPoint(s+7, t-2);
			p.addPoint(s+10, t);
			p.addPoint(s+14, t+10);
			p.addPoint(s+12, t+14);
			p.addPoint(s+8, t+3);
			g.fill(p);
		}
	}
}
