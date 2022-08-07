package ninjase.model;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import ninjase.model.Level;

public class Model {
    public Level level;
    public Ninja ninja;

    public Model(Level level, Ninja ninja) {
        this.level = level;
        this.ninja = ninja;
    }

    public Model(Level level) {
        this.level = level;
    }

    public Model() {

    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setEasy() {
        this.level = new Level(4, 5, 1);
        this.level.addObstacle(new Obstacle(Color.decode("#ffff00"), new Coordinate(0, 3)));
        this.level.addObstacle(new Obstacle(Color.decode("#ffff00"), new Coordinate(2, 2)));
        this.ninja = new Ninja(new Coordinate(1, 1));
    }

    public void setMedium() {
        this.level = new Level(3, 7, 2);
        this.level.addObstacle(new Obstacle(Color.decode("#ffff00"), new Coordinate(0, 2)));
        this.level.addObstacle(new Obstacle(Color.decode("#ffff00"), new Coordinate(1, 3)));
        this.level.addObstacle(new Obstacle(Color.decode("#ff0000"), new Coordinate(1, 2)));
        this.level.addObstacle(new Obstacle(Color.decode("#ff0000"), new Coordinate(1, 0)));
        this.level.addObstacle(new Obstacle(Color.decode("#0000ff"), new Coordinate(1, 1)));
        this.level.addObstacle(new Obstacle(Color.decode("#0000ff"), new Coordinate(2, 6)));
        this.level.addObstacle(new Obstacle(Color.decode("#00ff00"), new Coordinate(0, 6)));
        this.level.addObstacle(new Obstacle(Color.decode("#00ff00"), new Coordinate(1, 6)));
        this.ninja = new Ninja(new Coordinate(0, 1));
    }

    public void setHard() {
        this.level = new Level(7, 7, 3);
        this.level.addObstacle(new Obstacle(Color.decode("#ffff00"), new Coordinate(3, 1)));
        this.level.addObstacle(new Obstacle(Color.decode("#ffff00"), new Coordinate(5, 4)));
        this.level.addObstacle(new Obstacle(Color.decode("#ff0000"), new Coordinate(3, 2)));
        this.level.addObstacle(new Obstacle(Color.decode("#ff0000"), new Coordinate(5, 6)));
        this.level.addObstacle(new Obstacle(Color.decode("#0000ff"), new Coordinate(4, 1)));
        this.level.addObstacle(new Obstacle(Color.decode("#0000ff"), new Coordinate(5, 5)));
        this.level.addObstacle(new Obstacle(Color.decode("#00ff00"), new Coordinate(2, 2)));
        this.level.addObstacle(new Obstacle(Color.decode("#00ff00"), new Coordinate(6, 5)));
        this.level.addObstacle(new Obstacle(Color.decode("#00ffff"), new Coordinate(2, 1)));
        this.level.addObstacle(new Obstacle(Color.decode("#00ffff"), new Coordinate(3, 3)));
        this.level.addObstacle(new Obstacle(Color.decode("#ff00ff"), new Coordinate(3, 0)));
        this.level.addObstacle(new Obstacle(Color.decode("#ff00ff"), new Coordinate(1, 5)));
        this.ninja = new Ninja(new Coordinate(6, 6));
    }

    public ArrayList<MoveType> availableMoves(){
        ArrayList<MoveType> moves = new ArrayList<>();

        Coordinate coord = ninja.location;
        boolean available = true;

        //Left?
        if(level.isCovered(coord.getLeft())) {
            available = false;
        }
        if(available) {
            moves.add(MoveType.Left);
        }

        //Right?
        available = true;
        if(level.isCovered(coord.getRight())) {
            available = false;
        }
        if(available) {
            moves.add(MoveType.Right);
        }

        //Up?
        available = true;
        if(level.isCovered(coord.getUp())) {
            available = false;
        }
        if(available) {
            moves.add(MoveType.Up);
        }

        //Down?
        available = true;
        if(level.isCovered(coord.getDown())) {
            available = false;
        }
        if(available) {
            moves.add(MoveType.Down);
        }
        return moves;
    }
	/*
	public boolean tryMove(MoveType dir) {
		for(MoveType move : availableMoves()) {
			if(dir == move) {
				this.ninja.move(dir);
				return true;
			}
		}
		return false;
	}*/

    public boolean tryMove(MoveType dir) {
        if(dir.equals(MoveType.Up)) {
            Coordinate up = this.ninja.location.getUp();
            if(this.level.isEmpty(up)) {
                this.ninja.move(dir);
                return true;
            }
            else {
                Coordinate upup = up.getUp();
                if(this.level.isEmpty(upup) && upup.row >= 0) {
                    this.ninja.move(dir);
                    this.level.giveObstacel(up).moveUp();
                    return true;
                }
                else if(this.level.isCovered(upup)){
                    if(this.level.giveObstacel(upup).color.equals(this.level.giveObstacel(up).color)){
                        this.level.removeObstacle(this.level.giveObstacel(up));
                        this.level.removeObstacle(this.level.giveObstacel(upup));
                        this.ninja.moveUp();
                        return true;
                    }
                }
            }
        }

        if(dir.equals(MoveType.Down)) {
            Coordinate down = this.ninja.location.getDown();
            if(this.level.isEmpty(down)) {
                this.ninja.move(dir);
                return true;
            }
            else {
                Coordinate downdown = down.getDown();
                if(this.level.isEmpty(downdown) && downdown.row < this.level.numRows) {
                    this.ninja.move(dir);
                    this.level.giveObstacel(down).moveDown();
                    return true;
                }
                else if(this.level.isCovered(downdown)){
                    if(this.level.giveObstacel(downdown).color.equals(this.level.giveObstacel(down).color)){
                        this.level.removeObstacle(this.level.giveObstacel(down));
                        this.level.removeObstacle(this.level.giveObstacel(downdown));
                        this.ninja.moveDown();
                        return true;
                    }
                }
            }
        }

        if(dir.equals(MoveType.Left)) {
            Coordinate l = this.ninja.location.getLeft();
            if(this.level.isEmpty(l)) {
                this.ninja.move(dir);
                return true;
            }
            else {
                Coordinate ll = l.getLeft();
                if(this.level.isEmpty(ll) && ll.col >= 0) {
                    this.ninja.move(dir);
                    this.level.giveObstacel(l).moveLeft();
                    return true;
                }
                else if(this.level.isCovered(ll)){
                    if(this.level.giveObstacel(ll).color.equals(this.level.giveObstacel(l).color)){
                        this.level.removeObstacle(this.level.giveObstacel(l));
                        this.level.removeObstacle(this.level.giveObstacel(ll));
                        this.ninja.moveLeft();
                        return true;
                    }
                }
            }
        }

        if(dir.equals(MoveType.Right)) {
            Coordinate r = this.ninja.location.getRight();
            if(this.level.isEmpty(r)) {
                this.ninja.move(dir);
                return true;
            }
            else {
                Coordinate rr = r.getRight();
                if(this.level.isEmpty(rr) && rr.col < this.level.numCols) {
                    this.ninja.move(dir);
                    this.level.giveObstacel(r).moveRight();
                    return true;
                }
                else if(this.level.isCovered(rr)){
                    if(this.level.giveObstacel(rr).color.equals(this.level.giveObstacel(r).color)){
                        this.level.removeObstacle(this.level.giveObstacel(r));
                        this.level.removeObstacle(this.level.giveObstacel(rr));
                        this.ninja.moveRight();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
