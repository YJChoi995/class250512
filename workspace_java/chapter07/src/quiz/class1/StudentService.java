package quiz.class1;

public class StudentService {
	
	StudentDAO studentDAO = new StudentDAO();
	
	// 머릿속
	String getInfo(String question) {
		String result = studentDAO.selectAnswer(question);
		if(result == null) {
			result = "(신중히 생각 더 해봐야겠음)";
		} else {
			result = "흐음.. 저는요 "+ result +" 이거요!";
		}

		return result;
	}
}
