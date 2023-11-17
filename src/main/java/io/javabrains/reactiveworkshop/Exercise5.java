package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                number -> System.out.println("Number: " + number),
//                err -> System.out.println("Error occured during subscribing flux: " + err.getMessage())
//        );

        //if a failure occurs, the error will be executed and the third parameter will never be executed.
        // i.e., completion event will never occur if there is an error

//        ReactiveSources.intNumbersFlux().subscribe(
//                number -> System.out.println("Number: " + number),
//                err -> System.out.println("Error occured during subscribing flux: " + err.getMessage()),
//                () -> System.out.println("Completed")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber:

        //instead of writing the lambda expressions as above, u can control the no of items
        // being subscribed by subscriber using custom class written below:
        ReactiveSources.intNumbersFlux().subscribe(new MyBaseSubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MyBaseSubscriber<T> extends BaseSubscriber<T> {
    //this method tells when the subscription happens, how much items do it needs to send
    // it makes use of request() where we can specify no of items it must subscribe
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription received");
        request(1); // i will subscribe 1 item at a time
    }

    // hookOnNext() method tells that once the no of items mentioned in the subscription is consumed,
    // then how much more items it is ready to take next with the help of request() method
    @Override
    protected void hookOnNext(T value) {
        System.out.println(value + " received");
        request(3); //everytime i processed n subscribed items(mentioned above hookOnSubscribe(),
        // i m ready for next 3 items
    }
}