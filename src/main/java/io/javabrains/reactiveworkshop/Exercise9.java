package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns ::->
//        ReactiveSources.intNumbersFlux().count().subscribe(System.out::println); //count() methods returns Mono<Long>.
        // So first, subscribe() collects all events and then count is returned.

        // Collect all items of intNumbersFlux into a single list and print it ::->
        //we already seen flux to List in Exercise 3 which is blocking operation.
        //below is another way to get data in List using Mono :
//        ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println); // here, collectList() returns
        // Mono<List<T>>

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);
        // here, buffer() returns flux<List<T>>. buffer(n) helps to keep n numbers in memory

        System.out.println("Press a key to end");
        System.in.read();
    }

}
