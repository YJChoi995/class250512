package sec01.exam08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeExam {
	public static void main(String[] args) {

		long before = System.currentTimeMillis();
		
		for(int i=0; i<1000; i++) {
			System.out.println(i);
		}
		
		long after = System.currentTimeMillis();
		System.out.println("걸린 시간: " + (after - before));
		
		
		/* Date 클래스 */
		Date date = new Date();
		System.out.println(date);
		
		String format = "yyyy년 MM월 dd일 HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(date);
		System.out.println(strDate);

		/* Calender 클래스 */
		
	}

}
