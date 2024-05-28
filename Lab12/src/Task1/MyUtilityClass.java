package Task1;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;

public class MyUtilityClass {

    // printare
    public static <T> void printCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        System.out.println(collection);
    }

    // agregare
    public static <T, R> R aggregate(Collection<T> collection, R initial, BiFunction<R, T, R> accumulator) {
        if (collection == null || accumulator == null) {
            throw new IllegalArgumentException("Collection and accumulator cannot be null");
        }
        R result = initial;
        for (T element : collection) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    // duplicare
    public static <T> Collection<T> duplicateCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        List<T> duplicatedList = new ArrayList<>();
        for (T element : collection) {
            duplicatedList.add(element);
            duplicatedList.add(element);
        }
        return duplicatedList;
    }

    public static void main(String[] args) {
        // Exemple de utilizare
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        MyUtilityClass.printCollection(integers); // output: [1, 2, 3, 4, 5]

        Collection<String> strings = List.of("ana", "are", "mere");
        MyUtilityClass.printCollection(strings); // output: [ana, are, mere]

        List<Boolean> booleans = List.of(true, false, true, false, true);
        {
            boolean result = MyUtilityClass.aggregate(booleans, true, (acc, v) -> acc && v);
            System.out.println(result); // output: false
        }
        {
            int result = MyUtilityClass.aggregate(booleans, 0, (acc, v) -> v ? acc + 1 : acc);
            System.out.println(result); // output: 3
        }


        List<Person> persons = List.of(
                new Person("Aurel"),
                new Person("Vali")
        );

        Collection<Person> duplicatedPersons = MyUtilityClass.duplicateCollection(persons);
        MyUtilityClass.printCollection(duplicatedPersons); // output: [Person(name=Aurel), Person(name=Aurel), Person(name=Vali), Person(name=Vali)]
    }


    public static record Person(String name) {}
}
