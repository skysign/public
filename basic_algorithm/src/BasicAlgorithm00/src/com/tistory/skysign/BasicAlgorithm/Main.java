package com.tistory.skysign.BasicAlgorithm;

import com.tistory.skysign.BasicAlgorithm.BinaryTree.InOrder;
import com.tistory.skysign.BasicAlgorithm.BinaryTree.PostOrder;
import com.tistory.skysign.BasicAlgorithm.BinaryTree.PreOrder;
import com.tistory.skysign.BasicAlgorithm.Chapter11.Section01;
import com.tistory.skysign.BasicAlgorithm.Chapter11.Section03;
import com.tistory.skysign.BasicAlgorithm.Chapter11.Section04;
import com.tistory.skysign.BasicAlgorithm.Extra.ChineseRemainderTheorem.Solve;
import com.tistory.skysign.BasicAlgorithm.Search.BinarySearch;
import com.tistory.skysign.BasicAlgorithm.Sort.*;

public class Main {
   /**
     * @param args
     */
    public static void main(String[] args) {
        InOrder.run();
        PreOrder.run();
        PostOrder.run();

        System.out.println("SelectionSort");
        SelectionSort.run();
        System.out.println("InsertionSort");
        InsertionSort.run();
        System.out.println("BubbleSort");
        BubbleSort.run();
        System.out.println("ShellSort");
        ShellSort.run();
        System.out.println("QuickSort");
        QuickSort.run();
        System.out.println("RadixSort");
        RadixSort.run();
        System.out.println("MergeSort");
        MergeSort.run();
        System.out.println("MergeSort2");
        MergeSort2.run();
        System.out.println("HeapSort");
        HeapSort.run();
        System.out.println("BinarySearch");
        BinarySearch.run();
        System.out.println("Chapter10");
        System.out.println("Section03");
        Section01.run11_01();
        Section03.run11_03();
        Solve.run();
        Section03.run11_03();
        Section04.run11_04();
    }
}