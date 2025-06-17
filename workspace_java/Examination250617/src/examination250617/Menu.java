package examination250617;

import java.util.Scanner;

public class Menu {
	/* 필드 */

	
	
	/* 생성자 */
	Menu(){
		System.out.println("작업을 시작합니다");
	}
	
	
	/* 메소드 */
	Scanner scan = new Scanner(System.in);

     void start() {
        while (true) {
            System.out.println("\n=== 커피 종류 선택 ===");
            System.out.println("1. 아메리카노 (3000원)");
            System.out.println("2. 라떼 (3500원)");
            System.out.println("3. 콜드브루 (4000원)");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String coffee = "";
            int price = 0;

            switch (choice) {
                case 1:
                    coffee = "아메리카노";
                    price = 3000;
                    break;
                case 2:
                    coffee = "라떼";
                    price = 3500;
                    break;
                case 3:
                    coffee = "콜드브루";
                    price = 4000;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    continue;
            }

            System.out.println("\n선택한 커피: " + coffee);
            System.out.println("총 가격: " + price + "원");
        }
    }
	
	
}
