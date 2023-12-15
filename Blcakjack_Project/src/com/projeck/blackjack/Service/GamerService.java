package com.projeck.blackjack.Service;
/*
 * 2개의 리시트를 가지고 마이덱크 리스크 또하나는 퍼블리덱크 리스크
 */
import java.util.ArrayList;
import java.util.List;

import com.projeck.blackjack.model.CardDto;
import com.projeck.blackjack.utils.Line;

public class GamerService {

	// 각 플레이어가 받은 카드를 저장할 List
	List<CardDto> myCardList;
//	private Scanner scan = null;

	// deck 에서 한장씩 플레이어에게 전달할 카드들
	List<CardDto> pubCardList; 
	String playerName;

	// 플레이어 이름을 지정하지 않고 카드만 받은 경우에 두번째 있는 생성자 생성
	// 플레이어 이름이 없는 상태로 생성이되면 요걸 딜러로 실행하겠다
	public GamerService(List<CardDto> cardList) { 
		this(cardList, "Dealer"); 
		// 플레이어 이름을 지정하지 않은 상태로 덱크만 받은 경우에 이 생성자로 호출 이름 을 딜러로 설정
		// 플레이어 이름이 없는 상태로 생성이 되면 이걸 딜러로 쓰겠다 라는 생성자 호출
//		this.scan = new Scanner(System.in);
	}
//	CardDto cardDto = new CardDto();
//	CardService cardService = new CardService();

	public GamerService(List<CardDto> cardList, String playName) { // // 생성자 선언 하고 매개변수로 리스트에 댁크리스트와 플레이어 이름을 연결시켜줄것이다
		myCardList = new ArrayList<CardDto>(); // myCardLsit는 직접생성해줄것이다
		pubCardList = cardList;
		playerName = playName;
//		List<CardDto>dealerHand = new ArrayList<CardDto>();
//		List<CardDto>plyerHand = new ArrayList<CardDto>();
	}

	// 자신이 받은 카드의 점수를 계산하는 method
	public int sumValue() {
		int sumValue = 0;
		for(CardDto dto : myCardList) { 
			sumValue += dto.getValue();
		}
		return sumValue; // 이 값을 외부에서 쓸수 있기 때문에 리턴값은 sumValue로 int 형으로
	}
	
	// 각 선수들이 hit 를 했을때 수행할 method
	public void hit() {
//		while (true) {
//			if (player.equals(player)) {
//				System.out.print("카드를 더 받으시겠습니까? hit or stop : ");
//				String str = scan.nextLine();
//				if (!str.equals("HIT") && !str.equals("STOP")) {
//					System.out.println("정상적인 값 입력 바람");
//					System.out.printf("입력한 값 : (%s)\n", str);
//					continue;
		// 플레이어 이름이 딜러이고 점수가 16보다 크면 점수 보여주고 딜러 히트 금지 표시
		if(playerName.equals("Dealer") && sumValue() > 16) { // 딜러규칙 : 16이상이면 hit 금지
			System.out.println("Dealer 점수 : " + sumValue());
			System.out.println("Dealer Hit 금지!!");
		} else { // 그렇지 않으면 한장 받는다
			// 받은 카드를 내 카드 리스트에 추가
			myCardList.add(pubCardList.get(0));
		
			// 받을 카드에서 첫 번째 1장을 제외 
			pubCardList.remove(0);
		}
		
		Line.dLine(50);
		System.out.println(playerName);
		Line.sLine(50);
		
		// 현재 보유중인 카드 리스트를 보여주기
		for(CardDto dto: myCardList) {
			System.out.println(dto);
		}
		Line.sLine(50);
		System.out.println("현재점수 : " + sumValue());
	}
}

//}
