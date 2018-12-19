package com.javaconcurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/*
 * 测试定长线程池
 */
public class TestFixedThreadPool {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 1000; i++) {
			
			final int num = i;
			
			executorService.execute(new Runnable() {

				@Override
				public void run() {

					System.out.println(Thread.currentThread().getName() + " " + num);
					
				}
				
			});
			
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executorService.shutdown();
		
	}
	
}
