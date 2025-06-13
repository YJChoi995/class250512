package quiz;

public class FruitMarket_teacher {
	/* 필드 */
	// 필드는 변수고, 변수는 뭔가를 저장할 수 있음
	String name; 	// 업체명 
	String address; // 업체 주소
	
//	String apple = "사과";
//	int applePrice = 1000;
//	
//	String tomato = "토마토";
//	int tomatoPrice = 2000;
	
//	Fruit_teacher apple = new Fruit_teacher();
//	Fruit_teacher tomato = new Fruit_teacher();
	
	Fruit_teacher[] fruits = new Fruit_teacher[2];


	/* 생성자 */
	// new 하자 마자 실해되는 메소드의 일종
	FruitMarket_teacher(String name, String address){
		this.name = name;
		this.address = address;
		
		System.out.println("*** " + name + " " + address + "점에 어서오세요 ***");
		
//		apple.name = "사과";
//		apple.price = 10000;
//		apple.stock = 5;
		init(); // 메소드로 빼서 실행시킴
	}
	
	
	/* 메소드: 동작, 작동*/
	
	void init() {
//		apple.name = "사과";
//		apple.price = 1000;
//		apple.stock = ;
//		
//		tomato.name = "토마토";
//		tomato.price = 2000;
//		tomato.stock = 10;
		
		fruits[0] = new Fruit_teacher();
		fruits[0].name = "사과";
		fruits[0].price = 1000;
		fruits[0].stock = 5;
		
		fruits[1] = new Fruit_teacher();
		fruits[1].name = "토마토";
		fruits[1].price = 2000;
		fruits[1].stock = 10;
	}
	
	// 과일 목록 전체 출력
	// 메소드명 : print
	// 전달인자 : 없음
	// 리턴타입 : void
	void print() {		
		System.out.println("** 전체 과일 목록 **");
//		System.out.println(this.apple + " : " + applePrice + "원");
//		System.out.println(this.tomato + " : " + applePrice + "원");
//		System.out.println("수박");
//		System.out.println("자두");
		for(int i=0; i<2; i++) {
			System.out.println(fruits[i].name + " " + fruits[i].price + "원 " + fruits[i].stock + "개");
		}
	}
	
	// 과일 가격 문의
	// 메소드명 : ask
	// 전달인자 : 과일명
	// 리턴타입 : 가격(int)
//	int ask(String fruitName) {
//		if (this.apple.equals(fruitName)) {
//			// return 1000;
//			return applePrice;
//		} else if(this.tomato.equals(fruitName)) {
//			// return 2000;
//			return tomatoPrice;
//		} else {
//			System.out.println("그런 과일 없습니다");
//			return -1;
//		}
//	}
	
	int ask2(String fruitName) {
		// 전체 과일 중에서
		for(int i=0; i<fruits.length; i++) {
			// 전달받은 이름과 같은게 있다면
			if(this.fruits[i].name.equals(fruitName)) {
				// 가격을 돌려줘라
				return this.fruits[i].price;
			}
		}
		System.out.println("그런 과일 없습니다");
		return -1;
	}

	// 기존 배열에 새로운 과일클래스를 추가
	// 메소드명 : addFruit
	// 전달인자 : Fruit_teacher
	// 리턴타입 : void
	void addFruit(Fruit_teacher fruit) {
		/* 기존 것의 마지막에 하나 추가 */
		
		// 기존 것보다 하나 큰 배열 만들기
		Fruit_teacher[] newFruits = new Fruit_teacher[this.fruits.length+1];
		
		// 기존 것 복사
		for (int i=0; i<this.fruits.length; i++) {
			newFruits[i] = fruits[i];
		}
		
		// 마지막 추가 
		newFruits[newFruits.length - 1] = fruit;
		
		// 새 배열을 기존 배열에 덮어쓰기
		this.fruits = newFruits;
	}
	
	



}
