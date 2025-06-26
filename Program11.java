
import java.util.Scanner;

public class Program11 {
    static int[] x, w;
    static int count = 0, d;
    static String[] categories;



    public static void main(String[] args) {
        int sum = 0, n;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of categories: ");
        n = s.nextInt();

        w = new int[n];
        x = new int[n];
        categories = new String[n];

        s.nextLine();

        System.out.println("Enter category and budget: ");
        for(int i = 0; i < n; i++){
            System.out.println("Category "+  (i + 1) + " name: ");
            categories[i] = s.nextLine();
            System.out.println("Category "+  (i + 1) + " Budget: ");
            w[i] = s.nextInt();
            s.nextLine();
            sum += w[i];
        }

        System.out.println("Enter total budget: ");
        d = s.nextInt();


        if(sum < d || w[0] > d){ //if sum of all budget < total budget || first budget is greater than total budget
            System.out.println("No Subset possible - unable to host the event!");
        } else {
            System.out.println("\nPossible event plans within the budget: ");
            sumOfSubsets(0, 0, sum);
            if(count == 0){
                System.out.println("No valid subset found");
            }
        }
    }

    static void sumOfSubsets(int s, int k, int rem){
        x[k] = 1;

        if(s + w[k] == d){
            System.out.println("Event Planning: " + ++count);
            for (int i = 0; i <= k; i++) {       
                if(x[i] == 1){
                    System.out.println(categories[i] + ": " + w[i]);
                }         
            }
        }

        else if (k + 1 < w.length && s + w[k] + w[k + 1] <= d){
          sumOfSubsets(s + w[k], k + 1, rem - w[k]);
        }
        if( k + 1 < w.length && (s + rem - w[k] >= d) && (s + w[k + 1] <= d)){
            x[k] = 0;
            sumOfSubsets(s, k + 1, rem - w[k]);
        }
    }
}
