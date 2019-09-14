package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.exporter.HTTPServer;

public class PrometheusDemo {
	 public static void main(String[] args){
	        try {
	            System.out.println("start...");
	            new HTTPServer(1234);
	            submitData();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public static void submitData() throws InterruptedException {
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	 //Counter类型的数据
	        Counter Countrequests = Counter.build()
	                .name("requests_total_liubingan")
	                .labelNames("application")//定义标签的key=labels("application")application
	                .help("测试")
	                .register();
	    //Gauge类型数据
	        Gauge gaugeRandNum = Gauge.build()
	        		.name("request_time")
	        		.labelNames("time")
	        		.help("Gauge类型测试")
	        		.register();
	        
	      //Histogram类型数据
	        Histogram histDist = Histogram.build()
	        		.name("request_time_section")
	        		.labelNames("section")
	        		.buckets(2,4,8,12,16,20)//定义多个区间
	        		.help("Histogram类型数据测试")
	        		.register();
	 
	        int max=20;
	        int min=1;
	        Random random = new Random();
	 
	        while (true){
	            TimeUnit.SECONDS.sleep(2);
	            int count = random.nextInt(max)%(max-min+1) + min;
	            System.out.println(count);
	            Countrequests.labels("Count_HTTPServer1243").inc(count);  //包含标签，此时httpServer就是label的val值
	            Countrequests.labels("Count_HttpServer逐增").inc();
	            gaugeRandNum.labels("请求时间").set(count);
	            histDist.labels("响应时间区间").observe(count);//统计随机数，落入的区间，当count小于区间值，则响应的区间值加1；得到的是分布的次数
	            System.out.println(sdf.format(new Date()) + "increase count, current number:" + Countrequests.labels("Count_HTTPServer1243").get());
	            System.out.println(sdf.format(new Date()) + "increase count, current number:" + Countrequests.labels("Count_HttpServer逐增").get());
	            System.out.println(sdf.format(new Date()) + "increase gauge, current time:" + gaugeRandNum.labels("请求时间").get());
	            
	        }
	    }

	

	

}
