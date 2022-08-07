package ninjase.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ninjase.controller.DarkModeController;
import ninjase.controller.LevelController;
import ninjase.controller.MoveController;
import ninjase.controller.ResetController;
import ninjase.model.Model;
import ninjase.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Application extends JFrame {

	public Model model;
	private JPanel numMoves;
	PuzzleViewer panel;
	JButton btnUp, btnDown, btnLeft, btnRight;
	
	JLabel lblMoves;
	JLabel actualMoves;
	JLabel congrats;
	
	JMenuBar menuBar;
	
	JButton btnReset;
	
	JCheckBoxMenuItem darkMode;
	
	JMenuItem easy;
	JMenuItem medium;
	JMenuItem hard;
	
	public int moves = 0;
	
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	public static final int LEFT = 4;
	
	public ImageIcon icon;
	
	public JButton getUpButton() { return btnUp;}
	public JButton getDownButton() { return btnDown;}
	public JButton getLeftButton() { return btnLeft;}
	public JButton getRightButton() { return btnRight;}
	
	public JLabel getMoveLabel() { return actualMoves;}
	
	public JLabel getCongrats() { return congrats;}
	
	public Application(Model model) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.class.getResource("/ninjase/nonCode/ninja-se.png")));
		this.model = model;
		
		setBackground(Color.DARK_GRAY);
		setTitle("Ninja-se Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 800);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNinjaSe = new JMenu("Ninja-se");
		mnNinjaSe.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnNinjaSe);
		
		darkMode = new JCheckBoxMenuItem("Dark Mode", false);
		mnNinjaSe.add(darkMode);
		darkMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DarkModeController(Application.this, model).process();
			}
		});
		
		JMenu mnDifficulty = new JMenu("Difficulty");
		mnDifficulty.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnDifficulty);
		
		easy = new JMenuItem("Easy");
		mnDifficulty.add(easy);
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LevelController(Application.this, model).process("Easy");
			}
		});
		
		medium = new JMenuItem("Medium");
		mnDifficulty.add(medium);
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LevelController(Application.this, model).process("Medium");
			}
		});
		
		hard = new JMenuItem("Hard");
		mnDifficulty.add(hard);
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LevelController(Application.this, model).process("Hard");
			}
		});
		
		numMoves = new JPanel();
		numMoves.setForeground(Color.BLACK);
		numMoves.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(numMoves);

		actualMoves = new JLabel(String.valueOf(moves));
		actualMoves.setBackground(Color.WHITE);
		actualMoves.setForeground(Color.BLACK);
		actualMoves.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		
		panel = new PuzzleViewer(model);
		
		lblMoves = new JLabel("Number of Moves:");
		lblMoves.setBackground(Color.WHITE);
		lblMoves.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		
		btnReset = new JButton("Reset");
		btnReset.setMnemonic(KeyEvent.VK_ENTER);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnReset.setBackground(Color.BLUE);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(Application.this, model).process();
			}
		});
		
		btnUp = new JButton("UP");
		btnUp.setMnemonic(KeyEvent.VK_UP);
		btnUp.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnUp.setBackground(Color.RED);
		btnUp.setForeground(Color.BLACK);
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, UP).process();
			}
		});
		
		btnDown = new JButton("DOWN");
		btnDown.setMnemonic(KeyEvent.VK_DOWN);
		btnDown.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnDown.setForeground(Color.BLACK);
		btnDown.setBackground(Color.RED);
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, DOWN).process();
			}
		});
		
		btnRight = new JButton("RIGHT");
		btnRight.setMnemonic(KeyEvent.VK_RIGHT);
		btnRight.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnRight.setForeground(Color.BLACK);
		btnRight.setBackground(Color.RED);
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, RIGHT).process();
			}
		});
		
		btnLeft = new JButton("LEFT");
		btnLeft.setMnemonic(KeyEvent.VK_LEFT);
		btnLeft.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnLeft.setForeground(Color.BLACK);
		btnLeft.setBackground(Color.RED);
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveController(Application.this, model, LEFT).process();
			}
		});
		
		GroupLayout gl_numMoves = new GroupLayout(numMoves);
		gl_numMoves.setHorizontalGroup(
			gl_numMoves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_numMoves.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_numMoves.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_numMoves.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_numMoves.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_numMoves.createSequentialGroup()
									.addGap(15)
									.addComponent(btnLeft, 84, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
									.addComponent(btnRight))
								.addGroup(gl_numMoves.createSequentialGroup()
									.addGap(109)
									.addComponent(btnUp, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
									.addGap(106)))
							.addGroup(gl_numMoves.createSequentialGroup()
								.addGap(91)
								.addGroup(gl_numMoves.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnReset)
									.addComponent(btnDown))
								.addGap(91)))
						.addGroup(gl_numMoves.createSequentialGroup()
							.addComponent(lblMoves)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(actualMoves)
							.addGap(46)))
					.addGap(12))
		);
		gl_numMoves.setVerticalGroup(
			gl_numMoves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_numMoves.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_numMoves.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
						.addGroup(gl_numMoves.createSequentialGroup()
							.addGroup(gl_numMoves.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_numMoves.createSequentialGroup()
									.addGap(166)
									.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_numMoves.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnRight, GroupLayout.DEFAULT_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLeft, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addGap(230))
								.addGroup(gl_numMoves.createSequentialGroup()
									.addGroup(gl_numMoves.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblMoves)
										.addComponent(actualMoves))
									.addPreferredGap(ComponentPlacement.RELATED, 302, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)
							.addGap(66))))
		);
		
		congrats = new JLabel("");
		congrats.setIcon(new ImageIcon(Application.class.getResource("/ninjase/view/happy-for-you-congrats.gif")));
		panel.add(congrats);
		congrats.setVisible(false);
		
		numMoves.setLayout(gl_numMoves);	
	}
	
	public boolean isDark() {
		return darkMode.getState();
	}
	
	public void setDark() {
		numMoves.setBackground(Color.BLACK);
		menuBar.setBackground(Color.GRAY);
		panel.setBackground(Color.BLACK);
		lblMoves.setForeground(Color.WHITE);
		actualMoves.setForeground(Color.WHITE);	
	}
	
	public void setLight() {
		numMoves.setBackground(Color.WHITE);
		menuBar.setBackground(Color.LIGHT_GRAY);
		panel.setBackground(Color.WHITE);
		lblMoves.setForeground(Color.BLACK);
		actualMoves.setForeground(Color.BLACK);
	}
}
