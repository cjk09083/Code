package com.example.codetest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main_hash {
    public static void main(String[] args) throws Exception {

        // HashSet : 중복 제거
        Integer[] arr = { 3,2,1,3,5,4,4 };
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(arr));
        Integer[] resultArr = hashSet.toArray(new Integer[0]);
        System.out.println("HashSet Integer: "+ Arrays.toString(resultArr));

        String[] arrStr = { "3","2","1","3","5","4","4" };
        HashSet<String> hashSetStr = new HashSet<>(Arrays.asList(arrStr));
        String[] resultArrStr = hashSetStr.toArray(new String[0]);
        System.out.println("HashSet String: "+ Arrays.toString(resultArrStr));

        // LinkedHashSet : 중복 제거 && 순서 보장
        Integer[] arrL = { 3,2,1,3,5,4,4 };
        LinkedHashSet<Integer> linkedHashSet =
                new LinkedHashSet<>(Arrays.asList(arrL));
        Integer[] resultArrL = linkedHashSet.toArray(new Integer[0]);
        System.out.println("LinkedHashSet Integer: "+ Arrays.toString(resultArrL));

        String[] arrStrL = { "3","2","1","3","5","4","4" };
        LinkedHashSet<String> linkedHashSetStr =
                new LinkedHashSet<>(Arrays.asList(arrStrL));
        String[] resultArrStrL = linkedHashSetStr.toArray(new String[0]);
        System.out.println("LinkedHashSet String: "+ Arrays.toString(resultArrStrL));

    }
}

