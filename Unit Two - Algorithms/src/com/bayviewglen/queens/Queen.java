package com.bayviewglen.queens;

public class Queen {

	private int row;
	private int column;

	// --- constructors ---

	public Queen() {
		super();
		this.row = 0;
		this.column = 0;
	}

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	// --- Row ---

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	// --- Column ---

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	// --- compareTo method ---

	// not useful
	public int compareTo(int row, int column) {

		return -1;
	}

	// --- get delta x of queen from (0,0) ---
	public int getDeltaX(Queen q) {
		int x1 = 0;
		int x2 = q.getColumn();

		int deltaX = Math.abs(x2 - x1);

		return deltaX;
	}

	// --- get delta y of queen from (0,0) ---
	public int getDeltaY(Queen q) {
		int y1 = 0;
		int y2 = q.getRow();

		int deltaY = Math.abs(y2 - y1);

		return deltaY;
	}

}
