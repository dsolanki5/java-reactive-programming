package io.javabrains.reactiveworkshop;

import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens::-
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(num -> System.out.println(num)); //this will emit exception

//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(num -> System.out.println(num),
//                        err -> System.out.println("Error occurred!!! ")); //this way we can handle error,
        // like a catch block. But doesn't continue the execution

//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(err -> System.out.println("Error occured")) //this doesnt handle the error like catch block.
//                // the exception is still occured, but this gives us a way to do something when the error occurs.
//                // u may either log or send it to caller,etc
//                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors ::-
        /*ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err, item) -> System.out.printf("Error occured on item %s is :: %s \n", item, err.getMessage()
                )) //it handles the error and resume the execution
                .subscribe(num -> System.out.println("num:: " + num));*/


        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2 ::-
        /*ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);*/

        //finally block ::-
        ReactiveSources.intNumbersFluxWithException()
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_COMPLETE) {
                        System.out.println("Done!");
                    }
                    if (signalType == SignalType.ON_ERROR) {
                        System.out.println("Error!");
                    }
                })
                .subscribe(System.out::println);
        System.out.println("Press a key to end");
        System.in.read();
    }

}
