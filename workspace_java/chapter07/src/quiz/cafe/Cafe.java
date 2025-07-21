package quiz.cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class Cafe {
	
	// 필드
	/*
	 * 가격+메뉴s
	 * 가게이름
	 * 비품s
	 * 건물 = null
	 * 직원s
	 */
	String building; // 건물명
	String name;     // 가게이름
	int emp;         // 직원수
	private HashMap menuMap; // 메뉴 : 가격
	HashMap getMenuMap() {
		return this.menuMap;
	}
	void setMenuMap(HashMap menuMap) {
		this.menuMap = menuMap;
	}
	void putMenu(String menu, int price) {
		this.menuMap.put(menu, price);
	}
	
	ArrayList list;  // 비품
	int money = -1;  // 받아야하는 돈
	String menu;     // 주문받을 메뉴
	int count;       // 주문한 개수
	
//	{
//		아이스 아메리카노: 3000,
//		핫 아메리카노: 2500
//	}
	
	// 생성자<카페 차리기>
	/* 건물명 설정,
	 * 가게이름 설정 
	 * 직원 몇명 고용(추후수정가능), 
	 * 메뉴+가격(추후 수정 가능)
	 */
	Cafe(String building, String name, int emp, HashMap menuMap){
		this.building = building;
		this.name = name;
		this.emp = emp;
		this.menuMap = menuMap;
	}
	Cafe(String building, String name){
		this(building, name, 0, null);
	}
	
	// 메소드
	/* 주문받기, 결제하기, 커피만들기(리턴:커피), 설거지, 마감, 서빙, 메뉴추가
	 */
	
	// 주문받기
	// 메뉴와 개수를 입력하면,
	// 메뉴의 가격을 구하고
	// 		메뉴가 없으면 -1을 return
	//		메뉴가 있으면 개수를 곱해서 return
	int order(String menu, int count) {
		System.out.println("---- 주문 내역 ----");
		System.out.println("menu: " + menu + ", count: " + count);
		
		int money = -1;
		
		if(this.menuMap.get(menu) != null) {
			money = (int)this.menuMap.get(menu) * count;
			this.menu = menu;
			this.count = count;
		}
		
		this.money = money;
		return money;
	}
	
	// 결제하기
	// 메소드명: pay
	// 전달인자: int money
	// 리턴타입: int 거스름돈
	int pay(int money) {
		if(this.money == -1) {
		// 주문 내역이 없는 상태
			return money;
		} else if(this.money <= money) {
		// 받은 금액이 결제할 금액 이상일 때
			return money - this.money;
//		} else if(this.money > money){
		} else {
		// 받은 금액이 결제할 금액 미만일 때
			return money;
		}
	}
	
	// 서빙
	// 메소드명 : serve
	// 전달인자 : 주문 받은 메뉴와 개수
	// 리턴타입 : void
	void serve() {
		System.out.println("주문하신 " + this.menu + ", " + this.count + " 나왔습니다");
	}
	
	void make() {
		System.out.println(this.menu + "만듭니다");
		serve();
	}
	

}
