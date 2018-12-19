package com.javaconcurrent.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 测试可调度线程池
 */
public class TestScheduledThreadExecutor {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		
		/*scheduledExecutorService.schedule(new Runnable() {

			@Override
			public void run() {

				System.out.println(Thread.currentThread().getName() + new Date() + " 每三秒执行一次");
				
			}
			
		}, 3, TimeUnit.SECONDS);*/
		
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {

				System.out.println(Thread.currentThread().getName() + new Date() + " 间隔三秒执行一次");
				
			}
			
		}, 1, 3, TimeUnit.SECONDS);
		
	}
	
}
