import java.util.Scanner;

public class Program8 {
    static int min(int a, int b){
        return a < b ? a : b;
    }

    static void dijkrsta(int cost[][], int source, int n){
        int[] visited = new int[n];
        int[] dist = new int[n];

        System.arraycopy(cost[source], 0, dist, 0, n);
        visited[source] = 1;
        dist[source] = 0;

        for(int i = 0; i < n - 1; i++){
            int min = Integer.MAX_VALUE;
            int u = -1;

            for(int j = 0; j < n; j++){
                if(visited[j] == 0 && dist[j] < min){
                    min = dist[j];
                    u = j;
                }
            }

            if( u == -1 ) break;
            visited[u] = 1;

            for(int v = 0; v < n; v++){
                if(visited[v] == 0 && cost[u][v] != Integer.MAX_VALUE){
                    dist[v] = min(dist[v], dist[u] + cost[u][v]);
                }
            }
        }

        System.out.println("Shortest Travel Times From City " + source + ":");
        for(int v = 0; v < n; v++){
            if(dist[v] == Integer.MAX_VALUE){
                System.out.println("to city " + v + " = unreachable!");

            } else {
                System.out.println("to city " + v + " = " + dist[v] + "hours");
            }
        }
    }

     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int n = s.nextInt();

        int[][] cost = new int[n][n];

        System.out.println("Enter the travel time between each pair of cities (0 if no direct route):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = s.nextInt();
                if (i != j && cost[i][j] == 0)
                    cost[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.print("Enter the source city: ");
        int source = s.nextInt();

        dijkrsta(cost, source, n);
        s.close();
    }
}
