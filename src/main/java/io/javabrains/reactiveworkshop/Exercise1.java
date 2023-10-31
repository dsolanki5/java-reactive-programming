package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
//        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
//        StreamSources.intNumbersStream()
//                .filter(x -> x < 5)
//                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
//        StreamSources.intNumbersStream()
//                .filter(x -> x > 5)
//                .skip(1)
//                .limit(2)
//                .forEach(n -> System.out.println(n));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
//        Integer ans = StreamSources.intNumbersStream()
//                .filter(x -> x > 5)
//                .findFirst()
//                .orElse(-1);
//        System.out.println(ans);

        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("===============================");
        // Print first names in userStream for users that have IDs from number stream
        //1st solution:
//        StreamSources.userStream()
//                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
//                .forEach(u -> System.out.println(u.getFirstName()));

        //2nd Solution:
        StreamSources.intNumbersStream()
                .flatMap((id -> StreamSources.userStream().filter((user -> user.getId() == id))))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);
        //we use flatmap when there is a mapping of object to stream of data.
        //for eg., above inside flatmap(): "id" was mapping to Stream of data(.filter() returns Stream)
        // so instead of mapping to Stream, i wanted "id" to map to the output of Stream, so here
        // we used .flatmap
        // if it was direct object to object mapping, we would have just used .map()


    }

}
