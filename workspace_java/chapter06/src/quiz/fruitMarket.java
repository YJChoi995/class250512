package quiz;

public class fruitMarket {
	public static void main(String[] args) {
		// 가게 이름 출력
		Fruit fruit = new Fruit("1호점");
		
		
		
		System.out.println();
		
		// 전체 과일과 가격 목록 출력
		fruit.displayAll();
		
		System.out.println();
		
		// 과일의 가격을 질문
		System.out.println("이 과일은 얼마입니까?");
		fruit.askPrice("사과", 4);
		System.out.println();
		
		fruit.askPrice2("용과", 3);
		System.out.println();
		
		// 결제하고 거스름돈 받는 출력(입력값: 과일 종류, 갯수, 낼 돈)
		fruit.payment("청포도", 3, 20000);
		System.out.println();
		
		fruit.payment2("망고", 5, 50000);
		System.out.println();
		
		// 배달 시키기(입력값: 주소, 과일 종류, 갯수)
		fruit.baedal("불당동", "망고", 3);

	}

}
