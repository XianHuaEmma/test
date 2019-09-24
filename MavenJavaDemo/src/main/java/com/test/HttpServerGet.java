package com.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


@Service
public class HttpServerGet {
	@PostConstruct
	public void initHttpServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8418), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
	
	static class MyHandler implements HttpHandler {
      
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("receive");
            String requestMethod = httpExchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {//客户端的请求是get方法
                //设置服务端响应的编码格式，否则在客户端收到的可能是乱码
                Headers responseHeaders = httpExchange.getResponseHeaders();
                responseHeaders.set("Content-Type", "text/html;charset=utf-8");

                //在这里通过httpExchange获取客户端发送过来的消息
                //URI url = httpExchange.getRequestURI();
                //InputStream requestBody = httpExchange.getRequestBody();

                // 这里获取get请求参数
                // will return string in format similar to this: "field1=value1&field2=value2&field3=value3..."
                String queryParams = httpExchange.getRequestURI().getQuery();
                System.out.println(queryParams);

                String response = "this is server";

                httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes("UTF-8").length);

                OutputStream responseBody = httpExchange.getResponseBody();
                OutputStreamWriter writer = new OutputStreamWriter(responseBody, "UTF-8");
                writer.write(response);
                writer.close();
                responseBody.close();
            }

        }
    }

}
