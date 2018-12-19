package com.javaconcurrent.test1;

import java.util.Random;

public class TestRunnable {

	public static void main(String[] args) {
		
		Thread liuxiang = new Thread(new Runner2());
		liuxiang.setName("刘翔");
		
		Thread laoqi = new Thread(new Runner2());
		laoqi.setName("老齐");
		
		Thread op = new Thread(new Runner2());
		op.setName("路飞");
		
		liuxiang.start();
		laoqi.start();
		op.start();
		
	}
	
}

class Runner2 implements Runnable {

	@Override
	public void run() {

		int speed = new Random().nextInt(100);
		
		for(int i = 1; i <= 100; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "已前进 " + (speed * i) + "米(" + speed + "米/秒)");
			
		}
		
	}
	
}