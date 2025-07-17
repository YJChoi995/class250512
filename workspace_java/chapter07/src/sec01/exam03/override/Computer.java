package sec01.exam03.override;

public class Computer extends Calc {
	
	@Override // 부모에 해당 메소드가 똑같이 선언되어 있는지 검사
				// 없으면 빨간 줄로 표시
				// private 사용 시 오류 발생
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return r * r * Math.PI;
	}
	
	@Override
	public int plus(int x, int y) {
		int result = super.plus(x, y);
		System.out.println("Computer의 plus 실행");
		System.out.println("(x+y) 정답: " + result);
		return result;
	}
}
