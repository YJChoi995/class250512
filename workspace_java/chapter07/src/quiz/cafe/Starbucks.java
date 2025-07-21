package quiz.cafe;

import java.util.HashMap;

public class Starbucks extends Cafe {
	Starbucks(){
		super("백자빌딩", "스타벅스 천안역점");
		
		HashMap map = new HashMap();
		map.put("아이스 아메리카노", 4500);
		map.put("핫 아메리카노", 4000);
		setMenuMap(map);
	}
	
	@Override
	void make() {
		System.out.println(this.menu + "를 만듭니다");
	}
}
