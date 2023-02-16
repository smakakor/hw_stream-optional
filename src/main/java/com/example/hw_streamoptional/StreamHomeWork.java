package com.example.hw_streamoptional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class StreamHomeWork {
    public static void main(String[] args) {
        findMaxMin(Stream.of(1,2,3,4,5,6,-1,-5,123),Integer::compareTo,(min,max)->{
            System.out.println(min + "\n" + max);
        });
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,10);

        System.out.println(evenNumbers(list));
    }
    public static <T> void findMaxMin(Stream<? extends T> stream,Comparator<? super T> order,BiConsumer<? super T,?super T> minMaxConsumer) {
        Object[] objects = stream.sorted(order).toArray();
        minMaxConsumer.accept((T) objects[0],(T) objects[objects.length-1]);
    }
    public static int evenNumbers(List<Integer> list){
        List<Integer> res = list.stream().filter(integer -> integer % 2 == 0).toList();
        return res.size();
    }
}
