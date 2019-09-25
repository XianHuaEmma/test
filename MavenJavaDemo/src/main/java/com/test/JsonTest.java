package com.test;
//阿里巴巴FastJson
import java.util.Iterator;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		String myData = "{\"response\":{\"data\":[{\"address\":\"南京市游乐园\",\"province\":\"江苏\",\"district\":\"玄武区\",\"city\":\"南京\"}]},\"status\":\"ok\"}";
		JSONObject dataJson=JSON.parseObject(myData);
		JSONObject response=dataJson.getJSONObject("response");
		JSONArray data=response.getJSONArray("data");
		JSONObject answer = data.getJSONObject(0);
		StringBuffer sb = new StringBuffer();
		for (Entry<String, Object> entry : answer.entrySet()){
			System.out.println(entry.getKey()+":  "+entry.getValue());
			sb.append(entry.getKey()+":  "+entry.getValue()+"\r");
			
		}
		System.out.println("====================");
		System.out.println(sb.toString());
		 
		
	}

}
