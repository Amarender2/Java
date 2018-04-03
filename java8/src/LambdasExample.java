import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class LambdasExample {

    public static void main(String... args) throws InterruptedException {

        // General way of writing anonymous class

        /*
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };*/

        Comparator<String> comp = (s1, s2) -> s2.compareTo(s1);

        String[] names = {"Amar", "Reddy", "Mekala"};
        for (String name : names) {
            System.out.println(name);
        }
        Arrays.sort(names, comp);
        for (String name : names) {
            System.out.println(name);
        }


        // Another Example

        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(i);
                }
            }
        };*/

        Thread t = new Thread(() -> {
            for (int j = 0; j < 3; j++) {
                System.out.println(j);
            }
        });
        t.start();
        t.join();

        /*Method References*/

        BinaryOperator<Integer> sum = Integer::sum;
        System.out.println(sum.apply(2, 2));

        Function<Person, Integer> func = person -> person.getAge();
        Function<Person, Integer> func1 = Person::getAge;
        System.out.println(func.apply(new Person()));
        System.out.println(func1.apply(new Person()));

        Consumer<String> printer = s -> System.out.println(s);
        Consumer<String> printer1 = System.out::println;
        printer.accept("Hello");
        printer1.accept("Hello World");

        Comparator<Integer> c = Integer::compare;
        Integer[] numbers = {1, 6, 3, -1};
        Arrays.sort(numbers, c);
        for (int num : numbers) {
            System.out.println(num);
        }

        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());

        persons.forEach(p -> System.out.println(p));
        persons.forEach(System.out::println);

        String string = "dkasak";
        Predicate<String> isStringLengthGreaterThan20 = s -> s.length() > 20;
        Predicate<String> p2 = s -> s.length() < 10;

        System.out.println(isStringLengthGreaterThan20.test(string));
        System.out.println((p2).test(string));

        Predicate<String> p3 = Predicate.isEqual("dkasak");
        System.out.println(p3.test(string));

    }

}


