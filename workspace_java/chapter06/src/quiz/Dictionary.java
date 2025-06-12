package quiz;

public class Dictionary {
	/*
	 * 전자사전
	 * 단어 En2Ko(영단어) : 영단어를 받으면 한국어를 리턴
	 * 영단어 Ko2En(단어) : 한국어를 받으면 영단어를 리턴
	 * String[] en = {love, hate, devil, angel}
	 * String[] ko = {사랑, 증오, 악마, 천사}
	 */
	
	
	// 필드
	String[] en = {"love", "hate", "devil", "angel"};
	String[] ko = {"사랑", "증오", "악마", "천사"};
	

	/* 생성자 */
	Dictionary(){
		System.out.println("검색할 단어를 입력하세요");
	}
	
	/* 메소드 */
	
	// 검색할 단어를 받을 메소드

	
	// 영어를 한국어로 번역하는 메소드
	String en2ko(String english) {
		for(int i=0; i<en.length; i++) {
//			if (english.equals(en[i])) { // string은 참조타입이라 null값이 올 수 있음
			if(en[i].equals(english)) {
				System.out.println(en[i] + " means " + ko[i]);
				return en[i];
			}	
		}
		return "검색되지 않는 단어입니다";
	}
	
	// 한국어를 영어로 번역하는 메소드
	String ko2en(String korean) {
		for(int i=0; i<en.length; i++) {
			if (korean.equals(ko[i])) {
				System.out.println(ko[i] + " 뜻 " + en[i]);
				return ko[i];
			}	
		}
		return "검색되지 않는 단어입니다";
	}
	
	
}
