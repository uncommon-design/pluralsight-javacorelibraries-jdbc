package com.pluralsight.corejdbc.m6c3;


public class Main implements Runnable{
	
	long sleepInterval;
	public Main(long sleepFor) {
		this.sleepInterval = sleepFor;
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			
			try {

				ConnectComponent comp = new ConnectComponent();
				comp.tryConnection();
				
				this.wait(sleepInterval);

			} catch (Exception exception) {
				;
			}
		}
	}
	
	public static void main(String [] args) {
		
		
		new ConnectionPool();
		
		Thread t1 = new Thread(new Main(500), "t1");
		Thread t2 = new Thread(new Main(525),"t2");
		Thread t3 = new Thread(new Main(550), "t3");
		Thread t4 = new Thread(new Main(600), "t4");
		
		System.out.println("Thread   Conn");
		System.out.println("------   ----");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
