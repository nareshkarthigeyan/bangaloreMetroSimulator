import java.util.Scanner;

public class Program9 {
    static int min(int a, int b){
        return (a < b) ? a : b;
    }

    static void floyd(int D[][], int n){
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    D[i][j] = min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;

        System.out.print("Enter number of stations: ");
        n = s.nextInt();

        int[][] cost = new int[n][n];

        System.out.println("Enter the travel time between stations:");
        System.out.println("(Enter 0 if no direct route between different stations)");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = s.nextInt();
                if (i != j && cost[i][j] == 0)
                    cost[i][j] = 999; // Treat 999 as 'infinite' for unreachable stations
            }
        }

        floyd(cost, n);

        System.out.println("\nShortest travel time between all stations:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] == 999)
                    System.out.print("INF ");
                else
                    System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        s.close();
    }
}
