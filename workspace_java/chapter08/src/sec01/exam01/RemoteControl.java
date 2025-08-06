package sec01.exam01;

// new 못 함
public interface RemoteControl {

	public static final int MAX_VOLUME = 10;
	// 모든 필드는 public static final(상수)이다
	// 그래서 생략 가능하다
	int MIN_VOLUME = 0;
	
	
	public abstract void turnOn();
	// 기본적으로 메소드는 public abstract(추상) 메소드다
	// 그래서 생략 가능하다
	void turnOff();
	void setVolume(int vol);
	
	default void mic(String text) {
		
	}
}
