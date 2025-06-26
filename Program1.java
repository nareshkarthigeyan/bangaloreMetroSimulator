/*
 * 
Title: Program that uses simple technique to a) search a key b) to sort n elements.

Problem Description: Run the program for varied values of n>5000 and record the time taken
to search/sort. Plot a graph of the time taken v/s n. The elements can be read from a file or can
be generated using the random number generator.

Method: A Brute Force- Non recursive algorithm implementation. Sequential Search and
Selection Sort.

Theory Reference: Module 1
 * 
 */

import java.util.*;

 class Program1 {
    static int searchCount = 0;
    static int sortCount = 0;
    static int sequentialSearch(int arr[], int key){
        for(int i = 0; i < arr.length; i++){
            searchCount++;
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    static void selectionSort(int arr[]){
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                sortCount++;
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //Swap the two
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }


     public static void main(String[] args) {
        int n[] = { 5000, 6000, 7000, 8000, 9000, 10000};

        Random r = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("Sequential Search... Enter key to search...");
        int key = s.nextInt();
        
        
        for(int i = 0; i < n.length; i++){
            
            int[] arr = new int[n[i]];
            for (int j = 0; j < n[i]; j++){
                arr[j] = r.nextInt(100);
            }
            
            System.out.println("Sequential Search... key = " + key);
            int foundAt = sequentialSearch(arr, key);

            if(foundAt != -1){
                int StartIndex = foundAt > 5 ? foundAt - 4 : foundAt;
                int endIndex = foundAt + 5 < n[i] ? foundAt + 5 : n[i];
                System.out.print("... ");
                for(int j = StartIndex; j < endIndex; j++){
                    System.out.print(arr[j]);
                    if (j == foundAt) System.out.print("*");
                    System.out.print(" ");
                }
                System.out.println("...");
                System.out.println("Key found at index: " + foundAt);
            } else {
                System.out.println("Key not found!");
            }

            System.out.println("Total number of operations for Linear Search: " + searchCount);

            
            System.out.println("Selection Sort...");

            selectionSort(arr);
            
            for(int j = 0; j < 5; j++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("\nTotal number of operations: " + sortCount);  

            searchCount = 0;
            sortCount = 0;
        }    
    }
}