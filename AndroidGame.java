package com.mazegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * Class to set up the actual game
 *
 */
public class AndroidGame extends Activity{
	
	/**
	 * Overridden onCreate method to create the game
	 */
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Maze maze = (Maze)extras.get("maze");
		GameView view = new GameView(this,maze);
		setContentView(view);
	}
}
