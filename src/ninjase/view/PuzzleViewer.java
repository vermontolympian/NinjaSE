package ninjase.view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ninjase.model.Level;
import ninjase.model.Model;
import ninjase.model.MoveType;
import ninjase.model.Obstacle;

public class PuzzleViewer extends JPanel {

	Model model;
	public static final int boxSize = 100;
	public static final int offset = 10;
	
	ImageIcon ninjaSeIcon = null;

	public PuzzleViewer(Model model) {
		this.model = model;
	}
	
	public Rectangle computeRectangle (Obstacle o) {
		int col = o.getCol();
		int row = o.getRow();
		Rectangle rect = new Rectangle(col*boxSize, row*boxSize, boxSize - offset, boxSize - offset);
		return rect;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// WINDOW BUILDER ONLY
		if (model == null) {
			return;
		}
		Level level = model.getLevel();
		
		for(Obstacle o : level) {
			Color color = o.getColor();
			g.setColor(color);
			Rectangle r = computeRectangle(o);
			g.fillRect(r.x, r.y, r.width, r.height);
		}
		
		g.setColor(Color.LIGHT_GRAY);
		for (int r = 0; r < level.numRows; r++) {
			for (int c = 0; c < level.numCols; c++) {
				g.drawRect(100*c, 100*r, 90, 90);
			}
		}
		
		
		if(ninjaSeIcon == null) {
			URL imageURL = this.getClass().getResource("ninja-se.png");
			ninjaSeIcon = new ImageIcon(imageURL);
		}
		
		g.drawImage(ninjaSeIcon.getImage(), model.ninja.location.col * 100 + 1, model.ninja.location.row * 100 + 1, model.ninja.location.col * 100 + 90, model.ninja.location.row * 100 + 90, 0, 0, 254, 256, this);
	}

}
