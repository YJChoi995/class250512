package quiz;

public class FruitMarket_teacherExam {

	public static void main(String[] args) {

		FruitMarket_teacher market = new FruitMarket_teacher("청과점", "천안");
		System.out.println();
		
		//전체 과일 목록 출력
		market.print();
		System.out.println();
		
		// 가격 묻는 
		int price = market.ask2("토마토");
		System.out.println("토마토 가격은? " + price + "원");
		
		// 새로운 과일 추가
		Fruit_teacher pineapple = new Fruit_teacher();
		pineapple.name = "파인애플";
		pineapple.price = 3000;
		pineapple.stock = 15;
		
		market.addFruit(pineapple);
		
		// 가격 묻는 
		price = market.ask2("파인애플");
		System.out.println("파인애플 가격은? " + price + "원");

		
	}
}
