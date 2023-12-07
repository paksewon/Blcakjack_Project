package com.projeck.blackjack.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.projeck.blackjack.model.CardDto;

public class CardService {
	String suit = "♣,◆,♠,♥";
	String value = "A,2,3,4,5,6,7,8,9,10,K,Q,J";
	private List<CardDto> deckList;

	public CardService() {
		this.deckList = new ArrayList<CardDto>();
	}

	public List<CardDto> getDeck() {
		return this.deckList;
	}

	public void makeDeck() {

		String[] suits = suit.split(",");
		String[] values = value.split(",");

		for (String suit : suits) {
			for (String value : values) {
				int intValue = 0;
				try {
					intValue = Integer.valueOf(value);
				} catch (Exception e) {
					if (value.equals("A")) {
						intValue = 1;
					} else
						intValue = 10;

				}
				Collections.shuffle(deckList);

				CardDto blackjack = new CardDto();
				blackjack.setCardSuit(suit);
				blackjack.setDenomination(value);
				blackjack.setValue(intValue);
				deckList.add(blackjack);

			}
		}
	}

	public CardDto getRandomCard() {
		int size = deckList.size();
		int select = (int) (Math.random() * size);
		return deckList.get(select);
	}
}
