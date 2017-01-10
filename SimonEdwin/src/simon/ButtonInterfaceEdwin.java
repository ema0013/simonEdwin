package simon;

import java.awt.Color;

import gui6.components.Action;
import gui6.components.Clickable;

public interface ButtonInterfaceEdwin extends Clickable {

	void setColor(Color color);

	void setX(int X);

	void setY(int Y);
	
	void setAction(Action a);

	void highlight();

	void dim();

	void gameOver();

}
