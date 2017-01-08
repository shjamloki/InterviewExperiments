package org.sj.java.lambda.experiments;

public class LambdaExperiments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Thread myThread = new Thread(()->System.out.println("Hello World"));
     myThread.start();
     
     Greeting myGreeting = ()-> System.out.println("Hello Lambda !");
     
	}

}
