package doodleJump;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Platform extends JLabel {
private static final long serialVersionUID = 1L;
	int ax;
	int ay;
	private BufferedImage img;
	public Platform(int x, int y){
		this.ax=x;
		this.ay=y;
		URL url;
		url = this.getClass().getResource("/platform.gif");
	    Icon icon = new ImageIcon(url);
	    this.setIcon(icon);
		this.setSize(200,200);
		this.setLocation(ax,ay);
		
	}
	public int getAx() {
		return ax;
	}
	public int getAy() {
		return ay;
	}
	public void setAx(int ax) {
		this.ax = ax;
	}
	public void setAy(int ay) {
		this.ay = ay;
	}
	public void upedate() {
		this.setLocation(ax,ay);
	}
}
