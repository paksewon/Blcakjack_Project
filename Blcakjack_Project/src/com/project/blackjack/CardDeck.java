package com.project.blackjack;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private List<CardDeck> pattern = null;
	private List<CardDeck> num = null;

	public void deck() {

		String[] pattern1 = new String[] { "♥", "♣", "◆", "♠" };
		String[] num1 = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };

		num = new ArrayList<>();
		pattern = new ArrayList<>();
		for (int i = 0; i < pattern1.length; i++) {
			for (int j = 0; j < num1.length; j++) {

			}
		}

	}
}
