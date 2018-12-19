package com.javaconcurrent.test1;

import java.util.Random;

public class TestSynchronized {

	public static void main(String[] args) {
//		Curplet c = new Curplet();
		for(int i = 0; i < 1000; i++) {
			new Thread() {
				public void run() {
					int n = new Random().nextInt(2);
					if(n % 2 != 0) {
						Curplet.first();
					} else {
						Curplet.second();
					}
				}
			}.start();
		}
	}
	
}

class Curplet {
	
	private Object lock = new Object();
	
//	public synchronized void first() {
	public synchronized static void first() {
//		synchronized(lock) {
			System.out.print("��");
			System.out.print("ɪ");
			System.out.print("��");
			System.out.println("��");
//		}
		
	}
	
	public static void second() {
		
//		synchronized(lock) 
//		synchronized(this) 
		synchronized(Curplet.class) {
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.println("��");
		}
	}
}