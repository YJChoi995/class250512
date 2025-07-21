package quiz.class1;

import java.util.HashMap;

public class StudentDAO {
	HashMap map = new HashMap();

	StudentDAO(){
		map.put("사탕", "청포도");
		map.put("점심", "달식당");
		map.put("회식", "어디로가요?");
		map.put("휴식", "네!!!");
	}

	String selectAnswer(String question) {
			return (String)map.get(question);
	}

}
