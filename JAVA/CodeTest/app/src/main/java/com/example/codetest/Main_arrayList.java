package com.example.codetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_arrayList {
    public static void main(String[] args) throws Exception {

        List<String> list1 = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
            }
        };

        String[] myArr= {"1","2","3"};
        List<String> list2 = Arrays.asList(myArr);


        System.out.println("list1: "+list1);
        System.out.println("list2: "+list2);


    }
}

