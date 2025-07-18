package sec02.exam01.driver;

import java.util.ArrayList;
import java.util.HashMap;

public class DriverExam {
	public static void main(String[] args) {
		
		Tico tico = new Tico();
		
		Driver driver = new Driver();
		
		driver.driveTico(tico);
		
		Porsche porsche = new Porsche();
		Car c1 = (Car)porsche;
		driver.drive(c1);
		
		BMW bmw = new BMW();
		driver.drive( (Car)bmw );
		
		driver.drive( (Car) new Tico() );
		
		ArrayList list = new ArrayList();
		list.add(driver);
		Driver d = (Driver)list.get(0);
		
		/* HashMap 사용법 */
		HashMap map = new HashMap();
		map.put("key", "value"); 		   // 넣는 법
		String a = (String)map.get("key"); // 꺼내는 법
	
	}
}
