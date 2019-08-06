package com.example.zero;

import java.util.ArrayList;
import java.util.List;

class Thread3 extends Thread {
	List<Integer> numbers;
	public static final int MAX_NUMBER = 10;
	
	public Thread3() {
		numbers = new ArrayList<Integer>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for (int i = 1; i <= 10; i++) {
				printNumber(i);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	private synchronized void printNumber(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		while (i > MAX_NUMBER) wait();
		System.out.println(i);
		numbers.add(i);
		notify();
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}
}

class Thread4 extends Thread {
	Thread3 thread3;
	
	public Thread4(Thread3 thread3) {
		this.thread3 = thread3;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				printTypeOfNumber();
			}
			catch (Exception e) {
				
			}
		}
	}

	private synchronized void printTypeOfNumber() throws InterruptedException {
		notify();
		while (thread3.getNumbers().size() <= 0) wait();
		Integer number = thread3.getNumbers().get(0);
		System.out.println((number.intValue() % 2 == 0)? "Chan" : "Le");
		thread3.getNumbers().remove(number);
	}
}

public class MyThread3 {
	public static void main(String[] args) {
		Thread3 thread3 = new Thread3();
		Thread4 thread4 = new Thread4(thread3);
		thread3.start();
		thread4.start();
	}
}