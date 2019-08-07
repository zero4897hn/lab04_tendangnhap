package com.example.zero;

class MyNumber {
	boolean continueFlg = true;
	int currentNumber;

	public boolean isContinueFlg() {
		return continueFlg;
	}

	public void setContinueFlg(boolean continueFlg) {
		this.continueFlg = continueFlg;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	public synchronized void showNumber() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			currentNumber = i;
			System.out.print(currentNumber);
			notify();
			wait();
		}
		continueFlg = false;
		notify();
	}

	public synchronized void isNumberEvenOrOdd() throws InterruptedException {
		while (continueFlg) {
			System.out.println((currentNumber % 2 == 0) ? " -> Chan" : " -> Le");
			notify();
			wait();
		}
		System.out.println("END.");
	}
}

public class MyThread3 {
	public static void main(String[] args) {
		MyNumber myNumber = new MyNumber();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				try {
					myNumber.showNumber();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				try {
					myNumber.isNumberEvenOrOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
	}
}