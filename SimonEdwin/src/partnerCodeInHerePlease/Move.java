package partnerCodeInHerePlease;

import simon.ButtonInterfaceEdwin;
import simon.MoveInterfaceEdwin;

public class Move implements MoveInterfaceEdwin {

	private ButtonInterfaceEdwin button;

	public Move(ButtonInterfaceEdwin move) {
		this.button = move;
	}

	public ButtonInterfaceEdwin getButton() {
		return button;
	}

}
