package com.test;
//https://blog.csdn.net/FlyLikeButterfly/article/details/99737051
//https://www.codercto.com/a/55346.html
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpServerPost {
	public static void main(String[] args) {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
			server.createContext("/form", new FormHttpHandler());
			server.createContext("/info", new InfoHttpHandler());
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, String> getParams(String paramStr){
		if(paramStr != null) {
			return Stream.of(paramStr.split("&"))
				.filter(s -> s.split("=").length == 2 && s.split("=")[0].length() > 0 && s.split("=")[1].length() > 0)
				.collect(Collectors.toMap(x -> x.toString().split("=")[0], y -> y.toString().split("=")[1]));
		}
		return null;
	}
 
}
class FormHttpHandler implements HttpHandler {
 

	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("from方法：" + exchange.getRequestMethod());//get
		String paramStr = exchange.getRequestURI().getQuery();
		System.out.println("get参数：" + HttpServerPost.getParams(paramStr));
		exchange.sendResponseHeaders(200, 0);
		String body = "<!DOCTYPE html>"
				+ "<head>"
				+ "<meta charset='utf-8'>"
				+ "<title>FromPage</title>"
				+ "</head>"
				+ "</body>"
				+ "<form action='info' method='post'>"
				+ "abc:<input type='text' name='abc'/><br/>"
				+ "def:<input type='text' name='def'/><br/>"
				+ "<input type='submit' value='测试'/>"
				+ "</form>"
				+ "</body>";
		exchange.getResponseBody().write(body.getBytes());
		exchange.close();
	}
	
}
class InfoHttpHandler implements HttpHandler {
 
	
	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("info方法：" + exchange.getRequestMethod());//post
		String bodyStr = ""+exchange.getRequestBody();
		bodyStr =URLDecoder.decode(bodyStr,"UTF-8");
		System.out.println("post收到：" + HttpServerPost.getParams(bodyStr));
		exchange.sendResponseHeaders(200, 0);
		exchange.getResponseBody().write("success".getBytes());
		exchange.close();
	}


}
