package com.demo.java8;

public class TestKanbda {
public static void main(String[] args) {
	Thread t1=new Thread(()->System.out.println("This is It"));
	t1.start();
	
	Thread t2=new Thread(()->{ for(int i=0;i<10;i++) { System.out.println(i);try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}});
	t2.start();
}
}
