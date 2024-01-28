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
	private JLabel previousDieRollLabel;
	
	public GameControlsPanel() {
		super(new FlowLayout());
		this.currentPlayerLabel = new JLabel();
		this.rollDiceButton = new JButton("Roll dice");
		this.previousDieRollLabel = new JLabel("?");
		
		add(new JLabel("Current player:"));
		add(currentPlayerLabel);
		add(new JLabel("Previous die roll:"));
		add(previousDieRollLabel);
		add(rollDiceButton);
	}
	
	public void setCurrentPlayer(String currentPlayer) {
		currentPlayerLabel.setText(currentPlayer + " ");
	}
	
	public void setPreviousDieRoll(int dieRoll) {
		previousDieRollLabel.setText("" + dieRoll + " ");
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
