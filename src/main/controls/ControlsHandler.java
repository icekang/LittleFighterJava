package main.controls;

import main.SceneManager;

public class ControlsHandler {
	
	public static void moveToMenuScene() {
		ControlsComponent.getInstance().stopSound();
		ControlsComponent.getInstance().startTransitionSound();
		SceneManager.setMenuScene();
	}
}
