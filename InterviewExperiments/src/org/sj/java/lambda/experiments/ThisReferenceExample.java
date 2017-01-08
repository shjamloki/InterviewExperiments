package org.sj.java.lambda.experiments;

public class ThisReferenceExample {
	
	public void doProcess(int i,Process p){
		p.process(i);
	}
	
	public void execute(){
		// this ----> referes to instance of ThisReferenceExample class
		doProcess(10,i->{
			System.out.println("Value is "+i);
			System.out.println(this); // this also refers to ThisReferenceExample. while in 
									 //innerAnnonymous class it refers to inner class.
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(20, p->{
        	System.out.println("Value is "+p);
			//System.out.println(this); // this does not work here as "this" is pointing to 
        								//thisRefereceClass and it can not be called in static method
        });
        
        thisReferenceExample.execute();
	}
	
	public String toString(){
		return "This is ThisReferenceExample class.";
	}

}
