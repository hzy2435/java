package com.javaconcurrent.test1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TestCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// 创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		Runner3 liuxiang = new Runner3();
		liuxiang.setName("刘翔");
		
		Runner3 laoqi = new Runner3();
		laoqi.setName("老齐");
		
		Runner3 op = new Runner3();
		op.setName("路飞");
		
		Future<Integer> result1 = executorService.submit(liuxiang);
		Future<Integer> result2 = executorService.submit(laoqi);
		Future<Integer> result3 = executorService.submit(op);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("刘翔总共跑了: " + result1.get());
		System.out.println("老齐总共跑了: " + result2.get());
		System.out.println("路飞总共跑了: " + result3.get());
	}
	
}

class Runner3 implements Callable<Integer> {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Integer call() throws Exception {

		int speed = new Random().nextInt(100);
		int distance = 0;
		
		for(int i = 1; i <= 100; i++) {
			Thread.sleep(200);
			distance = speed * i;
			System.out.println(this.name + "已前进 " + distance + "米(" + speed + "米/秒)");
		}
		
		return distance;
	}
	
}