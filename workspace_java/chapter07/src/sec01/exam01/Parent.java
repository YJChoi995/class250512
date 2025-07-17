package sec01.exam01;

public class Parent {
	
	/* 필드 */
	String name = "Parent의 name";
	
	/* 메소드 */
	String getName(){
		System.out.println("Parent의 getName 실행");
		return this.name;
	}
	
	/* 생성자 */
//	Parent() {
//		System.out.println("Parent 생성자");
//	}

	Parent(int a) {
		System.out.println("Parent 생성자");
	}
}
