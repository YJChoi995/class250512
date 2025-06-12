package sec01.exam01;

import java.util.Calendar;

public class EnumExam {

	public static void main(String[] args) {
		
		Week week;
		
		Week week_m = Week.MONDAY;
		
		if(week_m == Week.MONDAY) {
			System.out.println("월요일");
		} else if(week_m == Week.TUESDAY) {
			System.out.println("화요일");
		}
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week1 = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(week1);
	}

}
