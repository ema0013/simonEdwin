package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

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
		update();
	}

	@Override
	public void act() {
		action.act();

	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt((Math.pow(x-(getX()+WIDTH/2), 2)+Math.pow(y-(getY()+HEIGHT/2), 2)));
		return distance < WIDTH/2;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public void setAction(Action a) {
		this.action = a;

	}

	@Override
	public void highlight() {
		if(color!= null){
			displayColor = color;
			highlight = true;
			update();
		}

	}

	@Override
	public void dim() {
		displayColor = Color.black;
		highlight = false;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor!=null){
			g.setColor(displayColor);
		}else{
			g.setColor(Color.black);
		}
		g.fillOval(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, WIDTH-1, HEIGHT-1);
	}
}
