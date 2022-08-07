package ninjase.controller;

import ninjase.model.Model;
import ninjase.view.Application;

public class DarkModeController {

    Application app;
    Model model;

    public DarkModeController(Application app, Model model) {
        this.app = app;
        this.model = model;
    }

    public void process(){
        if(app.isDark()){
            app.setDark();
            System.out.println("Dark mode is now on");
        }
        else{
            app.setLight();
            System.out.println("Dark mode is now off");
        }

        app.repaint();
    }
}
