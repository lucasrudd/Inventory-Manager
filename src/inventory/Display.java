package inventory;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Display extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String displayString;
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void	paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(getDisplayString(), 20, 30);
	}
	
	/**
	 * 
	 */
	Display(){
		Display.setDisplayString("ERROR! No display string selected.");
		
	}
	
	/**
	 * @param displayString
	 */
	Display(String displayString){
		setDisplayString(displayString);	
	}

	/**
	 * @return displayString
	 */
	public String getDisplayString() {
		return displayString;
	}

	/**
	 * @param string
	 */
	public static void setDisplayString(String string) {
		displayString = string;
	}
	
	/**
	 * @param label
	 */
	public void add(JLabel label){
		super.add(label);
	}

	
}
