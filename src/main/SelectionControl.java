package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SelectionControl implements MouseMotionListener, ControlComponent {

	private SelectionPanel selectionPanel = new SelectionPanel();

	private static SelectionControl instance = new SelectionControl();

	private SelectionControl() {
	}

	public void init() {
		selectionPanel.init();
	}

	public void update(long deltaTicks) {
		selectionPanel.repaint();
	}

	public static SelectionControl getInstance() {
		return instance;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		selectionPanel.select(event.getLocationOnScreen());
	}
}
