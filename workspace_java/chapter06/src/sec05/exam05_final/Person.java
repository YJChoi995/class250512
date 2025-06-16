package sec05.exam05_final;

public class Person {
	
	final String nation = "Korea";
	final String ssn;
	String name;
	
	
	// final : 값이 할당된 경우 변경할 수 없게 막아줌
	Person(){
		// final 값을 선언하지 않은 경우 생성자에서 한번만 초기화 허용해줌
		this.ssn = "주민번호"; 
		this.name = "이름";
//		this.nation = "다른나라"; // 바뀌지 못하게 막혔음
		
		this.name = "이름2";
//		this.ssn = "주민번호2"; // final 필드는 다시 할당할 수 없음
	}
	
	void test() {
//		this.ssn = "주민번호"; // 메소드에선 final 값 수정 안됨
	}

}
