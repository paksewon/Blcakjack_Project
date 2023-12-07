package com.projeck.blackjack.model;

import java.util.List;

public class GamerDto {

	private List<CardDto> deckList;
	private List<CardDto> dealerHand;
	private List<CardDto> playerHand;
	private List<CardDto> getDealerHand;

	private List<CardDto> getDealerHand() {
		return dealerHand;

	}

	private List<CardDto> getPlayerHand() {
		return dealerHand;

	}

}
