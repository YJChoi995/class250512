package quiz.cafe;

public class Arbeit {
	
	Cafe cafe;
	
	/* 생성자 */
//	Arbeit(CafeExam c) {
	Arbeit(Cafe cafe) {
		this.cafe = cafe;
	}
	
	void work(String menu, int count) {
		if(cafe instanceof Starbucks) {
			System.out.println("안녕하세요. 스타벅스 입니다");
		}
		
		int money = cafe.order(menu, count);
		if(money == -1) {
			System.out.println("없는 메뉴입니다");
		} else {
			System.out.println("금액: " + money + "원 입니다");
		}
	}
	
	void pay(int money) {
		System.out.println(cafe.pay(money) + "원 돌려드립니다");
		cafe.make();
	}
	
	
}
