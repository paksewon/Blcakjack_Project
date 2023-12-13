package com.projeck.blackjack.game;

import java.util.List;

import com.projeck.blackjack.Service.CardService;
import com.projeck.blackjack.Service.GamerService;
import com.projeck.blackjack.model.CardDto;

public class Game2 {
	public static void main(String[] args) {
		CardService cs = new CardService();
		
		// 카드를 만들어서 만든 카드를 주출해오기
		cs.makeDeck();
		List<CardDto> deckList = cs.getDeck();
	
		// 플레이어가 두명이라 가정
		GamerService 딜러 = new GamerService(deckList);
		GamerService 고니 = new GamerService(deckList, "고니");
	
		// 이제 게임 시작 hit 시작
		딜러.hit();
		고니.hit();
		
		딜러.hit();
		고니.hit();
		
		// 17 미만이면 딜러는 한번더 hit, 그렇지 않으면 고니가 hit
		if(딜러.sumValue() < 17) 딜러.hit();
		고니.hit();
		
		if(딜러.sumValue() < 17) 딜러.hit();
		고니.hit();
		
		if(딜러.sumValue() < 17) 딜러.hit();
		고니.hit();
		
	
	}

}
