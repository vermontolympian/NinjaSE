package ninjase.controller;

import ninjase.model.Model;
import ninjase.view.Application;

public class LevelController {
	
	Application app;
	Model model;

	public LevelController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void process(String Level) {
		if(Level == "Easy") {
			model.setEasy();
			new ResetController(this.app, this.model).process();
			System.out.println("Changing Level to easy");
		}
		if(Level == "Medium") {
			model.setMedium();
			new ResetController(this.app, this.model).process();
			System.out.println("Changing Level to medium");
		}
		if(Level == "Hard") {
			model.setHard();
			new ResetController(this.app, this.model).process();
			System.out.println("Changing Level to hard");
		}

		
		// Reset everything
		app.repaint();
	}
}