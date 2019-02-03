package doodleJump;

import java.awt.Component;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Jatek {
	public static void main(String[] args) throws InterruptedException {
		JatekTer screen=new JatekTer();
		Jatekos player=new Jatekos(screen.getWidth()/2,screen.getHeight()/2,screen.getPlayerWidth(),screen.getPlayerHeight());
		Random rand=new Random();
		int platformCount=10;
		int pontok=0;
		Platform p[] =new Platform[platformCount];
		p[0]=new Platform(rand.nextInt(screen.getWidth()-160),rand.nextInt(20));
		for(int i=1;i<platformCount;i++) {
			int plusz=rand.nextInt(100)+46;
			p[i]=new Platform(rand.nextInt(screen.getWidth()-160),p[i-1].getAy()+plusz);
		}
		screen.add(player);
		for(int i=0;i<platformCount;i++) screen.add(p[i]);
		screen.repaint();
		Boolean halal=false;
		Boolean felfele=false;
		int fel=0;
		while(!halal) {
			if(screen.getBal()) {
				player.setPx(player.getPx()+15);
				if(player.getPx()+player.getWidth()/2>=screen.getWidth()) {
					player.setPx(-player.getWidth()/2);
				}
			}
			if(screen.getJobb()) {
				player.setPx(player.getPx()-15);
				if(player.getPx()<=-player.getWidth()/2) {
					player.setPx(screen.getWidth()-player.getWidth()/2);
				}
			}
			
			if(felfele && fel <=20) {
				pontok++;
				if(player.getPy()>=screen.getHeight()/2) {
				player.setPy(player.getPy()-9);
				fel++;
				}
				if(player.getPy()<=screen.getHeight()/2) {
				screen.setPont(pontok);
				player.setPy(player.getPy()-2);
				fel++;
				for(int i=0;i<platformCount;i++) {
					p[i].setAy(p[i].getAy()+7);
				}
				for(int i=0;i<platformCount;i++) {
					if(p[i].getAy()>=screen.getHeight()){
						int plusz=rand.nextInt(50);
						p[i].setAx(rand.nextInt(screen.getWidth()-160));
						p[i].setAy(-plusz);
					}
				}
				}
			}
			else {
				fel=0;
				felfele=false;
				player.setPy(player.getPy()+6);
			}
			
			for(int i=0;i<platformCount;i++)
				if(player.getPx()+player.getWidth() >= p[i].getAx() && player.getPx()<=p[i].getAx()+p[i].getWidth()  &&
				   player.getPy()+player.getHeight() >= p[i].getAy()&& player.getPy()+player.getHeight() <= p[i].getAy()+10) {
					felfele=true;
				}
			
			if(player.getPy()+player.getHeight()>=screen.getHeight()) {
				halal=true;
			}
			for(int i=0;i<platformCount;i++) {
				p[i].upedate();
			}
			player.upedate();
			TimeUnit.MILLISECONDS.sleep((long) (screen.getSpeed()*100));
		}
		Component frame = null;
		JOptionPane.showMessageDialog(frame,   "  Meghaltál :( \n  Dekár érted :( \n  Azért jó játék volt!  Pontszámod: "+pontok, "Game Over :(", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
}
