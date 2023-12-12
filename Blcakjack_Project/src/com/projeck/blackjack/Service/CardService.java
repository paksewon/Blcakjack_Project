package com.projeck.blackjack.Service;
/*
 * 1벌의 게임카드 생성
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.projeck.blackjack.model.CardDto;

public class CardService {
	String suit = "클로버(♣),다이아몬드(◆),스페이드(♠),하트(♥)";
	String value = "A,2,3,4,5,6,7,8,9,10,K,Q,J";
	String[] arrSuit = new String[] {
			"클로버(♣)",
			"다이아몬드(◆)",
			"스페이드(♠)",
			"하트(♥)"
	};
	
	private List<CardDto> deckList;
 
	public CardService() {
		this.deckList = new ArrayList<CardDto>();
	}

	public List<CardDto> getDeck() { // 반복문을 돌리는 과정에서 셔플을 돌리면 어떻게 될까?	
		int Size = deckList.size();
		for(int i = 0; i < Size; i++) {
			Collections.shuffle(this.deckList);
		}
		for(CardDto dto : deckList) {
			Collections.shuffle(this.deckList);
		}
		return this.deckList;
	}

	public void makeDeck() {
		String[] suits = suit.split(",");
		String[] values = value.split(",");
		for (String suit : arrSuit) { // 52번 반복루트
			for (String value : values) {
				
				// 각 카드가 갖게 될 value 를 생성
				// value 값은 values 를 기준으로 생성
				// 2~9까지는 보이는 값 그대로
				// A는 1로 JQKA는 10으로 
				
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

	public CardDto getRandomCard() { // 카드 1장 뽑기
		int size = deckList.size();
		int select = (int) (Math.random() * size);
		return deckList.get(select);
	}
}
