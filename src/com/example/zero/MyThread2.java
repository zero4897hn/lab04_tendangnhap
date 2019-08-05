package com.example.zero;

class Thread1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 10; i++) if (i % 2 == 0) {
			System.out.println(i);
		}
	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 10; i++) if (i % 2 == 1) {
			System.out.println(i);
		}
	}
}

public class MyThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Thread1 thread1 = new Thread1();
			Thread2 thread2 = new Thread2();
			thread1.start();
			thread1.join();
			thread2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
