package com.javaconcurrent.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * ���Կɵ����̳߳�
 */
public class TestScheduledThreadExecutor {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		
		/*scheduledExecutorService.schedule(new Runnable() {

			@Override
			public void run() {

				System.out.println(Thread.currentThread().getName() + new Date() + " ÿ����ִ��һ��");
				
			}
			
		}, 3, TimeUnit.SECONDS);*/
		
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {

				System.out.println(Thread.currentThread().getName() + new Date() + " �������ִ��һ��");
				
			}
			
		}, 1, 3, TimeUnit.SECONDS);
		
	}
	
}
