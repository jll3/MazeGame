package com.mazegame;

import java.io.Serializable;

/**
 * Class that represents the Maze
 *
 */

public class Maze implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;

	private boolean[][] verticalLines;
	private boolean[][] horizontalLines;
	private int sizeX, sizeY; // stores the width and height of the maze
	private int currentX, currentY; // stores the current location of the ball
	private int finalX, finalY; // stores the finishing of the maze
	private boolean gameComplete;

	/**
	 * Get maze Width
	 * 
	 * @return
	 */
	public int getMazeWidth() {
		return sizeX;
	}

	/**
	 * Get maze height
	 * 
	 * @return
	 */
	public int getMazeHeight() {
		return sizeY;
	}

	/**
	 * Method to move the ball around the maze depending on whether they press
	 * up, down, right and left
	 * 
	 * @param direction
	 * @return
	 */
	public boolean move(int direction) {
		boolean moved = false;
		if (direction == UP) {
			if (currentY != 0 && !horizontalLines[currentY - 1][currentX]) {
				currentY--;
				moved = true;
			}
		}
		if (direction == DOWN) {
			if (currentY != sizeY - 1 && !horizontalLines[currentY][currentX]) {
				currentY++;
				moved = true;
			}
		}
		if (direction == RIGHT) {
			if (currentX != sizeX - 1 && !verticalLines[currentY][currentX]) {
				currentX++;
				moved = true;
			}
		}
		if (direction == LEFT) {
			if (currentX != 0 && !verticalLines[currentY][currentX - 1]) {
				currentX--;
				moved = true;
			}
		}
		if (moved) {
			if (currentX == finalX && currentY == finalY) {
				gameComplete = true;
			}
		}
		return moved;
	}

	/**
	 * Method to return the game if the game is completed
	 * 
	 * @return
	 */
	public boolean isGameComplete() {
		return gameComplete;
	}

	/**
	 * Method to set the start positin
	 * 
	 * @param x
	 * @param y
	 */
	public void setStartPosition(int x, int y) {
		currentX = x;
		currentY = y;
	}

	/**
	 * get the end x position
	 * 
	 * @return
	 */
	public int getFinalX() {
		return finalX;
	}

	/**
	 * get the end y position
	 * 
	 * @return
	 */
	public int getFinalY() {
		return finalY;
	}

	/**
	 * Sets the final position
	 * 
	 * @param x
	 * @param y
	 */
	public void setFinalPosition(int x, int y) {
		finalX = x;
		finalY = y;
	}

	/**
	 * Gets the current X position
	 * 
	 * @return
	 */
	public int getCurrentX() {
		return currentX;
	}

	/**
	 * Gets the current Y position
	 * 
	 * @return
	 */
	public int getCurrentY() {
		return currentY;
	}

	/**
	 * Gets a boolean 2D array of Horizontal lines
	 * 
	 * @return
	 */
	public boolean[][] getHorizontalLines() {
		return horizontalLines;
	}

	/**
	 * Sets a boolean 2D array of Horizontal lines
	 * 
	 * @param
	 */
	public void setHorizontalLines(boolean[][] lines) {
		horizontalLines = lines;
		sizeX = horizontalLines[0].length;
	}

	/**
	 * Gets a boolean 2D array of Vertical lines
	 * 
	 * @return
	 */
	public boolean[][] getVerticalLines() {
		return verticalLines;
	}

	/**
	 * Sets a boolean 2D array of Veritcal lines
	 * 
	 * @param
	 */
	public void setVerticalLines(boolean[][] lines) {
		verticalLines = lines;
		sizeY = verticalLines.length;
	}
}
