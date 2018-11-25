package entity.control;

import javafx.scene.input.KeyCode;

public class Control {
	public static KeyCode moveUpPlayer1 = KeyCode.W;
	public static KeyCode moveDownPlayer1 = KeyCode.S;
	public static KeyCode moveLeftPlayer1 = KeyCode.A;
	public static KeyCode moveRightPlayer1 = KeyCode.D;
	public static KeyCode attackPlayer1 = KeyCode.J;
	public static KeyCode jumpPlayer1 = KeyCode.K;
	
	public static KeyCode moveUpPlayer2 = KeyCode.UP;
	public static KeyCode moveDownPlayer2 = KeyCode.DOWN;
	public static KeyCode moveLeftPlayer2 = KeyCode.LEFT;
	public static KeyCode moveRightPlayer2 = KeyCode.RIGHT;
	public static KeyCode attackPlayer2 = KeyCode.DIGIT5;
	public static KeyCode jumpPlayer2 = KeyCode.DIGIT9;
	
	public static String toString(KeyCode keyCode) {
		String keyName = keyCode.toString();
		return keyName;
	}

	public static void setMoveUpPlayer1(KeyCode moveUpPlayer1) {
		Control.moveUpPlayer1 = moveUpPlayer1;
	}

	public static void setMoveDownPlayer1(KeyCode moveDownPlayer1) {
		Control.moveDownPlayer1 = moveDownPlayer1;
	}

	public static void setMoveLeftPlayer1(KeyCode moveLeftPlayer1) {
		Control.moveLeftPlayer1 = moveLeftPlayer1;
	}

	public static void setMoveRightPlayer1(KeyCode moveRightPlayer1) {
		Control.moveRightPlayer1 = moveRightPlayer1;
	}

	public static void setAttackPlayer1(KeyCode attackPlayer1) {
		Control.attackPlayer1 = attackPlayer1;
	}

	public static void setJumpPlayer1(KeyCode jumpPlayer1) {
		Control.jumpPlayer1 = jumpPlayer1;
	}

	public static void setMoveUpPlayer2(KeyCode moveUpPlayer2) {
		Control.moveUpPlayer2 = moveUpPlayer2;
	}

	public static void setMoveDownPlayer2(KeyCode moveDownPlayer2) {
		Control.moveDownPlayer2 = moveDownPlayer2;
	}

	public static void setMoveLeftPlayer2(KeyCode moveLeftPlayer2) {
		Control.moveLeftPlayer2 = moveLeftPlayer2;
	}

	public static void setMoveRightPlayer2(KeyCode moveRightPlayer2) {
		Control.moveRightPlayer2 = moveRightPlayer2;
	}

	public static void setAttackPlayer2(KeyCode attackPlayer2) {
		Control.attackPlayer2 = attackPlayer2;
	}

	public static void setJumpPlayer2(KeyCode jumpPlayer2) {
		Control.jumpPlayer2 = jumpPlayer2;
	}
}
