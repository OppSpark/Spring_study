package com.java_oop.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaSortTest {
    @DisplayName("자바 기본 콜랙션 정렬")
    @Test
    void given_List_WhenExecuting_ThenReturnSortedLust(){
        BubbleSort<Integer> javaSort = new BubbleSort<>();

        List<Integer> actial =javaSort.sort(List.of(3,2,4,5,1));

        assertEquals(List.of(1,2,3,4,5), actial);

    }
}