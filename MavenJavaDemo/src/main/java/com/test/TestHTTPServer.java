package com.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class TestHTTPServer {
	
				public static void main(String[] args) {
					try{
						
						HttpServer server = HttpServer.create(new InetSocketAddress(8080), 20);//监听8080端口，第二个参数小于等于0使用默认值，表示可同时接受请求的个数
//						HttpServer server = HttpServer.create();
//						server.bind(new InetSocketAddress(8080), 0);
						server.createContext("/start", new StartHandler());
//						HttpContext context = server.createContext("/start");//需要后面设置handler
//						context.setHandler(new StartHandler());
//						server.removeContext(context);//移除context
//						server.removeContext("/start");//移除context
						server.start();
						System.out.println("start....");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						server.stop(1000);
						
					}catch(IOException e){
						e.printStackTrace();
					}
					
			}
}
				
				class StartHandler implements HttpHandler {
					 
				
					public void handle(HttpExchange exchange) throws IOException {
						System.out.println("getProtocol:" + exchange.getProtocol());//协议版本
						System.out.println("getRequestMethod:" + exchange.getRequestMethod());//请求方法GET、POST
						System.out.println("getResponseCode:" + exchange.getResponseCode());//返回已经设置的响应code，还没设置返回-1
						
						HttpContext context = exchange.getHttpContext();
					   Headers responseHeaders = exchange.getResponseHeaders();
			            responseHeaders.set("Content-Type", "text/json;charset=utf-8");
						System.out.println("context.getPath:" + context.getPath());
						System.out.println("context.toString:" + context.toString());
						System.out.println("context.getAttributes：" + context.getAttributes());
						System.out.println("context.getAuthenticator：" + context.getAuthenticator());
						System.out.println("context.getFilters：" + context.getFilters());
						System.out.println("context.getHandler：" + context.getHandler());
						System.out.println("context.getServer：" + context.getServer());
						
						System.out.println("getLocalAddress:" + exchange.getLocalAddress());
						System.out.println("getPrincipal:" + exchange.getPrincipal());
						System.out.println("getRemoteAddress:" + exchange.getRemoteAddress());
						
						URI uri = exchange.getRequestURI();
						System.out.println("getRequestURI:" + exchange.getRequestURI());
						System.out.println("uri.getAuthority:" + uri.getAuthority());
						System.out.println("uri.getFragment:" + uri.getFragment());
						System.out.println("uri.getHost:" + uri.getHost());
						System.out.println("uri.getPath:" + uri.getPath());
						System.out.println("uri.getQuery:" + uri.getQuery());//url里get请求的参数
						System.out.println("uri.getRawAuthority:" + uri.getRawAuthority());
						System.out.println("uri.getRawFragment:" + uri.getRawFragment());
						System.out.println("uri.getRawPath:" + uri.getRawPath());
						System.out.println("uri.getRawQuery:" + uri.getRawQuery());
						System.out.println("uri.getRawSchemeSpecificPart:" + uri.getRawSchemeSpecificPart());
						System.out.println("uri.getRawUserInfo:" + uri.getRawUserInfo());
						System.out.println("uri.getScheme:" + uri.getScheme());
						System.out.println("uri.getSchemeSpecificPart:" + uri.getSchemeSpecificPart());
						System.out.println("uri.getUserInfo:" + uri.getUserInfo());
						System.out.println("uri.getPort:" + uri.getPort());
						
						
						String response = "this is server";

		                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes("UTF-8").length);

		                OutputStream responseBody = exchange.getResponseBody();
		                OutputStreamWriter writer = new OutputStreamWriter(responseBody, "UTF-8");
		                writer.write(response);
		                writer.close();
		                responseBody.close();
						
						System.out.println("getRequestBody:" + exchange.getRequestBody());
						System.out.println("getResponseBody:" + exchange.getResponseBody());
						System.out.println("getResponseHeaders:" + exchange.getResponseHeaders());
						exchange.sendResponseHeaders(200, 0);//len>0：响应体必须发送指定长度；len=0：可发送任意长度，关闭OutputStream即可停止；len=-1：不会发响应体；
						System.out.println("ResponseCode:" + exchange.getResponseCode());
						exchange.close();//先关闭打开的InputStream，再关闭打开的OutputStream
					}
				

}
