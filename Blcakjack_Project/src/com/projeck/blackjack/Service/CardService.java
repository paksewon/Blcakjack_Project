package com.projeck.blackjack.Service;
/*
 * 1벌의 게임카드 생성
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.projeck.blackjack.model.CardDto;

public class CardService {
	private List<CardDto> deckList;

	String suit = "클로버(♣),다이아몬드(◆),스페이드(♠),하트(♥)";
	String[] arrSuit = new String[] {
			"클로버(♣)", "다이아몬드(◆)", "스페이드(♠)", "하트(♥)"};
	String value = "A,2,3,4,5,6,7,8,9,10,K,Q,J"; // 문자들은 오류가 난다
 
	public CardService() { // 생성자 만들어주기
		this.deckList = new ArrayList<CardDto>();
	}

	public List<CardDto> getDeck() { // 카드를 섞기위해	
		int Size = deckList.size();
		for(int i = 0; i < Size; i++) {
			Collections.shuffle(this.deckList); // 셔플안에다가 만들어논 카드덱리스트를 넣는다
		}
		for(CardDto dto : deckList) {
			Collections.shuffle(this.deckList);
		}
		return this.deckList;
	}

	public void makeDeck() { // 카드 점수 맥이는 곳, 52장
		String[] suits = suit.split(","); // 알파벳 단위로 만들어준다
		String[] values = value.split(",");
		for (String suit : arrSuit) { // 이중 for 문이 되어서 52번 반복루트가됨
			for (String value : values) {
				
				// 각 카드가 갖게 될 value 를 생성
				// value 값은 values 를 기준으로 생성
				// 2~9까지는 보이는 값 그대로
				// A는 1로 JQKA는 10으로 
				
				int intValue = 0;
				try {
					// 숫자 2~9~0 까지는 각각 값들이 정수로
					// 정상 변환 될것이다
					// 남은 문자들은 exception 이 발생, 캐치 다음 문장이 실행된다
					intValue = Integer.valueOf(value); // 숫자로 바꿔준다
//					if(intValue == 0) intValue = 10; 
				} catch (Exception e) {
					if (value.equals("A")) {
						intValue = 1;
					} else
						intValue = 10; // 나머지 밸류는(JKQ) 10으로 세팅

				}

				CardDto dto = new CardDto();
				dto.setCardSuit(suit);
				dto.setDenomination(value);
				dto.setValue(intValue); // int 밸루 값, int 밸류 점수
				deckList.add(dto); // 댁크 리스트가 생성
				
//				Collections.shuffle(deckList);
//				CardDto blackjack = new CardDto();
//				blackjack.setCardSuit(suit);
//				blackjack.setDenomination(value);
//				blackjack.setValue(intValue);
//				deckList.add(blackjack);
			} 
		}
	}
	public CardDto getRandomCard() { // 카드 1장 랜덤 뽑기
		int size = deckList.size();
		int select = (int) (Math.random() * size);
		return deckList.get(select);
	}
}