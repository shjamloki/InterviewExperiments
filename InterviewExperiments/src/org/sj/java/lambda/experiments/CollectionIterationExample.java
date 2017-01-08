package org.sj.java.lambda.experiments;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List <Person> people = (List<Person>) Arrays.asList(
				new Person("shailesh","jamloki",34),
				new Person("pooja","jamloki",24),
				new Person("Unmukt","jamloki",3),
				new Person("Bani","Judge",33),
				new Person("Lopa","Raut",36)
				);
		
		System.out.println("Classic for loop");
		//external iterator
		for(int i=0;i<people.size();i++)
		{
			System.out.println(people.get(i));
		}
		
		System.out.println(" for-in loop");
		//external iterator.
		for (Person person : people) {
			System.out.println(person);
		}
		System.out.println(" lambda for-each loop");
		// Here it is called internal iterator and runs in parallel. 
		//The order in which the elements are printed does not matter.
		people.forEach(System.out::println);
	}

}
