package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.image.BufferedImage;

import gui6.components.Action;
import simon.ButtonInterfaceEdwin;

public class Button implements ButtonInterfaceEdwin {

	private Color color;
	private Color displayColor;
	private Action action;
	
	public Button() {
	}

	public void act() {
		action.act();
	}

	public boolean isHovered(int arg0, int arg1) {
		return false;
	}

	public int getHeight() {
		return 0;
	}

	public BufferedImage getImage() {
		return null;
	}

	public int getWidth() {
		return 0;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	public boolean isAnimated() {
		return false;
	}

	public void update() {
		
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
		
	}

	public void dim() {
		
	}
}
