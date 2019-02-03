package com.mazegame;

/**
 * Class that contains the properties for the game
 *
 */
public class Game extends AndroidGame {
	//width and height of the whole maze and width of lines which
	//make the walls
	private int width, height, lineWidth;
	//size of the maze i.e. number of cells in it
	private int mazeSizeX, mazeSizeY;
	//width and height of cells in the maze
	private float cellWidth, cellHeight;
	//the following store result of cellWidth+lineWidth 
	//and cellHeight+lineWidth respectively 
	private float totalCellWidth, totalCellHeight;
	//the finishing point of the maze
	private int mazeFinishX, mazeFinishY;
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the lineWidth
	 */
	public int getLineWidth() {
		return lineWidth;
	}
	/**
	 * @param lineWidth the lineWidth to set
	 */
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
	/**
	 * @return the mazeSizeX
	 */
	public int getMazeSizeX() {
		return mazeSizeX;
	}
	/**
	 * @param mazeSizeX the mazeSizeX to set
	 */
	public void setMazeSizeX(int mazeSizeX) {
		this.mazeSizeX = mazeSizeX;
	}
	/**
	 * @return the mazeSizeY
	 */
	public int getMazeSizeY() {
		return mazeSizeY;
	}
	/**
	 * @param mazeSizeY the mazeSizeY to set
	 */
	public void setMazeSizeY(int mazeSizeY) {
		this.mazeSizeY = mazeSizeY;
	}
	/**
	 * @return the cellWidth
	 */
	public float getCellWidth() {
		return cellWidth;
	}
	/**
	 * @param cellWidth the cellWidth to set
	 */
	public void setCellWidth(float cellWidth) {
		this.cellWidth = cellWidth;
	}
	/**
	 * @return the cellHeight
	 */
	public float getCellHeight() {
		return cellHeight;
	}
	/**
	 * @param cellHeight the cellHeight to set
	 */
	public void setCellHeight(float cellHeight) {
		this.cellHeight = cellHeight;
	}
	/**
	 * @return the totalCellWidth
	 */
	public float getTotalCellWidth() {
		return totalCellWidth;
	}
	/**
	 * @param totalCellWidth the totalCellWidth to set
	 */
	public void setTotalCellWidth(float totalCellWidth) {
		this.totalCellWidth = totalCellWidth;
	}
	/**
	 * @return the totalCellHeight
	 */
	public float getTotalCellHeight() {
		return totalCellHeight;
	}
	/**
	 * @param totalCellHeight the totalCellHeight to set
	 */
	public void setTotalCellHeight(float totalCellHeight) {
		this.totalCellHeight = totalCellHeight;
	}
	/**
	 * @return the mazeFinishX
	 */
	public int getMazeFinishX() {
		return mazeFinishX;
	}
	/**
	 * @param mazeFinishX the mazeFinishX to set
	 */
	public void setMazeFinishX(int mazeFinishX) {
		this.mazeFinishX = mazeFinishX;
	}
	/**
	 * @return the mazeFinishY
	 */
	public int getMazeFinishY() {
		return mazeFinishY;
	}
	/**
	 * @param mazeFinishY the mazeFinishY to set
	 */
	public void setMazeFinishY(int mazeFinishY) {
		this.mazeFinishY = mazeFinishY;
	}
	


}
