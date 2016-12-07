package edu.project.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new TaskThread(0));
		executor.execute(new TaskThread(1));
		executor.execute(new TaskThread(2));
		executor.execute(new TaskThread(3));
		executor.shutdown();
	}
}