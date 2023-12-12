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
	String value = "A,2,3,4,5,6,7,8,9,10,K,Q,J"; // 문자들은 이샙션이 일어나는데 그걸 역으로 이용하자
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
					// 숫자 2~9~0 까지는 각각 값들이 정수로
					// 정상 변환 될것이다
					// 문자들은 익셉션 발생 캐치 다음 문장이 실행된다
					intValue = Integer.valueOf(value); // 숫자로 바꿔준다
					if(intValue == 0) intValue = 10; // 10으로 세팅해야 밸류 값이 정상적으로 실행
				} catch (Exception e) {
					if (value.equals("A")) {
						intValue = 1;
					} else
						intValue = 10; // 나머지 밸류는 10으로 세팅

				}
				
				CardDto dto = new CardDto();
				dto.setCardSuit(suit);
				dto.setDenomination(value);// int 밸루 값
				dto.setValue(intValue);
				
//				Collections.shuffle(deckList);
//
//				CardDto blackjack = new CardDto();
//				blackjack.setCardSuit(suit);
//				blackjack.setDenomination(value);
//				blackjack.setValue(intValue);
//				deckList.add(blackjack);

			} 
		}
	}

	public CardDto getRandomCard() { // 카드 1장 뽑기
		int size = deckList.size();
		int select = (int) (Math.random() * size);
		return deckList.get(select);
	}
}
