/*
Ex: 2
Title: Sorting elements based on their value.

Problem Description: Run the program for varied values of n to demonstrate the behaviour of
the algorithm in the Worst, Best and Average Cases. Record the time taken to sort. Plot a graph
of the time taken versus n on graph sheet. The elements can be read from a file or can be
generated using the random number generator for large values of n.

Method: A Divide and Conquer approach partitioning the data set on a pivot- Recursive algorithm
implementation.

Theory Reference: Module 2
*/

import java.util.Random;

public class Program2 {
    static int count = 0;

    static int partition(int a[], int l, int r){

        int pivot = a[3];
        int temp;
        int i = l;
        int j = r;

        while (i <= j) {
            while (i <= r && a[i] <= pivot) {
                i++;
                count++;
            }
            while (j >= l && a[j] > pivot) {
                j--;
                count++;
            }

            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //Swap j and l
        temp = a[l];
        a[l] = a[j];
        a[j] = temp;
        return l;
    }

    static void quickSort(int a[], int l, int r){
        //Sorts a subarray of quickSort:
        int s;
        if(l < r){
            //Partition pivot element between left and right group
            s = partition(a, l, r);
            quickSort(a, l, s - 1);
            quickSort(a, s + 1, r);
        }
    }

    public static void main(String[] args) {
        int n[] = { 5000, 6000, 7000, 8000, 9000, 10000};
        Random r = new Random();
        // enum type = {BEST, WORST, AVG};
        for (int i = 0; i < n.length; i++){
            System.out.println("Case n = " + n[i]);
            int a[] = new int[n[i]];

            // System.out.print("\tRandom Case: ");
            for(int j = 0; j < n[i]; j++){
                a[j] = r.nextInt(10000);
            }     
            quickSort(a, 0, n[i] - 1);
            System.out.println("\tBest Case: " + (int)(n[i] * Math.log(n[i]) / Math.log(2)));
            System.out.println("\tNo. of basic operations: " + count);
            System.out.println("\tWorst Case: " + n[i]*n[i]);
            // count = 0;

            // System.out.print("\tBest Case: ");
            // for(int j = 0; j < n[i]; j++){
            //     a[j] = j;
            // }     
            // quickSort(a, 0, n[i] - 1);
            // System.out.println("\n\nBest Case: " + (int)(n[i] * Math.log(n[i]) / Math.log(2)));
            // System.out.println("\nNo. of basic operations: " + count);
            // System.out.println("\nWorst Case: " + n[i]*n[i]);
            // count = 0;

            // System.out.print("\tWorst Case: ");
            // for(int j = n[i] - 1; j >= 0; j--){
            //     a[j] = j;
            // }     
            // quickSort(a, 0, n[i] - 1);
            // System.out.println("\n\nBest Case: " + (int)(n[i] * Math.log(n[i]) / Math.log(2)));
            // System.out.println("\nNo. of basic operations: " + count);
            // System.out.println("\nWorst Case: " + n[i]*n[i]);
            // count = 0;
        }
    }
}
