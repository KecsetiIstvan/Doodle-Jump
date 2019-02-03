package doodleJump;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MozgasKezelo implements KeyListener {
	JatekTer jatek;
	public MozgasKezelo(JatekTer jatek) {
		this.jatek=jatek;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==27) {
			System.exit(0);
		}//eszk
		if(e.getKeyCode()==39 && !jatek.getJobb()) {
			jatek.setBal(true);
		}//bal
		if(e.getKeyCode()==37 && !jatek.getBal()) {
			jatek.setJobb(true);
		}//jobb
		
	}	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==39) {
			jatek.setBal(false);
		}//bal
		if(e.getKeyCode()==37) {
			jatek.setJobb(false);
		}//jobb
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
