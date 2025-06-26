import java.util.Scanner;

public class Program10 {
    static int n, m;
    static int[] p, w;

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static void knapsackDP(){
        int[][] v = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    v[i][j] = 0;
                } else if ( j < w[i]){
                    v[i][j] = v[i - 1][j];
                } else {
                    v[i][j] = max(v[i - 1][j], p[i] + v[i - 1][j - w[i]]);  
                }
            }
        }

        //DP TABLE:
        System.out.println("\nDP Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        // Trackback to find selected items
        System.out.println("\nOPTIMAL PROFIT IS: " + v[n][m]);

        System.out.println("Products selected for shelf that yeilds maximum profit are:");

        int i = n;
        int j = m;
        while(i != 0){
            if(v[i][j] != v[i - 1][j]){
                System.out.println(i + " ");
                j -= w[i];
            }
            i--;
        }
    }

        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        n = s.nextInt();
        p = new int[n + 1];
        w = new int[n + 1];

        System.out.println("Enter the weights of the products:");
        for (int i = 1; i <= n; i++)
            w[i] = s.nextInt();

        System.out.println("Enter the profits of the products:");
        for (int i = 1; i <= n; i++)
            p[i] = s.nextInt();

        System.out.print("Enter the capacity of the shelf (Knapsack): ");
        m = s.nextInt();

        knapsackDP();
        s.close();
    }
}
