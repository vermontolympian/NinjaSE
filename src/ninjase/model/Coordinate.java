package ninjase.model;

public class Coordinate {
	public int row;
	public int col;
	
	public Coordinate(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Coordinate getLeft() {
		Coordinate left = new Coordinate(this.row, this.col - 1);
		return left;
	}
	
	public Coordinate getRight() {
		Coordinate right = new Coordinate(this.row, this.col + 1);
		return right;
	}
	
	public Coordinate getUp() {
		Coordinate up = new Coordinate(this.row - 1, this.col);
		return up;
	}
	
	public Coordinate getDown(){
		Coordinate down = new Coordinate(this.row + 1, this.col);
		return down;
	}
	
	public void moveUp() {
		this.row = this.row - 1;
	}
	
	public void moveDown() {
		this.row = this.row + 1;
	}
	
	public void moveRight() {
		this.col = this.col + 1;
	}
	
	public void moveLeft() {
		this.col = this.col - 1;
	}
	
	@Override
	public boolean equals(Object o) {
		Coordinate coord2 = (Coordinate)o;
		if(this.col == coord2.col && this.row == coord2.row) {
			return true;
		}
		else {
			return false;
		}
	}
}
