package csc121.project05;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class BackgroundPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image bg;

	public BackgroundPanel(Image bg) {
		this.bg = bg;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}
