import java.util.Scanner;

public class Program12 {
    static int a[][];
    static int n;
    static int source = 0;

    static void path(int[] succ){
        System.out.print(source  + "->");
        for(int j = succ[source]; j != source && j != -1; j = succ[j]){
            System.out.print(j + "->");
        }
        System.out.println(source);
    }

    static void ckt(int st, int[] succ, int visited){
        int[] temp = new int[n];

        if(visited == n && a[st][source] == 1){
            path(succ);
            return;
        }

        for(int i = 0; i < n; i++){
            if(a[st][i] == 1 && succ[i] == -1){
                succ[st] = i;
                System.arraycopy(succ, 0, temp, 0, n);
                ckt(i, temp, visited + 1);
            }
        }
    }

     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of delivery locations (vertices): ");
        n = s.nextInt();

        a = new int[n][n]; // adjacency matrix
        int[] succ = new int[n]; // stores path

        System.out.println("Enter the adjacency matrix (0/1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }

        // Initialize path: all nodes are initially unvisited (-1)
        for (int i = 0; i < n; i++) {
            succ[i] = -1;
        }

        System.out.println("\nRoutes for delivery vehicle (Hamiltonian Circuits):");
        ckt(source, succ, 1);
    }
}
