import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Dragged {
	
	private int xP;
	private int yP;
	
	
	public void SetJComponent(JComponent component, boolean ShowHandCursor) {
				
		if(ShowHandCursor) {
			component.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else {
			component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		component.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				component.setLocation((int) (xP + e.getLocationOnScreen().getX()),
						(int) (yP + e.getLocationOnScreen().getY()));
			}
		});
		
		component.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//component.setLocation(0, (int) (Math.round(yP/component.getSize().getHeight())*component.getSize().getHeight()));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				xP = (int) (component.getLocation().getX() - (e.getLocationOnScreen().getX()));
				yP = (int) (component.getLocation().getY() - (e.getLocationOnScreen().getY()));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
				component.setLocation(0, (int) (Math.round(yP/component.getSize().getHeight())*component.getSize().getHeight()));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {				
			}
		});
	}
	
	public void SetJFrame(JFrame component, boolean ShowDraggCursor) {
		
		if(ShowDraggCursor) {
			component.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		}else {
			component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
		component.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				component.setLocation((int) (xP + e.getLocationOnScreen().getX()),
						(int) (yP + e.getLocationOnScreen().getY()));
			}
		});
		
		component.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				xP = (int) (component.getLocation().getX() - (e.getLocationOnScreen().getX()));
				yP = (int) (component.getLocation().getY() - (e.getLocationOnScreen().getY()));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {				
			}
		});
	}
	
}
