package edu.project.seven;

public class SimpleThread extends Thread{

	private String task;
	private int count;

	public SimpleThread(String task){
		this.task = task;
		count = 0;
	}
	
	public void run(){
		try{
		for(int i = 0; i<10; i++){
		System.out.println(count +" "+task);
		count++;
		Thread.sleep((int)(Math.random()*1000));
		}
		System.out.println("DONE! "+task);
		}
		catch(InterruptedException e){
		}
	}
}
