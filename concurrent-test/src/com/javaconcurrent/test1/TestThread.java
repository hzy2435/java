package com.javaconcurrent.test1;

import java.util.Random;

/*
 * ʹ�� Thread ʵ�ֶ��߳�
 */
public class TestThread {

	public static void main(String[] args) {
		
		Runner liuxiang = new Runner();
		liuxiang.setName("����");
		
		Runner laoqi = new Runner();
		laoqi.setName("����");
		
		Runner op = new Runner();
		op.setName("·��");
		
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
			
			System.out.println(this.getName() + "��ǰ�� " + (speed * i) + "��(" + speed + "��/��)");
			
		}
		
	}
	
}
