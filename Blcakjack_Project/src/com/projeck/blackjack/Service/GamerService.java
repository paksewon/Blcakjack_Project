package com.projeck.blackjack.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.projeck.blackjack.model.CardDto;
import com.projeck.blackjack.utils.Line;

public class GamerService {

	// 각 플레이어가 받은 카드를 저장할 List
	private Scanner scan = null;
	List<CardDto> myCardList;
	List<CardDto> player = null;

	public GamerService() {
		this.scan = new Scanner(System.in);

	}

	// deck 에서 한장씩 플레이어에게 전달할 카드들
	List<CardDto> pubCardList; // 딜러는안보여주고 고니꺼는 보여줘야한다

	// 플레이어 이름을 지정하지 않고 카드만 받은 경우에 두번째 있는 생성자 생성
	// 플레이어 이름이 없는 상태로 생성이되면 요걸 딜러로 실행하겠다
	public GamerService(List<CardDto> cardList) {
//		this(cardList, "Dealer");
		this.player = new ArrayList<CardDto>();

	}
//	CardDto cardDto = new CardDto();
//	CardService cardService = new CardService();

	public GamerService(List<CardDto> cardList, String playName) { // 연결시켜주기
		myCardList = new ArrayList<CardDto>(); // myCardLsit는 직접생성해줄것이다
		pubCardList = cardList;

//		List<CardDto>dealerHand = new ArrayList<CardDto>();
//		List<CardDto>plyerHand = new ArrayList<CardDto>();
	}

	// 자신이 받은 카드의 점수를 계산하는 method
	public int sumValue() {
		int sumValue = 0;
		for (CardDto dto : myCardList) {
			sumValue += dto.getValue();
		}
		return sumValue; // 이 값을 외부에서 쓸수 있기 때문에 리턴값은 sumValue로 int 형으로
	}

	// 각 선수들이 hit 를 했을때 수행할 method
	public void hit(String player) {

		while (true) {
			if (player.equals(player)) {
				System.out.print("카드를 더 받으시겠습니까? hit or stop : ");
				String str = scan.nextLine();
				if (!str.equals("HIT") && !str.equals("STOP")) {
					System.out.println("정상적인 값 입력 바람");
					System.out.printf("입력한 값 : (%s)\n", str);
					continue;
				}
				if (str.equals("STOP")) {
					break;
				}
				if (str.equals("HIT")) {
					System.out.println("추가한 카드 : ");
					System.out.println("카드를 받았습니다");
				}
				
				
				
			}
		} // end while
		if (player.equals(player) && sumValue() > 16) { // 딜러규칙 : 16이상이면 hit 금지
			System.out.println("Dealer 점수 : " + sumValue());
			System.out.println("Dealer Hit 금지!!");

		} else {
			// 받은 카드를 내 카드 리스트에 추가
			myCardList.add(pubCardList.get(0));

			// 받을 카드에서 첫번 1장을 제외
			pubCardList.remove(0);
		}

		Line.dLine(50);
//		System.out.println(playerName);
		Line.sLine(50);

		// 현재 보유중인 카드 리스트를 보여주기
		for (CardDto dto : myCardList) {
			System.out.println(dto);
		}
		Line.sLine(50);
		System.out.println("현재점수 : " + sumValue());
	}
//	public CardDto receive() {
//		return cardDto;

}

//}
