package org.example.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.example.snakesAndLadders.player.Piece;

public class CreateGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private CreateGameController controller;
	
	private List<CreatePlayerPanel> createPlayerPanels;
	private JButton createButton;
	
	public CreateGamePanel(CreateGameController controller) {
		super(new BorderLayout());
		this.controller = controller;
		this.createPlayerPanels = new ArrayList<>();
		this.createButton = new JButton("Create board");
		
		JPanel allPlayersPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Piece[] pieceSelection = controller.getPieceSelection();
		
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx = 0;
		gbc.gridy = 3;

		for(int i = 0; i < 4; i++) {
			CreatePlayerPanel playerPanel = new CreatePlayerPanel(pieceSelection);

			createPlayerPanels.add(playerPanel);
			allPlayersPanel.add(playerPanel, gbc);
			gbc.gridy--;
		}
		
		JPanel createButtonPanel = new JPanel(new FlowLayout());
		
		createButton.addActionListener(e -> onCreateBoard());
		
		createButtonPanel.add(createButton);
		
		add(allPlayersPanel, BorderLayout.CENTER);
		add(createButtonPanel, BorderLayout.SOUTH);
	}
	
	private void onCreateBoard() {
		controller.createBoard();
	}
	
	public List<CreatePlayerPanel> getCreatePlayerPanels() {
		return createPlayerPanels;
	}
	
	public class CreatePlayerPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		private JTextField nameField;
		private JComboBox<Piece> colorSelectionBox;
		
		private CreatePlayerPanel(Piece[] pieceSelection) {
			super(new FlowLayout());
			this.nameField = new JTextField(20);
			this.colorSelectionBox = new JComboBox<>(pieceSelection);
			
			add(new JLabel("Name"));
			add(nameField);
			add(new JLabel("Color"));
			add(colorSelectionBox);
		}
		
		public String getName() {
			return nameField.getText();
		}
		
		public Piece getPiece() {
			return (Piece) colorSelectionBox.getSelectedItem();
		}
		
	}

}
