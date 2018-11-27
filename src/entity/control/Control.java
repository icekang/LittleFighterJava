package entity.control;

import javafx.scene.input.KeyCode;

public class Control {
	public static KeyCode[][] allkey = new KeyCode[][]{{KeyCode.W,KeyCode.S,KeyCode.A,KeyCode.D,KeyCode.Z,KeyCode.X,KeyCode.C,KeyCode.V},{KeyCode.UP,KeyCode.DOWN,KeyCode.LEFT,KeyCode.RIGHT,KeyCode.CONTROL,KeyCode.SHIFT,KeyCode.ENTER,KeyCode.BACK_SLASH}};
	public static int UP=0;
	public static int DOWN=1;
	public static int LEFT=2;
	public static int RIGHT=3;
	public static int BLOCK=4;
	public static int JUMP=5;
	public static int ATTACK=6;
	public static int ACTIVATE=7;
	public static int SETTING_PLAYER=-1;
	public static int SETTING_KEY=-1;
}
