package org.example.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameControlsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel currentPlayerLabel;
	private JButton rollDiceButton;
	
	public GameControlsPanel() {
		super(new FlowLayout());
		this.currentPlayerLabel = createCurrentPlayerLabel();
		this.rollDiceButton = createRollDiceButton();
		
		add(currentPlayerLabel);
		add(rollDiceButton);
	}
	
	private static JLabel createCurrentPlayerLabel() {
		JLabel label = new JLabel();
		
		return label;
	}
	
	private static JButton createRollDiceButton() {
		JButton button = new JButton("Roll dice");
		
		return button;
	}
	
	public void setCurrentPlayer(String currentPlayer) {
		currentPlayerLabel.setText(currentPlayer);
	}
	
	public void setOnRollDice(ActionListener onClick) {
		rollDiceButton.addActionListener(onClick);
	}
	
	public JLabel getCurrentPlayerLabel() {
		return currentPlayerLabel;
	}
	
	public JButton getRollDiceButton() {
		return rollDiceButton;
	}
	
}
