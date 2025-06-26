public class Program7 {
    
    static void krushkal(int cost[][], int n){
        int[] par = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = -1;
        }

        int a = 0, b = 0, u = 0, v = 0, min, mincost = 0, ne = 0;

        while(ne < n - 1){
            min = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(cost[i][j] < min){
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }

            while (par[u] != -1) u = par[u];
            while (par[v] != -1) v = par[v];

            if(u != v){
                System.out.println("Cost of laying town " + a + " to town " + b + " is " + min + " lakhs");
                mincost += min;
                ne++;

                if(u < v){
                    par[v] = u;
                } else {
                    par[u] = v;
                }
            }

            cost[a][b] = cost[b][a] = Integer.MAX_VALUE;
        }
        System.out.println("Total Cost of laying entire road network is: " + mincost + "Lakhs");
    }
}
