package com.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.exporter.PushGateway;

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
	        
	        //实现PushGateWay 的批量推送
	        CollectorRegistry registry = new CollectorRegistry();
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
	        
	        //测试PushGateWay数据的上传
	        Gauge gaugePushGate= Gauge.build()
	        		.name("push_request_time")
	        		.labelNames("Pushtime")
	        		.help("PushGateWay中Gauge类型测试")
	        		.register(registry);
	        Counter CountPush = Counter.build()
	                .name("requests_total_Push")
	                .labelNames("Pushapplication")//定义标签的key=labels("application")application
	                .help("测试")
	                .register(registry); 
	        
	        
	        
	 
	        int max=20;
	        int min=1;
	        Random random = new Random();
	        //定义PushGateWay这个类
	        PushGateway prometheusPush = new PushGateway("localhost:9091");
	 
	        while (true){
	            TimeUnit.SECONDS.sleep(2);
	            int count = random.nextInt(max)%(max-min+1) + min;
	            System.out.println(count);
	            try {
					Countrequests.labels("Count_HTTPServer1243").inc(count);  //包含标签，此时httpServer就是label的val值
					Countrequests.labels("Count_HttpServer逐增").inc();
					gaugeRandNum.labels("请求时间").set(count);
					gaugePushGate.labels("模拟Push请求响应时间").set(count+1);
					CountPush.labels("PushGate计量").inc(count);
//					prometheusPush.push(gaugePushGate,"sp-getway");
					prometheusPush.push(registry,"my_push_Job");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            histDist.labels("响应时间区间").observe(count);//统计随机数，落入的区间，当count小于区间值，则响应的区间值加1；得到的是分布的次数
	            System.out.println(sdf.format(new Date()) + "increase count, current number:" + Countrequests.labels("Count_HTTPServer1243").get());
	            System.out.println(sdf.format(new Date()) + "increase count, current number:" + Countrequests.labels("Count_HttpServer逐增").get());
	            System.out.println(sdf.format(new Date()) + "increase gauge, current time:" + gaugeRandNum.labels("请求时间").get());
	            
	        }
	    }

	

	

}
