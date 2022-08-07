package ninjase.model;

import java.awt.Color;

public class Obstacle {
	Coordinate location;
	Color color;
	
	public Obstacle(Color color, Coordinate location) {
		this.location = location;
		this.color = color;
	}
	
	public void setRow(int row) {
		Coordinate newCoor;
		newCoor = new Coordinate(row, this.location.col);
		this.location = newCoor;
	}
	
	public void setCol(int col) {
		Coordinate newCoor;
		newCoor = new Coordinate(this.location.row, col);
		this.location = newCoor;
	}

	public int getCol() {
		return this.location.col; 
	}
	
	public int getRow() {
		return this.location.row;
	}

	public Color getColor() {
		return this.color;
	}
	
	public void moveUp() {
		this.setRow(this.getRow() - 1);
	}
	
	public void moveDown() {
		this.setRow(this.getRow() + 1);
	}
	
	public void moveLeft() {
		this.setCol(this.getCol() - 1);
	}
	
	public void moveRight() {
		this.setCol(this.getCol() + 1);
	}
	
	public boolean contains(Coordinate c) {
		if(this.location == c) {
			return true;
		}
		
		return false;
	}
}
