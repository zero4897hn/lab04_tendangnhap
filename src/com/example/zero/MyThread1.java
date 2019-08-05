package com.example.zero;

public class MyThread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread1 Thread1 = new MyThread1();
		MyThread1 Thread2 = new MyThread1();
		
		Thread thread1 = new Thread(Thread1);
		Thread thread2 = new Thread(Thread2);
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread1.start();
		thread2.start();
	}
	
}
