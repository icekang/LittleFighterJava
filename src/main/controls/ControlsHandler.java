package main.controls;

import main.SceneManager;
import main.menu.MenuComponent;

public class ControlsHandler {
	
	public static void moveToMenuScene() {
		ControlsComponent.getInstance().stopSound();
		ControlsComponent.getInstance().startTransitionSound();
		MenuComponent.getInstance().playSound();
		SceneManager.setMenuScene();
	}
}
