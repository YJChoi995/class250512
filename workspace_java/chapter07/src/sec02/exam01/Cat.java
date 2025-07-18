package sec02.exam01;

public class Cat extends Animal {
	
	int age = 3;
	
	@Override
	void eat() {
		System.out.println("고양이: 냠냠");
	}
	
	@Override
	void think() {
		System.out.println("고양이: 인간은 모르지");
	}
	
	void clean() {
		System.out.println("고양이: 셀프 케어");
	}
	
	void grooming() {
		System.out.println("고양이 세수");
	}
}
