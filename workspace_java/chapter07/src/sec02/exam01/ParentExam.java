package sec02.exam01;

public class ParentExam {
	public static void main(String[] args) {

		Parent1_1_1 p1_1_1 = new Parent1_1_1();
		
		Parent1_1 p1_1 = (Parent1_1)p1_1_1;
		p1_1 = p1_1_1; // 형변환 생략가능
		
		Parent1 p1 = p1_1;
		p1 = p1_1_1;
		
		Parent1 pp1 = new Parent1_1_1();
		
		///////////////////////////////////////////////////////
		
		Parent1_2  p1_2 = new Parent1_2();
		Parent1 ppp1 = p1_2;
		
		// 부모가 자식이 될 때는 
		// 형변환 연산자 생략 불가능
		Parent1_2 pp1_2 = (Parent1_2)ppp1;
		
		// 런타임runtime 오류 : 실행해봐야 아는 것
		Parent1_2 ppp1_2 = (Parent1_2)pp1;
		
	}

}
