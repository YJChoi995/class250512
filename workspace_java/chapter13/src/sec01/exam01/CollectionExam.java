package sec01.exam01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExam {
	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list.isEmpty());
		
		// 추가
		list.add(123);
		list.add("글씨");
		
		// 중간에 삽입
		list.add(1, "삽입");
		System.out.println(list);
		
		// 검색
		System.out.println(list.contains(1234));
		
		System.out.println(list.get(1));
		String a = (String)list.get(1);
		String b = list.get(1).toString();
		
		// 지우기
		list.remove(1);
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
		
		
		System.out.println("------------------------");
		
		/* Map 컬렉션 */
		Map map = new HashMap();
		
		// 추가
		map.put("k1", "v1");
		map.put("list", list);
		map.put("k1", "v2"); // key가 같은 경우 덮어쓴다
		
		// 가져오기
		String k1 = (String)map.get("k1");
		List list2 = (List)map.get("list");
		
		System.out.println(map);
		
		System.out.println("------------------------");
		list = new ArrayList();
		
		map = new HashMap();
		map.put("제목", "Golden");
		map.put("가수", "헌트릭스");
		list.add(map);
		System.out.println("list:" + list);
		
		System.out.println("++++++++++++++");
		// 마지막 값만 여러번 나온다면 new 해줘야 한다
		// 얕은 복사
		map = new HashMap();
		map.put("제목", "나는 반딧불");
		map.put("가수", "황가람");
		list.add(map);
		System.out.println("list:" + list);
		
		// 제너릭 : <String, Integer>
		// 추가할 자료형을 제한한다
		// 전달인자나 리턴타입의 자료형을 동적으로 변경한다
		List<String> list3 = new ArrayList<String>();
//		list3.add(123);
		
		// 제너릭에 원시타입은 사용할 수 없고, wrapper 클래스를 사용
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("str", 123);
		int c = map2.get("str");
		
	}

}
