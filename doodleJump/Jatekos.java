package doodleJump;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Jatekos extends JPanel{
	private static final long serialVersionUID = 1L;
	int px;
	int py;
	int pw;
	int ph;
	private BufferedImage doodle;
	public Jatekos(int x, int y, int width,int height)  {
		py=y;
		px=x;
		pw=width;
		ph=height;
		this.setBounds(px,py,pw,ph);
		try {
			doodle = ImageIO.read(getClass().getResourceAsStream("/doodle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public int getPh() {
		return ph;
	}
	@Override
	public void paint(Graphics g) {
	    g.drawImage(doodle, 0, 0, doodle.getWidth(),doodle.getHeight(),null);
	}
	public void upedate(){
		this.setLocation(px,py);
	}
	public int getPy() {
		return py;
	}
	public int getPx() {
		return px;
	}
	public void setPy(int py) {
		this.py = py;
	}
	public void setPx(int px) {
		this.px = px;
	}
	public int getPw() {
		return pw;
	}
	
	
}
