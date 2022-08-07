package ninjase;

import java.awt.*;

import ninjase.view.Application;
import ninjase.model.Coordinate;
import ninjase.model.Level;
import ninjase.model.Model;
import ninjase.model.MoveType;
import ninjase.model.Ninja;
import ninjase.model.Obstacle;

public class Main {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Model model = new Model();
                    model.setEasy();

                    Application frame = new Application(model);
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
