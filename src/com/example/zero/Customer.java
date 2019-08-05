package com.example.zero;

public class Customer {
	
	int amount = 1000;
	
	public synchronized void withdraw(int m) {
		System.out.println("Ban dang rut tien...");
		if (amount < m) {
			System.out.println("Khong du tien de rut !");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		amount = amount - m;
		System.out.println("Ban da rut tien thanh cong.");
	}
	
	public synchronized void deposit(int m) {
		System.out.println("Ban dang nap tien...");
		amount = amount + m;
		System.out.println("Nap tien thanh cong.");
		notify();
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		Thread th1 = new Thread() {
			public void run() {
				customer.withdraw(1500);
			};
		};
		th1.start();
		Thread th2 = new Thread() {
			public void run() {
				customer.deposit(2000);
			};
		};
		th2.start();
	}

}
