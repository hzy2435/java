package com.javaconcurrent.test1;

import java.util.Random;

/*
 * 使用 Thread 实现多线程
 */
public class TestThread {

	public static void main(String[] args) {
		
		Runner liuxiang = new Runner();
		liuxiang.setName("刘翔");
		
		Runner laoqi = new Runner();
		laoqi.setName("老齐");
		
		Runner op = new Runner();
		op.setName("路飞");
		
		liuxiang.start();
		laoqi.start();
		op.start();
		
	}
	
}

class Runner extends Thread {
	
	@Override
	public void run() {
		
		int speed = new Random().nextInt(100);
		
		for(int i = 1; i <= 100; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(this.getName() + "已前进 " + (speed * i) + "米(" + speed + "米/秒)");
			
		}
		
	}
	
}
