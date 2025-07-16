package sec01.exam01;

public class Child extends Parent {
	
	void printName() {
		System.out.println("Child의 printName 실행");
		System.out.println("name : " + name);
		System.out.println("this.name : " + this.name);
		
		String printName = getName();
		System.out.println("printName : " + printName);
	}
	
	// shadow : 전달인자가 필드를 가리는 현상
	void setName(String name) {
		this.name = name;
	}
	
	// overshadow : 부모의 필드를 가리는 현상
	
	
}
