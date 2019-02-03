package com.mazegame;

import com.mazegame.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Class to setup the Game View
 *
 */
public class GameView extends View {

	private Maze maze;
	private Game game = new Game();
	private Activity context;
	private Paint line, red, background;

	/**
	 * Constructor to set up the Game View
	 * 
	 * @param context
	 * @param maze
	 */
	public GameView(Context context, Maze maze) {
		super(context);
		this.context = (Activity) context;
		this.maze = maze;
		game.setMazeFinishX(maze.getFinalX());
		game.setMazeFinishY(maze.getFinalY());
		game.setMazeSizeX(maze.getMazeWidth());
		game.setMazeSizeY(maze.getMazeHeight());
		line = new Paint();
		line.setColor(getResources().getColor(R.color.line));
		red = new Paint();
		red.setColor(getResources().getColor(R.color.position));
		background = new Paint();
		background.setColor(getResources().getColor(R.color.game_bg));
		setFocusable(true);
		this.setFocusableInTouchMode(true);
	}

	/**
	 * Method to respond to changes in the screen
	 * 
	 * @param width
	 * @param height
	 * @param old
	 *            Width param old height
	 */
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		game.setWidth((w < h) ? w : h);
		game.setHeight(game.getWidth()); // for now square mazes
		game.setLineWidth(1); // for now 1 pixel wide walls
		game.setCellWidth((game.getWidth() - ((float) game.getMazeSizeX() * game
				.getLineWidth())) / game.getMazeSizeX());
		game.setTotalCellWidth(game.getCellWidth() + game.getLineWidth());
		game.setCellHeight((game.getHeight() - ((float) game.getMazeSizeY() * game
				.getLineWidth())) / game.getMazeSizeY());
		game.setTotalCellHeight(game.getCellHeight() + game.getLineWidth());
		red.setTextSize(game.getCellHeight() * 0.75f);
		super.onSizeChanged(w, h, oldw, oldh);
	}

	/**
	 * Android method to draw the maze / images to the screen
	 * 
	 * @param canvas
	 */
	protected void onDraw(Canvas canvas) {
		// fill in the background
		canvas.drawRect(0, 0, game.getWidth(), game.getHeight(), background);

		boolean[][] hLines = maze.getHorizontalLines();
		boolean[][] vLines = maze.getVerticalLines();
		// iterate over the boolean arrays to draw walls
		for (int i = 0; i < game.getMazeSizeX(); i++) {
			for (int j = 0; j < game.getMazeSizeY(); j++) {
				float x = j * game.getTotalCellWidth();
				float y = i * game.getTotalCellHeight();
				if (j < game.getMazeSizeX() - 1 && vLines[i][j]) {
					// we'll draw a vertical line
					canvas.drawLine(x + game.getCellWidth(), // start X
							y, // start Y
							x + game.getCellWidth(), // stop X
							y + game.getCellHeight(), // stop Y
							line);
				}
				if (i < game.getMazeSizeY() - 1 && hLines[i][j]) {
					// we'll draw a horizontal line
					canvas.drawLine(x, // startX
							y + game.getCellHeight(), // startY
							x + game.getCellWidth(), // stopX
							y + game.getCellHeight(), // stopY
							line);
				}
			}
		}
		int currentX = maze.getCurrentX(), currentY = maze.getCurrentY();
		// draw the ball

		// Depending on the maze size, use different image sizes for the goal /
		// football
		if (game.getMazeSizeX() > 10) {
			Bitmap football = BitmapFactory.decodeResource(getResources(),
					R.drawable.smallfootball);
			canvas.drawBitmap(football, (currentX * game.getTotalCellWidth()),
					(currentY * game.getTotalCellHeight()), red);
		} else {
			Bitmap football = BitmapFactory.decodeResource(getResources(),
					R.drawable.football);
			canvas.drawBitmap(football, (currentX * game.getTotalCellWidth()),
					(currentY * game.getTotalCellHeight()), red);

		}

		if (game.getMazeSizeX() > 10) {
			Bitmap goal = BitmapFactory.decodeResource(getResources(),
					R.drawable.smallgoal);
			canvas.drawBitmap(goal,
					(game.getMazeFinishX() * game.getTotalCellWidth()),
					(game.getMazeFinishY() * game.getTotalCellHeight()), red);

		} else {
			Bitmap goal = BitmapFactory.decodeResource(getResources(),
					R.drawable.goal);
			canvas.drawBitmap(goal,
					(game.getMazeFinishX() * game.getTotalCellWidth()),
					(game.getMazeFinishY() * game.getTotalCellHeight()), red);
		}
	}

	/**
	 * Method to respond to up, down, left and right key events
	 * 
	 * @param keyCode
	 *            - key pressed
	 * @param evt
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent evt) {
		boolean moved = false;
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_UP:
			moved = maze.move(Maze.UP);
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			moved = maze.move(Maze.DOWN);
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			moved = maze.move(Maze.RIGHT);
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			moved = maze.move(Maze.LEFT);
			break;
		default:
			return super.onKeyDown(keyCode, evt);
		}
		if (moved) {
			// the ball was moved so we'll redraw the view
			invalidate();
			if (maze.isGameComplete()) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle(context.getText(R.string.finished_title));
				LayoutInflater inflater = context.getLayoutInflater();
				View view = inflater.inflate(R.layout.finish, null);
				builder.setView(view);
				View closeButton = view.findViewById(R.id.closeGame);
				closeButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View clicked) {
						if (clicked.getId() == R.id.closeGame) {
							context.finish();
						}
					}
				});
				AlertDialog finishDialog = builder.create();
				finishDialog.show();
			}
		}
		return true;
	}
}
