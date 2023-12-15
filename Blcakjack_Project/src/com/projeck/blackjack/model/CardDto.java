package com.projeck.blackjack.model;

public class CardDto {
	// Dto 이기 떄문에 private 으로 선언 (dto : 데이터를 전달하기 위한 객체)
	private String cardDeck;
	private String denomination; // 선언
	private String cardSuit; // suit 라는 변수를 문자열로 선언 카드 모양 Suit
	private int value; // 실제로 가지는 값을 value 로

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
		return "[숫자 = " + denomination + ", 패턴 = " + cardSuit + ", 카드 = " + value + cardSuit + "]";
	}
}
