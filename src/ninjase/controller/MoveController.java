package ninjase.controller;

import java.util.ArrayList;
import ninjase.model.Model;
import ninjase.model.MoveType;
import ninjase.view.Application;

public class MoveController {
	
	Application app;
	Model model;
	int direction;
	
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;

	public MoveController(Application app, Model model, int direction) {
		this.app = app;
		this.model = model;
		this.direction = direction;
	}
	
	
	
	public void process() {
		if(direction == UP && model.ninja.location.row > 0) {
			if(this.model.tryMove(MoveType.Up)) {
				app.moves++;
				System.out.println("Moving up");
			}
		}
		
		if(direction == DOWN && model.ninja.location.row < model.level.numRows - 1) {
			if(this.model.tryMove(MoveType.Down)) {
				app.moves++;
				System.out.println("Moving down");
			}
		}
		
		if(direction == LEFT && model.ninja.location.col > 0) {
			if(this.model.tryMove(MoveType.Left)) {
				app.moves++;
				System.out.println("Moving left");
			}
		}
		
		if(direction == RIGHT && model.ninja.location.col < model.level.numCols - 1) {
			if(this.model.tryMove(MoveType.Right)) {
				app.moves++;
				System.out.println("Moving right");
			}
		}
		
		if(model.level.noObstacles()) {
			app.getCongrats().setVisible(true);
		}
		
		app.getMoveLabel().setText(String.valueOf(app.moves));		
		app.repaint();
	}
}
