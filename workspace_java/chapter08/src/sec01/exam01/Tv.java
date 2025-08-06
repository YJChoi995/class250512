package sec01.exam01;

//인터페이스에 선언된 추상 메소드의 실체 메소드 선언
public class Tv extends Display implements RemoteControl, OTT{
	
	int vol;

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
	}

	@Override
	public void setVolume(int vol) {
		if(vol > RemoteControl.MAX_VOLUME) {
			this.vol = RemoteControl.MAX_VOLUME;
			System.out.println(RemoteControl.MAX_VOLUME + " 이하만 가능합니다");
		} else if(vol < RemoteControl.MIN_VOLUME) {
			this.vol = RemoteControl.MIN_VOLUME;
			System.out.println(RemoteControl.MIN_VOLUME + " 이상만 가능합니다");
		} else {
			this.vol = vol;
		}
	}
	

	@Override
	public void netflix() {
		System.out.println("넷플릭스 시청");
	}


	

}
