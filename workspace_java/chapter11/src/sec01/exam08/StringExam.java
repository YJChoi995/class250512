package sec01.exam08;

public class StringExam {
	
	public static void main(String[] args) {
		
		String s1 = "영일이삼사오육칠팔구";
		
		/* chatAt */
//		char c1 = 'a';
		char c1 = s1.charAt(0);
		System.out.println("char c1: " + c1);
		
		/* indexOf */
		int i1 = s1.indexOf("삼사");
		System.out.println("i1: " + i1);
		
		/* lastIndexOf */
		int i2 = s1.lastIndexOf("삼사");
		System.out.println("i2: " + i2);
		
		int i3 = s1.indexOf("a");
		System.out.println("i3 없을 때: " + i3); // 값: -1
		
		/* 문제 풀기 */
		// 이메일 양식 점검
		// @와 .이 하나 이상 있는가?
		String email = "mail@naver.com";
		
		if(email.indexOf("@") != -1 && email.indexOf(".") != -1) {
			System.out.println("허용되는 메일 양식입니다");
		}
		
		// indexOf 구현
		// email에 첫 @가 몇번째에 있는지
		int idx = -1;
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i) == '@') {
				idx = i;
				System.out.println("@의 인덱스: " + idx);
			}
		}
		
		
		/* replace */
		String s2 = s1.replace("삼사", "34");
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		// replace는 모두 바꿔준다
		
		/* substring */
		String s3 = s1.substring(5, 8);
		System.out.println("s3: " + s3);
		
		// 주민번호로 남자인지 여자인지 출력
		String ssn = "123456-1234567";
		if(ssn.charAt(7) == '1' || ssn.charAt(8) == '3') {
			System.out.println("남성 입니다");
		} else {
			System.out.println("여성 입니다");
		}
		
		// 선생님 답
		int start = ssn.indexOf("-") + 1;
		int end = start + 1;
		String s4 = ssn.substring(start, end);
		if( s4.equals("1") || s4.equals("3") ) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		
		/* 문제 풀기 */
		// Q1. blog.naver.co.kr에서 naver만 추출하기
		String q1 = "blog.naver.co.kr";

		
		
		// Q2. "Hello world" -> "ello world H" -> "llo world He"식으로 흘러가게 보이게 하기
		
		// Q3. humanec@naver.com -> hu*****@naver.com 으로 마스킹하기
			// love@naver.com -> lo**@naver.com으로  
		String q3 = "humanec@naver.com";
		int end_q3 = q3.indexOf("@"); // "@"의 인덱스 값
		String visible = q3.substring(0, 2); // 처음부터 두 글자 보이기
		String mask = q3.substring(2, end_q3); // 마스킹 대상. 세번째 글자부터 @ 앞까지 자르기
		String domain = q3.substring(end_q3); // "@"부터 끝까지 자르기
		String masking = "*".repeat(mask.length()); // 마스킹 하기
		
		String result = visible + masking + domain;
		System.out.println(result);
		
		String q3_2 = "love@naver.com";
		int end_q3_2 = q3_2.indexOf("@"); // "@"의 인덱스 값
		String visible2 = q3_2.substring(0, 2); // 처음부터 두 글자 보이기
		String mask2 = q3_2.substring(2, end_q3_2); // 마스킹 대상. 세번째 글자부터 @ 앞까지 자르기
		String domain2 = q3_2.substring(end_q3_2); // "@"부터 끝까지 자르기
		String masking2 = "*".repeat(mask2.length()); // 마스킹 하기
		
		String result2 = visible2 + masking2 + domain2;
		System.out.println(result2);
		

		
	}

}
