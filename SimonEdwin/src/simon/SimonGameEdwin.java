package simon;

import gui6.GUIApplication;

public class SimonGameEdwin extends GUIApplication {

	public SimonGameEdwin(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenEdwin sse = new SimonScreenEdwin(getWidth(),getHeight());
		setScreen(sse);

	}

	public static void main(String[] args) {
		SimonGameEdwin sge = new SimonGameEdwin(700,600);
		Thread game = new Thread(sge);
		game.start();

	}

}
