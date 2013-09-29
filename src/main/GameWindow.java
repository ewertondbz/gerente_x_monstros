package main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel = new JPanel();

	public void init() {
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(backgroundPanel);
		backgroundPanel.setBackground(new Color(0x6699FF));
		backgroundPanel.setLayout(null);
		frame.setTitle("O jogo");
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

	public void add(JPanel panel) {
		backgroundPanel.add(panel);
	}
}
