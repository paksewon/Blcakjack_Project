package com.projeck.blackjack.game;

import java.util.List;

import com.projeck.blackjack.Service.CardService;
import com.projeck.blackjack.model.BlackjackDto;

public class Game {
	public static void main(String[] args) {
		CardService card = new CardService();
		BlackjackDto black = new BlackjackDto();
		
		card.makeDeck();
		List<BlackjackDto> deckList = card.getDeck();
		
		for(BlackjackDto dto : deckList) {
			System.out.println(dto);
		}
	}

}
