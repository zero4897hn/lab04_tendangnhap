package com.example.zero;

public class MyThread3 {
	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			@Override
			public synchronized void run() {
				// TODO Auto-generated method stub
				super.run();
				for (int i = 1; i <= 10; i++) {
					System.out.println(i);
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		thread1.start();
		Thread thread2 = new Thread() {
			@Override
			public synchronized void run() {
				// TODO Auto-generated method stub
				super.run();
				for (int i = 1; i <= 10; i++) {
					if (i % 2 == 0) System.out.println("Chan");
					else System.out.println("Le");
					notify();
				}
			}
		};
		thread2.start();
	}
}
