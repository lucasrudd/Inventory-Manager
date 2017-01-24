package inventory;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

public class LPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//set different component types to add to the main LPanel
	/*Display displayPanel;
	JTextArea textArea;
	JButton button;
	ActionListener listener;*/
	ArrayList<Component> content = new ArrayList<Component>();
	
	LPanel()
	{
		super();
		/*displayPanel = new Display("Good Morrow");
		textArea = new JTextArea();
		button = new JButton("Clear Screen");
		listener = new ButtonHandler();
		
		//add the listener to the button so that it can respond when clicked
		button.addActionListener(listener);
		
		
		setLayout(new BorderLayout());
		add(textArea, BorderLayout.CENTER);
		//add(displayPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);*/
	}
	
	LPanel(BorderLayout b){
		super(b);
	}

	
	public void setContent(ArrayList<Component> content)
	{
		this.content = content;
	}
	
	public void removeContent()
	{
		for(Component c : content){
			remove(c);
		}
	}
	
	
	public void setDisplayString(String newDisplayString){
		Display.setDisplayString(newDisplayString);
	}
	
}
