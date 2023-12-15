package com.projeck.blackjack.game;

import java.util.List;

import com.projeck.blackjack.Service.CardService;
import com.projeck.blackjack.Service.GamerService;
import com.projeck.blackjack.model.CardDto;

public class Game2 {
	public static void main(String[] args) {
		CardService cs = new CardService();
		
		// 카드를 만들어서 만든 카드를 주출
		cs.makeDeck();
		List<CardDto> deckList = cs.getDeck();
	
		// 플레이어가 두명이라 가정
		GamerService Dealer = new GamerService(deckList);
		GamerService Player = new GamerService(deckList, "Player");
	
		// 이제 게임 시작 hit 시작 
		Dealer.hit();
		Player.hit();
		
		Dealer.hit();
		Player.hit();
		
		// 만약에 딜러에 점수가 17 미만이면 딜러는 한번더 hit, 그렇지 않으면 플레이어가 hit
		if(Dealer.sumValue() < 17) Dealer.hit();
		Player.hit();
		
		//		while(true) {
//			System.out.println("딜러 합이 17 미만 hit");
//			if(Dealer.sumValue() < 17) Dealer.hit();
//			break;
//		}
		
		
	
	}

}
