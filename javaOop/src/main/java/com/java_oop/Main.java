package com.java_oop;

import com.java_oop.logic.BubbleSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BubbleSort<String> sort = new BubbleSort<>();

        System.out.println("[Result] = " + sort.sort(Arrays.asList(args)));
    }
}