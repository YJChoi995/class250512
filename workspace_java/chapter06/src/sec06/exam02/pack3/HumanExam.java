package sec06.exam02.pack3;

import sec06.exam02.pack2.Human;
//import sec06.exam02.pack1.Human; // 동일한 클래스명이라 import안됨

public class HumanExam {
	public static void main(String[] args) {

		new Human(); // pack2.human
		new sec06.exam02.pack1.Human();

		
		// import java.lang.* 자동 선언 되어서 import 생략 가능
		String a = "1";
		System.out.println();
		Math.random();
	}

}
