package org.sj.java.lambda.experiments;

import java.util.Arrays;
import java.util.List;

public class StreamExperiment {

	public static void main(String[] args) {
		 List <Person> people = (List<Person>) Arrays.asList(
					new Person("shailesh","jamloki",34),
					new Person("pooja","jamloki",24),
					new Person("Unmukt","jamloki",3),
					new Person("Bani","Judge",33),
					new Person("Lopa","Raut",36)
					);
		  
		  people.stream()
		  .filter(p->p.getFirstName().startsWith("s"))
		  .forEach(p->System.out.println(p));
		  
		  // 3 things in stream. one source e.g. people. second : functions that can be applied e.g. filter.
		  // third : terminator. : e.g. foreach, count.
		  long count=people.parallelStream()
		  .filter(p->p.getFirstName().startsWith("p"))
		  .count();
		  
		  System.out.print(count);
	}

}
