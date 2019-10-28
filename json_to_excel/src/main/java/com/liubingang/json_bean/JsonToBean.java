package com.liubingang.json_bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonToBean {
	
	private static final String  JSON_OBJ_STR = "{\"name\":\"liubingan\",\"Age\":18}";
	public static void main(String[] args) {
		Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});
		System.out.println(student.getName()+":"+student.getAge());
	}

}
