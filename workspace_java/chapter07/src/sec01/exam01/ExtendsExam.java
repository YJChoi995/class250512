package sec01.exam01;

public class ExtendsExam {
	public static void main(String[] args) {

		// child를 생성해서 
		// printName 실행		
		Child child = new Child();
		System.out.println("------------");
		child.printName();
		
		System.out.println("child.name의 값 : " + child.name);
		
		System.out.println( child.getName() );
		child.setName("바뀐 이름");
		System.out.println( child.getName() );
		
		
		
		
		
		
	}
}
