package sec04.exam03_return;

public class Student {

	/* 필드 문제 */
	/* 학생 클래스를 만들고
	 * 이름과 나이 필드를 만든다
	 * 학생Exam 클래스를 만들고
	 * 학생 2명을 각각 등록하고 
	 * 두 학생의 정보를 각각 출력
	 */
	
	String name;
	int age;
	

	/* 메소드 문제 */
	/* 메소드를 통해서
	 * 이름과 나이를 전달해서 저장하기
	 * 이름과 나이를 돌려받아서 출력하기
	 */
	
	// 이름값과 나이값을 전달 받아서 필드에 저장하는 메소드
	void setName(String a) {
		name = a;
	}
	
	void setAge(int b) {
		age = b;
	}
	
	// 이름 필드와 나이 필드의 값을 돌려주는 메소드
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
	
	// 이름과 나이를 한번에 받아서 저장
	// 메소드명: setInfo
	// 전달인자: String n, int a
	// 리턴타입: void
	
	void setInfo(String n, int a) {
		name = n;
		age = a;
	}
	
	// 배열로 한번에 return하기
	String[] getInfo() {
		String[] a = {name, ""+age};
		return a;
	}
	
	// return 방법 2
	String getInfo1() {
		return name + ""+age;
	}
	

}
