package org.example.gui.board;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public interface SquareFactory {
	
	JComponent create(int squareNr);
	
	default List<JComponent> createList(int size) {
		List<JComponent> list = new ArrayList<>();
		
		for(int i = 1; i <= size; i++) {
			list.add(create(i));
		}
		
		return list;
	}
	
}