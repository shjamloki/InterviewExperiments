package org.sj.java.lambda.experiments;

@FunctionalInterface
public interface Greeting {

	public void perform();
	public default void run(){
		System.out.println("hi");
	}

}
