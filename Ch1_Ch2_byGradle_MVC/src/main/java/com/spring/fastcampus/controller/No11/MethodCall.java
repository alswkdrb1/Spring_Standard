package com.spring.fastcampus.controller.No11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class ModelController {
	public String main(HashMap map) {
		//작업 결과를 map에 저장
		map.put("id", "asdf");
		map.put("pwd", "1111");

		return "txtView2";//뷰 이름을 반환
	}
}

public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap();
		System.out.println("before:"+map);

		ModelController mc = new ModelController();
		String viewName = mc.main(map);

		System.out.println("after :"+map);

		render(map, viewName);
	}

	static void render(HashMap map, String viewName) throws IOException {
		String result = "";

		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
//		String path = System.getProperty("user.dir");
		String path = Paths.get("").toAbsolutePath().toString();
		System.out.println("user.dir : " + path);
		Scanner sc = new Scanner(new File("src/main/java/com/spring/fastcampus/controller/No11/" + viewName+".txt"));

		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();

		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();

		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}

		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}

