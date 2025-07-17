package sec01.exam01;

public class Child extends Parent {
	
	void printName() {
		System.out.println("Child의 printName 실행");
		System.out.println("name : " + name);
		System.out.println("this.name : " + this.name);
		
		String printName = getName();
		System.out.println("printName : " + printName);
		
		System.out.println("super.name : " + super.name);
	}
	
	// shadow : 전달인자가 필드를 가리는 현상
	void setName(String name) {
		this.name = name;
	}
	
	// overshadow : 부모의 필드를 가리는 현상
	String name = "child의 name";
	
	
	/* 생성자 */
	Child(){
//		super(); // 부모의 기본 생성자 호출. 생략 가능
//				  // 맨 첫 줄에 적어야 한다 
		super(1);  // 전달인자 맞춰줘야 함
		
//		this(1); // super와 this 모두 첫 줄에 적어야 해서 같이 사용할 수 없다
		System.out.println("Child 생상자");
	}
	Child(int a){
		super(1); // 전달인자 맞춰줘야 함
		System.out.println("Child 생상자");
	}
	
	
	String getName(){
		System.out.println("Child의 getName 실행");
		return this.name;
	}
}
