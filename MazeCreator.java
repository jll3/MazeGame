package com.mazegame;

public class MazeCreator {

	/**
	 * The method is used to setup a maze based on the level. A maze consists of
	 * vertical and horizontal arrays. A true indicates a line, a false
	 * indicates no line
	 * This method also sets the start and end point, i.e. the football and goals
	 * @param mazeNo
	 * @return
	 */
	public static Maze getMaze(int mazeNo) {
		Maze maze = null;

		if (mazeNo == 1) {
			maze = new Maze();
			boolean[][] vLines = new boolean[][] {
					{ true, false, false, false },
					{ false, true, false, false },
					{ false, true, false, false }, { true, false, false, true } };
			boolean[][] hLines = new boolean[][] {
					{ false, false, true, false }, { true, true, false, true },
					{ false, false, true, false },
					{ false, true, false, false } };
			maze.setVerticalLines(vLines);
			maze.setHorizontalLines(hLines);
			maze.setFinalPosition(0, 0);
			maze.setStartPosition(0, 3);
		}
		if (mazeNo == 4) {
			maze = new Maze();
			boolean[][] vLines = new boolean[][] {
					{ true, false, false, false, true, false, false },
					{ true, false, false, true, false, true, true },
					{ false, true, false, false, true, false, false },
					{ false, true, true, false, false, false, true },
					{ true, false, false, false, true, true, false },
					{ false, true, false, false, true, false, false },
					{ false, true, true, true, true, true, false },
					{ false, false, false, true, false, false, false } };
			boolean[][] hLines = new boolean[][] {
					{ false, false, true, true, false, false, true, false },
					{ false, false, true, true, false, true, false, false },
					{ true, true, false, true, true, false, true, true },
					{ false, false, true, false, true, true, false, false },
					{ false, true, true, true, true, false, true, true },
					{ true, false, false, true, false, false, true, false },
					{ false, true, false, false, false, true, false, true } };
			maze.setVerticalLines(vLines);
			maze.setHorizontalLines(hLines);
			maze.setStartPosition(0, 0);
			maze.setFinalPosition(7, 7);
		}
		if (mazeNo == 2) {
			maze = new Maze();
			boolean[][] vLines = new boolean[][] {
					{ false, false, false, false, false, false, false },
					{ true, true, false, false, false, false, true },
					{ true, true, false, false, false, true, true },
					{ true, true, true, false, true, true, true },
					{ true, true, true, false, false, true, true },
					{ true, true, false, false, false, false, false },
					{ true, false, false, false, false, false, true },
					{ false, false, false, false, false, false, true } };
			boolean[][] hLines = new boolean[][] {
					{ false, true, true, true, true, true, false, false },
					{ false, false, true, true, true, true, false, false },
					{ false, false, false, true, true, false, false, false },
					{ false, false, false, false, true, false, false, false },
					{ false, false, false, true, true, true, false, false },
					{ false, false, true, true, true, true, false, false },
					{ false, true, true, true, true, true, false, false } };
			maze.setVerticalLines(vLines);
			maze.setHorizontalLines(hLines);
			maze.setStartPosition(0, 7);
			maze.setFinalPosition(4, 3);
		}
		if (mazeNo == 3) {
			maze = new Maze();
			boolean[][] vLines = new boolean[][] {
					{ false, false, false, false, false, true },
					{ true, false, false, true, true, true },
					{ true, false, true, false, true, false },
					{ false, false, true, false, false, true },
					{ false, true, true, true, false, true },
					{ false, true, false, false, true, true } };
			boolean[][] hLines = new boolean[][] {
					{ false, true, true, true, false, false },
					{ false, true, true, false, false, false },
					{ false, true, false, true, true, false },
					{ false, true, false, false, true, true },
					{ true, false, true, false, false, false },
					{ true, false, false, true, true, true } };
			maze.setVerticalLines(vLines);
			maze.setHorizontalLines(hLines);
			maze.setStartPosition(0, 5);
			maze.setFinalPosition(5, 5);
		}

		if (mazeNo == 5) {
			maze = new Maze();
			boolean[][] vLines = new boolean[][] {
					{ false, true, false, false, false, false, false, true,
							false, false, false, true },
					{ true, true, false, true, false, true, false, true, true,
							true, false, false },
					{ true, false, true, true, false, true, true, false, true,
							false, false, true },
					{ true, true, true, false, true, true, true, true, false,
							false, false, true },
					{ true, true, true, false, true, true, false, false, true,
							false, false, true },
					{ true, true, true, true, true, true, true, false, false,
							true, false, true },
					{ true, false, false, true, false, true, true, true, true,
							false, false, true },
					{ true, false, true, true, false, false, false, true,
							false, false, true, true },
					{ true, false, true, true, true, false, false, false,
							false, true, true, true },
					{ true, false, true, true, true, false, false, false, true,
							false, false, false },// up to here
					{ true, true, true, true, true, false, true, false, true,
							false, false, false },
					{ false, true, false, false, false, false, false, false,
							false, false, true, false } };// last column is the
															// outer vertical
															// one
			boolean[][] hLines = new boolean[][] {
					{ false, false, false, true, true, false, true, false,
							false, false, true, false },
					{ false, false, true, false, false, true, false, true,
							false, false, true, true },
					{ false, true, false, false, true, false, false, false,
							true, true, true, false },
					{ false, false, false, true, true, false, false, true,
							false, true, true, false },
					{ false, false, false, false, false, false, false, true,
							true, true, false, true },
					{ false, false, false, false, false, false, false, false,
							true, false, true, true },
					{ false, false, false, false, true, true, true, false,
							false, true, true, false },
					{ false, true, true, false, false, true, true, true, true,
							false, false, false },
					{ false, false, false, false, false, false, true, true,
							true, true, true, false },
					{ false, false, false, false, false, false, true, false,
							false, false, true, true },
					{ false, false, false, true, false, true, true, false,
							true, true, true, false },
					{ false, true, false, false, false, true, false, true,
							true, true, true } };
			maze.setVerticalLines(vLines);
			maze.setHorizontalLines(hLines);
			maze.setStartPosition(11, 1);
			maze.setFinalPosition(11, 11);
		}
		return maze;
	}
}
