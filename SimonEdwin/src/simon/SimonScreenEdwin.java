package simon;

import java.awt.Color;
import java.util.ArrayList;

import gui6.components.Action;
import gui6.components.TextLabel;
import gui6.components.Visible;
import gui6.screens.ClickableScreen;

public class SimonScreenEdwin extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceEdwin[] buttons;
	private ProgressInterfaceEdwin progress;
	private ArrayList<MoveInterfaceEdwin> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenEdwin(int width,int height) {
		super(width,height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceEdwin b = null;
		for(int i = 0; i < sequence.size();i++){
			if(b!=null){
				b.dim();
				b = sequence.get(i).getButton();
				int sleepTime =(3000*(3/(roundNumber+3)));
				try{
					Thread.sleep(sleepTime);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		b.dim();
		
	}

	private void changeText(String s) {
		label.setText(s);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceEdwin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}
	private MoveInterfaceEdwin randomMove() {
		int randomButton = (int)(Math.random()*buttons.length);
		while(randomButton==lastSelectedButton){
			randomButton = (int)(Math.random()*buttons.length);
		}
		lastSelectedButton = randomButton;
		return getMove(buttons[randomButton]);
	}

	private MoveInterfaceEdwin getMove(ButtonInterfaceEdwin move) {
		// TODO Auto-generated method stub
		return new partnerCodeInHerePlease.Move(move);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceEdwin getProgress() {
		// TODO Auto-generated method stub
		return new partnerCodeInHerePlease.Progress();
	}

	private void addButtons() {
		int numberOfButtons = 6;
		Color[] buttonColors = {Color.CYAN,Color.DARK_GRAY,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.YELLOW};
		buttons = new ButtonInterfaceEdwin[numberOfButtons];
		for(int i = 0; i < buttonColors.length;i++){
			buttons[i].setColor(buttonColors[i]);
			buttons[i].setX((150*i)+50);
			buttons[i].setY(290);//
			final ButtonInterfaceEdwin b = buttons[i];
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						
						blink.start();
						if(b==sequence.get(sequenceIndex).getButton()){
							sequenceIndex++;
							
						}
						else{
							progress.gameOver();
							return;
						}
						if(sequenceIndex==sequence.size()){
							Thread nextRound = new Thread(SimonScreenEdwin.this);
							nextRound.start();
						}
						
					}
				}
			});
			viewObjects.add(b);
		}
	}

	private ButtonInterfaceEdwin getAButton() {
		// TODO Auto-generated method stub
		return new partnerCodeInHerePlease.Button();
		//
	}

}
