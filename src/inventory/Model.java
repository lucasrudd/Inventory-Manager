package inventory;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Model {

	public static void main(String[] args) {
		
		Inventory inventory = new Inventory();
		//A special thread to continually update the runnable code
		SwingUtilities.invokeLater(new Runnable(){	
			public void run()
			{
				
				//The single main window
				InventoryWindow window = new InventoryWindow("GUI Test");
				
				/**
				 * Default Inventory Items
				 * THESE ARE FOR TESTING PURPOSES ONLY
				 */
				
				ItemStack burgers = new ItemStack(new Item("Burger"));
				ItemStack fries   = new ItemStack(new Item("Fries"));
				inventory.add(burgers);
				inventory.add(fries);
				
				
				/*Item burger = new Item("Burger");
				Item fries  = new Item("Fries");
				inventory.add(burger);
				inventory.add(fries);*/
				
				
				
				/**
				 * End default Inventory Items
				 */
				
				window.openInventoryWindow(inventory);
				
				/*
				JTextArea chatArea = new JTextArea(8, 40);
			    chatArea.setEditable(true);
			    chatArea.setFocusable(false);
			    JScrollPane chatScroll = new JScrollPane(chatArea);
			    JPanel chatPanel = new JPanel(new BorderLayout());
			    chatPanel.add(new JLabel("Chat:", SwingConstants.LEFT), BorderLayout.PAGE_START);
			    chatPanel.add(chatScroll);

			    JTextField inputField = new JTextField(40);
			    JButton sendBtn = new JButton("Send");
			    sendBtn.addActionListener(new ActionListener(){
			    	@Override
			    	public void actionPerformed(ActionEvent e){
			    		chatArea.append(inputField.getText() + "\n");
			    		inputField.setText("");
			    	}
			    });
			    JButton exitBtn = new JButton("Exit");
			    exitBtn.addActionListener(new ActionListener(){
			    	@Override
			    	public void actionPerformed(ActionEvent e){
			    		window.clearWindow();
			    	}
			    });
			    JPanel inputPanel = new JPanel();
			    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));
			    inputPanel.add(inputField);
			    inputPanel.add(sendBtn);
			    inputPanel.add(exitBtn);

			    JPanel youLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
			    youLabelPanel.add(new JLabel("You:"));*/

			    
			    /*mainPanel.add(chatPanel);
			    mainPanel.add(Box.createVerticalStrut(10));
			    mainPanel.add(youLabelPanel);
			    mainPanel.add(inputPanel);*/
				
			}
		});
	}
	
	public static JLabel createJLabel(Item i){
		JLabel itemLabel = new JLabel(i.getName());
		return itemLabel;
	}

}
