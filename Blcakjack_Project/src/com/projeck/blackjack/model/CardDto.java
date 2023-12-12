package com.projeck.blackjack.model;

public class CardDto {
	private String cardDeck;
	private String denomination;
	private String cardSuit; // 카드 모양 Suit
	private int value;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCardDeck() {
		return cardDeck;
	}
	public void setCardDeck(String cardDeck) {
		this.cardDeck = cardDeck;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}
	@Override
	public String toString() {
		return "[숫자 = " + denomination + ", 패턴 = " + cardSuit
				+ ", 카드 = " + value + cardSuit + "]";
	}
}
