package ninjase.model;

public class Ninja {
	public Coordinate location;

	public Ninja(Coordinate location) {
		this.location = location;
	}
	
	public void moveUp() {
		this.location.moveUp();
	}
	
	public void moveDown() {
		this.location.moveDown();
	}
	
	public void moveLeft() {
		this.location.moveLeft();
	}
	
	public void moveRight() {
		this.location.moveRight();
	}
	
	public void move(MoveType dir) {
		if(dir == MoveType.Right) {
			this.moveRight();
		}
		else if(dir == MoveType.Left) {
			this.moveLeft();
		}
		else if(dir == MoveType.Up) {
			this.moveUp();
		}
		else if(dir == MoveType.Down) {
			this.moveDown();
		}
	}
}
