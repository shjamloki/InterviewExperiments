package org.sj.java.lambda.experiments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List <Person> people = (List<Person>) Arrays.asList(
				new Person("shailesh","jamloki",34),
				new Person("pooja","jamloki",24),
				new Person("Unmukt","jamloki",3),
				new Person("Bani","Judge",33),
				new Person("Lopa","Raut",36)
				);
		System.out.println("printing all people with last name starts with j"); 
		printConditionally(people, p->p.getFirstName().startsWith("s"),System.out::println);
		//System.out::println === (p)->System.out.println(p);
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
