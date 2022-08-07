package ninjase.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class Level implements Iterable<Obstacle> {
	ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	public final int numRows;
	public final int numCols;
	public int level;
	
	public static final int easy = 1;
	public static final int medium = 2;
	public static final int hard = 3;
	
	public Level(int numRows, int numCols, int level) {
		this.numRows = numRows;
		this.numCols = numCols;
		this.level = level;
	}
	
	public void removeObstacle(Obstacle obstacle) {
		obstacles.remove(obstacle);
	}
	
	public void addObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);
	}
	
	public boolean noObstacles() {
		return obstacles.isEmpty();
	}

	@Override
	public Iterator<Obstacle> iterator() {
		// TODO Auto-generated method stub
		return obstacles.iterator();
	}
	
	public boolean hasWon() {
		//TODO
		return false;
	}
	
	public boolean isValid(Coordinate coor) {			//TODO Test function
		boolean valid = false;
		if(coor.col > 0 && coor.col < this.numCols -1) {
			if(coor.row > 0 && coor.row < this.numRows - 1) {
				valid = true;
			}
			else {
				valid = false;
			}
		}
		else {
			valid = false;
		}
		return valid;
	}
	
	public void reset() {
		//TODO
	}
	
	public boolean isEmpty(Coordinate coor) {	//TODO Test function
		for(Obstacle obstacle : obstacles) {
			if(coor.equals(obstacle.location)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isCovered(Coordinate coord) {
		for (Obstacle o : obstacles) {
			if(o.location.equals(coord)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Obstacle giveObstacel(Coordinate coord) {
		for(Obstacle o : obstacles) {
			if(o.location.equals(coord)) {
				return o;
			}
		}
		return null;
	}
}
