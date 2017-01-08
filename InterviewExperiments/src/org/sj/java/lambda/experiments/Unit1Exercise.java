package org.sj.java.lambda.experiments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;



public class Unit1Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Person> people = (List<Person>) Arrays.asList(
				new Person("shailesh","jamloki",34),
				new Person("pooja","jamloki",24),
				new Person("Unmukt","jamloki",3),
				new Person("Bani","Judge",33),
				new Person("Lopa","Raut",36)
				);

		//Step 1: Sort list by last Name
		//people.sort((Person p1,Person p2)->p1.getLastName().compareTo(p2.getLastName()));
		Collections.sort(people,(p1,p2)->p1.getLastName().compareTo(p2.getLastName()));
		//System.out.print(people);
		
		//Step 2: Create a method that prints all elements in the list.
		System.out.println("printing all elements");
	     printConditionally(people,p->true,p->System.out.println(p));
	     
		//step 3: Create a method that prints all people that have last name starting with "j".
	    System.out.println("printing all people with last name starts with j"); 
		printConditionally(people, p->p.getLastName().startsWith("j"),p->System.out.println(p));
		
		//step 4: Create a method that prints all people that have first name starting with "s".
		System.out.println("priinting all people with first name starts with s");
		printConditionally(people, p->p.getFirstName().startsWith("s"),p->System.out.println(p.getFirstName()));
	}
	//Note Predicate interface from the java.util.function package.
	public static void printConditionally(List<Person> people,Predicate<Person> condition,Consumer<Person> consumer){
		for (Person person : people) {
		if(condition.test(person))
			{
				consumer.accept(person);
			}
		}
	}
	
}
