package streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class StreamsMain {

    private static void arrayIterate(){

        List<Integer> lists=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0,11));

        lists.forEach(list->{
            System.out.println(list);
        });


        Consumer<Integer> streamsMethod = list->{
            System.out.println("Interface Methods: "+list);
        };

        lists.forEach(streamsMethod);


    }

    private static void sortByAlphabet(List<String> lists){

        lists.sort((option1,option2)-> option1.compareTo(option2));

        //Collections.sort(lists, String::compareTo);

        System.out.println(lists);

    }

    private static void findMaxAndMin(List<Integer> lists){

       int MAX_number= max(lists, Comparator.comparing((num1) -> num1));

        int MIN_number= min(lists, Comparator.comparing((num) -> num));

        System.out.println(Collections.max(lists, Comparator.comparing(num -> num)));

        System.out.println("Max number: "+MAX_number+" Min number: "+MIN_number);
    }

    public static void main(String args[]){

        //arrayIterate();

        /*List<Integer> numberkeys = new ArrayList<Integer>();
        numberkeys.add(200);
        numberkeys.add(3);
        numberkeys.add(523);
        numberkeys.add(239);
        numberkeys.add(23);
        numberkeys.add(4);

        List<String> keys = new ArrayList<String>();
        keys.add("Parrot");
        keys.add("Carrot");
        keys.add("Ball");
        keys.add("Rain");
        keys.add("Pink");
        keys.add("Black");

        sortByAlphabet(keys);
        findMaxAndMin(numberkeys);*/







    }
}
