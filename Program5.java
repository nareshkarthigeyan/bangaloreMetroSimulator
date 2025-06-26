
public class Program5 {
    static void prim(int cost[][], int n, int source){
        int[] tvertex = new int[n];
        int a = 0, b = 0, min, mincost = 0, ne = 0; //ne = not explored

        //Traveresed vertex
        tvertex[source] = 1;

        while(ne < n - 1){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(tvertex[i] == 1){ //if 
                    for(int j = 0; j < n; j++){
                        if(cost[i][j] < min && tvertex[j] == 0){
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            System.out.println("Pipeline from city " + a + " to city " + b + " and the cost " + min + "units");
            tvertex[b] = 1;
            ne++;
            mincost += min;
        }
        System.out.println("Minimum cost for the network: " + mincost + "units");
    }
}
