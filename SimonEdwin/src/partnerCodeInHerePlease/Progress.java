package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gui6.components.Component;
import simon.ProgressInterfaceEdwin;

public class Progress extends Component implements ProgressInterfaceEdwin {

	private static final int WIDTH = 200;
	private static final int HEIGHT = 100;
	private boolean gameOver;
	private int roundNumber;
	private int sequenceSize;

	public Progress() {
		super(100, 100, WIDTH, HEIGHT);
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}

	public void setRound(int i) {
		roundNumber = i;
		update();
	}

	public void setSequenceSize(int i) {
		sequenceSize = i;
		update();
	}
	
	public void gameOver(){
		gameOver = true;
		update();
	}

	public void update(Graphics2D g) {
		if(gameOver){
			String gameStatus = "GAME OVER";
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.WHITE);
			g.drawString(gameStatus, (WIDTH/2), 50);
			g.drawString("You got up to Round " + roundNumber + " with a sequence size of " + sequenceSize, (WIDTH/2), 70);
		}else{
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.red);
			g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
			if(roundNumber > 0 && sequenceSize > 0){
				g.drawString("Round: " + roundNumber, (WIDTH/2), 50);
				g.drawString("Sequence Size: " + sequenceSize, (WIDTH/2), 70);
			}
		}
	}

}
