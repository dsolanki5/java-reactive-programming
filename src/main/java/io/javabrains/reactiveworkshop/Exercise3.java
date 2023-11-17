package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().toList(); //this is
        // a blocking operation where the Streams waits for all the items to be coming and then
        // gets added in list. it moves to next line only if this flux to List operations is completed.
        System.out.println("List is ::-> " + numbers);
        System.out.println("List size is ::-> " + numbers.size());

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
