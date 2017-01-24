package inventory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.util.ArrayList;

/**
 * @author Lucas Rudd
 *
 */
public class InventoryWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private final int X = 0;
	private final int Y = 1;
	
	//the class constants needed to draw a window
	private String windowTitle;
	private JPanel windowContent;
	private int width = 500;
	private int height = 500;
	private int[] location = {100, 100};
	
	
	/**
	 * The constructor which sets the window title
	 * @param title
	 */
	InventoryWindow(String title){
		windowTitle = title;
		super.setTitle(windowTitle);
	}
	
	
	
	/**
	 * Handles window setup which, at this point,
	 * is simply setting the JPanel to be drawn.
	 * @param content
	 */
	public void windowSetup(JPanel content)
	{
		windowContent = content;
	}
	
	/**
	 * I don't know why this is here...
	 * @param content
	 */
	public void setContent(JPanel content)
	{
		windowContent = content;
	}
	
	/**
	 * Draws the window
	 */
	public void drawWindow()
	{
		this.setContentPane(windowContent);
		this.setSize(width, height);
		this.setLocation(location[X], location[Y]);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * @return windowTitle
	 */
	public String getWindowTitle() {
		return windowTitle;
	}

	/**
	 * @param title
	 */
	public void setWindowTitle(String title) {
		windowTitle = title;
	}
	
	/**
	 * 
	 */
	public void clearWindow(){
		windowContent.removeAll();
		windowContent.repaint();
	}
	
	
	/**
	 * Sets up all necessary components to open the
	 * window which is responsible for adding new or
	 * existing items to the inventory management
	 * system. 
	 * I am considering introducing a
	 * WindowManagement super-class which simply
	 * has a 'openWindow' method which takes an 
	 * InventoryWindow (or a JFrame) as a parameter.
	 * The WindowManagement super-class would keep
	 * track of past Window states and Inventory
	 * information to be passed on to Windows only
	 * when they need it.
	 */
	public void openAddWindow(Inventory inventory){
		JPanel          addPanel  = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JTextField      itemField = new JTextField(20);
		JButton         saveBtn   = new JButton("Save");
		JButton         backBtn   = new JButton("Back");
		
		saveBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Item newItem = new Item(itemField.getText());
				if(!inventory.add(newItem)){
					JOptionPane.showMessageDialog(null, "Alert! Item already exists in inventory!");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Item " + newItem.getName() + " has been added to the Inventory.");
				}
			}
		});
		backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				openInventoryWindow(inventory);
			}
		});
		
		addPanel.add(itemField);
		addPanel.add(saveBtn);
		addPanel.add(backBtn);
		this.setContent(addPanel);
		this.drawWindow();
		
	}
	
	public void openInventoryWindow(Inventory inventory){
		//Creating item labels from the Items
		JPanel itemField = new JPanel();
		itemField.setLayout(new BoxLayout(itemField, BoxLayout.PAGE_AXIS));
		JLabel tempLabel = null;
		for(Item i : inventory.getItems()){
			tempLabel = new JLabel(i.getName());
			itemField.add(tempLabel);
		}
		
		/** 
		 * The 'Add' button creates a new window where the
		 * user can add a new item, or add additional inventory
		 * to a currently existing item.
		 * Perhaps this should be changed to an 'Edit Items'
		 * button. In that screen the user could add new items
		 * or edit existing items. That way when the 'Save'
		 * button is pressed I could more easily justify
		 * updating the entire screen by using the
		 * getEditedItems method in the Inventory class.
		 */
		
		JButton addBtn = new JButton("Add Item");
		addBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				openAddWindow(inventory);
				/*if(inventory.hasItemBeenAdded()){
					JLabel newLabel = null;
					for(Item i : inventory.getEditedItems()){
						newLabel = new JLabel(i.getName());
						itemField.add(newLabel);
					}	
				}*/
				
			}
		});
		JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
	    mainPanel.add(itemField);
	    mainPanel.add(addBtn);
	    JPanel content = mainPanel;
	    /*adding the content to the window and setting up any other necessary 
		*details*/
		this.setContent(content);
		
		/*calling the drawWindow class which draws the window in a set way
		*perhaps I need to add parameters to this class (or create a class 
		*which holds the window parameters) so that windows can vary in sizes
		*and locations*/
		this.drawWindow();
	}
}
