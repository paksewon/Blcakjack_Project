package com.projeck.blackjack.game;

import java.util.List;

import com.projeck.blackjack.Service.CardService;
import com.projeck.blackjack.model.CardDto;

public class Game {
	public static void main(String[] args) {
		CardService card = new CardService();
		CardDto black = new CardDto();
		
		card.makeDeck();
		List<CardDto> deckList = card.getDeck();  // 겟으로부터 리스크를 가져온다
		
//		for(BlackjackDto dto : deckList) {
//			System.out.println(dto);
//		}
		System.out.println(card.getRandomCard());
	}

}
