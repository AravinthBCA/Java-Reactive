package javareactive;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
    	
    	// Print all numbers in the intNumbersStream stream
    	
    	// what element return foreach it automatically goes into println and print that..
//    	StreamSources.intNumbersStream().forEach(System.out::print);
    	StreamSources.intNumbersStream().forEach(i -> System.out.print(i+" "));
    	System.out.println("\n---------------------------------------------------------------");
    	
    	// Print numbers from intNumbersStream that are less than 5
    	StreamSources.intNumbersStream().filter(element -> element < 5)
    									.forEach(i -> System.out.print(i+" "));
    	System.out.println("\n---------------------------------------------------------------");
    	
        // Print the second and third numbers in intNumbersStream that's greater than 5
    	StreamSources.intNumbersStream().filter(i -> i > 5)
    									.skip(1)
    									.limit(2)
    									.forEach(i -> System.out.print(i+" "));
    	System.out.println("\n---------------------------------------------------------------");
    	
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
    	int value = StreamSources.intNumbersStream().filter(i -> i > 5)
    									.findFirst()
    									.orElse(-1);
    	System.out.print(value);
    	System.out.println("\n---------------------------------------------------------------");
    	
        // Print first names of all users in userStream
    	StreamSources.userStream().map(user -> user.getFirstName())
    							  .forEach(System.out::println);
    	System.out.println("\n---------------------------------------------------------------");
    	
        // Print first names in userStream for users that have IDs from number stream
    	// flatMap return user object and map return stream object
    	StreamSources.intNumbersStream()
    				 .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
    				 .forEach(i -> System.out.println(i));
    	System.out.println("\n---------------------------------------------------------------");
    	// or
    	StreamSources.userStream()
    				.filter( u -> StreamSources.intNumbersStream()
    						.anyMatch(i -> i == u.getId()))
    				.forEach(System.out::println);
   	}

}
