package quiz.class1;

public class StudentController extends Student {
	
	StudentController(){
		super("학생이름");
	}
	
	StudentService studentService = new StudentService();
	
	@Override
	String answer(String question) {
		String result = studentService.getInfo(question);
		return result;
	}
	
}
