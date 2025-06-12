package sec01.exam01;

public class StudentExam {
	public static void main(String[] args) {
	
		Student s1 = new Student(); // 힙 영역에 올라감
		
		Student s2 = new Student(); // s1와는 다른 개체
		
		System.out.println(s1 == s2); // false
		
		Student s3 = null;
		s3 = s1;
		System.out.println(s1 == s3); // true
		
		s1 = null;
		s3 = null;
		
		System.out.println(s1 == s3); // null이니까 상태가 같음으로 봄
		
		
		System.out.println(s2); // 
	
	}
	
}


