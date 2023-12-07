package com.projeck.blackjack.game;

import java.util.List;

import com.projeck.blackjack.Service.CardService;
import com.projeck.blackjack.model.CardDto;

public class Game {
	public static void main(String[] args) {
		CardService card = new CardService();
		CardDto black = new CardDto();
		
		card.makeDeck();
		List<CardDto> deckList = card.getDeck();
		
//		for(BlackjackDto dto : deckList) {
//			System.out.println(dto);
//		}
		System.out.println(card.getRandomCard());
	}

}
