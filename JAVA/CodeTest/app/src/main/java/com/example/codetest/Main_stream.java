package com.example.codetest;

import java.util.Arrays;
import java.util.List;

public class Main_stream {
    public static void main(String[] args) throws Exception {


        String[] myArr = {"a1", "a2", "b1", "c2", "c1","c1","b1"};
        List<String> myList = Arrays.asList(myArr);

        //람다식에서 더블 콜론 의미 : 위아래 식은 동일하다.
        myList.forEach(item -> System.out.println(item));
        myList.forEach(System.out::println);

        Object[] result = myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .toArray();

        System.out.println("result: "+ Arrays.toString(result));


        // 중복 제거
        String[] resultArr = Arrays.stream(myArr).distinct().toArray(String[]::new);
//        String[] resultArr = Arrays.stream(myArr).distinct().toArray(item -> new String[item]);
        System.out.println("distinct: "+ Arrays.toString(resultArr));

    }
}

