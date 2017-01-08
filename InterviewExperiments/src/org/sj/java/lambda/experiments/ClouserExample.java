package org.sj.java.lambda.experiments;

public class ClouserExample {

	public static void main(String[] args) {
		int a=10;
		int b=20; // effective final variable. b is called clousure.
		doProcess(a,i->System.out.println(i+b));
	}
	public static void doProcess(int i,Process p){
		p.process(i);
	}

}

interface Process{
	public void process(int i);
}