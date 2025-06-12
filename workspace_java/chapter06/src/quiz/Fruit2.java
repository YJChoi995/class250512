package quiz;

public class Fruit2 {

/* 필드 */
//	이름 배열
//	가격 배열
//	재고 배열
	String[] fruitName;
	int[] fruitPrice;
	int[] stock;

	
/* 생성자 */
//	가게명 필수
	Fruit2(String marketName) {
		System.out.println(marketName + "에 어서오세요");
	}
	
//	# 메소드
//	void 전체목록출력()
//	가격 가격문의(과일 종류, 갯수)
//	거스름돈 결제(과일 종류, 갯수, 금액) (과일은 아직 하나씩만)
//  택배(주소, 종류, 갯수)
	
	// 전체 과일과 가격 목록 출력 메소드
	void displayAll() {
		System.out.println("** 전체 과일 목록 **");
		for(int i=0; i<fruitName.length; i++) {
			System.out.println(fruitName[i] + ", 가격: " + fruitPrice[i] + "원");
		}
	}
	
	
	// 과일의 가격을 물어보는 메소드
	int askPrice2(String fruit, int count){
		int price = 0;
		for(int i=0; i<fruitName.length; i++) {
			if(fruitName[i].equals(fruit)) {
				System.out.println("가져오신 과일: " +  fruitName[i] + ", 갯수 : " + count + "개");
				System.out.println("총 " + (fruitPrice[i] * count) + "원 입니다");
				price = fruitPrice[i] * count;	
			}
		}
		return price;
	}
	

	
	// 결제하고 거스름돈 내는 메소드
	int payment2(String fruit, int count, int price) {
		System.out.println("결제하겠습니다");
		
		int change = 0;
		for(int i=0; i<fruitName.length; i++) {
			if(fruitName[i].equals(fruit)) {
				System.out.println("구매 목록: " + fruitName[i] + " " + count + "개");
				System.out.println("총 " + (fruitPrice[i]*count) + "원 입니다");
				
				change = price - (fruitPrice[i] * count);
				System.out.println("내신 돈: " + price + "원, 거스름돈 " + change + "원 입니다");
			}
		}
		return change;
	}
	
	// 택배 보내는 메소드 : (주소, 종류, 갯수)
	void baedal(String address, String fruit, int count){
		for(int i=0; i<fruitName.length; i++) {
			if(fruitName[i].equals(fruit)) {
				System.out.println("배달 받으실 주소: " + address);
				System.out.println("받으실 품목: " + fruitName[i] + ", " + count + "개");
				System.out.println("배달이 완료되었습니다");
			}
		}
	}

	

}
