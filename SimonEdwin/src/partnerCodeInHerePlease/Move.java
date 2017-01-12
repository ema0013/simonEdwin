package partnerCodeInHerePlease;

import simon.ButtonInterfaceEdwin;
import simon.MoveInterfaceEdwin;

public class Move implements MoveInterfaceEdwin {

	private ButtonInterfaceEdwin button;

	public Move(ButtonInterfaceEdwin move) {
		this.button = button;
	}

	public ButtonInterfaceEdwin getButton() {
		return button;
	}

}
