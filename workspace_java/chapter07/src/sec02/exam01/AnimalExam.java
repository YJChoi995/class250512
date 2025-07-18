package sec02.exam01;

public class AnimalExam {
	public static void main(String[] args) {

		Animal a1 = new Animal();
		a1.think();
		a1.eat();
		
		
		Cat cat = new Cat();
		cat.eat();
		cat.grooming();
		
		Animal a2 = (Animal)cat; // 자식이 부모 타입이 될 때
		Animal a3 = cat;		 // 형 변환 연산자 생략 가능(자동 타입 변환)
		
		a2.eat();
//		a2.clean(); // 부모에 없는 메소드는 실행이 안된다
		
		Dog dog = new Dog();
		Animal a5 = dog;
		
		Animal a4 = new Dog();
		
//		new AnimalExam().catMom(cat);
		catMom(cat);
		
		animalCare(a4);
		animalCare(new Cat());

	}
	
	static void catMom(Cat cat) {
		cat.eat();
		cat.grooming();
	}
	
	static void animalCare(Animal animal) {
		System.out.println("동물의 나이: " + animal.age);
		animal.eat();
		animal.think();
	}
	
	
}
