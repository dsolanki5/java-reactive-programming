package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
//        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();
        //OR:
        Integer number2 = ReactiveSources.intNumberMono().block();

        //here it will not wait for the operation to complete, it will continue to run further..
        // i.e., its a non-blocking operation.
//        ReactiveSources.userMono().subscribe(user -> System.out.println(user));

        //block means it will wait till the operations gets completed and then go and execute next line
        User user = ReactiveSources.userMono().block();
        System.out.println("User Mono -> " + user);

        // It is not recommended to use block in reactive programming becoz then no use of doing
        //reactive programming if we are waiting for a operation to complete.
        // We wanted to do it asynchronously

        System.out.println("Press a key to end");
        System.in.read();
    }

}
