package sec06.exam06.getset;

public class Car {
	
	// 필드는 private으로 지정해서
	// 직접 읽고 쓰는 걸 방지
	private int speed;
	private boolean stop;
	
	// 이렇게 마음대로 만들어도 되는데
	public int test() {
		return this.speed;
	}
	
	/* getter */
	// 보통 필드 값을 돌려주는 기능
	// 메소드명: get + 필드명(대문자로 시작)
	// 전달인자: 없음
	// 리턴타입: 필드의 타입
	public int getSpeed() {
		return this.speed;
	}
	
	/* setter */
	// 보통 필드 값을 수정하는 기능
	// 메소드명: set + 필드명(대문자로 시작)
	// 전달인자: 필드의 타입
	// 리턴타입: void
	void setSpeed(int speed) {
		this.speed = speed;
	}

	// getter 중에서 boolean 타입의 경우
	// get 대신 is를 사용하기도 함
	// getStop, isStop 둘 다 허용인데
	// 일부에서는 get만 사용하는 경우가 있다
	public boolean isStop() {
		return this.stop;
	}
	
	public boolean getStop() {
		return this.stop;
	}
	
	public void setStop(boolean stop) {
		
	}
	
}
