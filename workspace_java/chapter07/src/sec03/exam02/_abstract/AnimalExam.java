package sec03.exam02._abstract;

public class AnimalExam {
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("----------------------");
		
		Animal a = new Dog();
		a.sound();
		Dog dog1 = (Dog)a;
		System.out.println("----------------------");
		
		testSound(dog);
		
	}
	
	static void testSound(Animal animal) {
		animal.sound();
	}

}
