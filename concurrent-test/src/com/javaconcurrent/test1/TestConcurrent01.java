package com.javaconcurrent.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestConcurrent01 {
	
	private final static int users = 5;
	private static int count = 0;
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(users);
		
		for(int i = 0; i < 10000; i++) {
			
			service.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
		System.out.println(count);
	}

	private static void add() {
		count++;
	}
	
}
