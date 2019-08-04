package sortingLab;

import java.util.*;

public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList<Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        steps = 0;
        for (int outer = 0; outer < list.size() - 1; outer++){
            for (int inner = 0; inner < list.size()-outer-1; inner++){
                steps += 3;//count one compare and 2 gets
                if (list.get(inner)>(list.get(inner + 1))){
                    steps += 4;//count 2 gets and 2 sets
                    int temp = list.get(inner);
                    list.set(inner,list.get(inner + 1));
                    list.set(inner + 1,temp);
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList<Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();

        for (int i = 0; i < list.size() - 1; i++) {
            int minIndx = i;
            for (int j = i; j < list.size(); j++) {
                steps += 3;
                if (list.get(j) < list.get(minIndx)) {
                    minIndx = j;
                }
            }
            steps += 4;
            int temp = list.get(i);
            list.set(i, list.get(minIndx));
            list.set(minIndx, temp);
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList<Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            steps += 3;
            int val = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > val) {
                steps += 2;
                list.set(j + 1, list.get(j));
                j--;
            }
            steps += 1;
            list.set(j + 1, val);
        }
    }

     /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void mergeSort(ArrayList<Integer> list, int lo, int hi){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
        split(list, 0, list.size() - 1);
    }
    public void split(ArrayList<Integer> list, int lo, int hi) {
        if (lo < hi) {
            split(list, lo, (lo + hi) / 2);
            split(list, (lo + hi) / 2 + 1, hi);
            merge(list, lo, hi);
        }
    }
    public void merge(ArrayList<Integer> list, int lo, int hi) {
        int mid = (lo + hi) / 2;
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        for (int i = lo; i <= mid; i++) {
            one.add(list.get(i));
            steps += 2;
        }
        for (int i = mid + 1; i <= hi; i++) {
            two.add(list.get(i));
            steps += 2;
        }
        int p1 = 0, p2 = 0, p = lo;
        while (p1 < one.size() && p2 < two.size()) {
            steps += 2; //.size()
            steps += 2; //.get()
            if (one.get(p1) < two.get(p2)) {
                list.set(p++, one.get(p1++));
                steps += 2;
            } else {
                list.set(p++, two.get(p2++));
                steps += 2;
            }
        }
        while (p1 < one.size()) {
            steps += 3;
            list.set(p++, one.get(p1++));
        }
        while (p2 < two.size()) {
            steps += 3;
            list.set(p++, two.get(p2++));
        }
    }
    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}
