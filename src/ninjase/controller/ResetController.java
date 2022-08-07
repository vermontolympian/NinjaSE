package ninjase.controller;

import ninjase.model.Level;
import ninjase.model.Model;
import ninjase.view.Application;

public class ResetController {
	
	Application app;
	Model model;

	public ResetController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void process() {		
		if(this.model.level.level == Level.easy) {
			this.model.setEasy();
		}
		if(this.model.level.level == Level.medium) {
			this.model.setMedium();
		}
		
		if(this.model.level.level == Level.hard) {
			this.model.setHard();
		}
		app.getCongrats().setVisible(false);
		System.out.println("READY TO RESET...");
		app.moves = 0;
		app.getMoveLabel().setText(String.valueOf(app.moves));
		
		// Reset everything
		app.repaint();
	}
}