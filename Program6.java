public class Program6 {
    static int n;
    static float m, p[], w[];

    static void greedy(){
        float max, u = m, profit = 0;
        int k = 0;

        System.out.println("\nItems included in knapsack: ");

        for(int i = 0; i < n; i++){
            max = 0;

            for (int j = 0; j < n; j++){
                if(w[j] != 0 && (p[i] / w[j]) > max){
                    max = p[i] / w[j];
                    k = j;
                }
            }

            if (w[k] > u){
                System.out.println("Item" + (k + 1) + "selected partially");
                float ratio = u / w[k];
                System.out.println("Fraction used: " + ratio);
                profit += ratio;
                break;
            } else {
                System.out.println("Item" + (k + 1) + "selected");
                u -= w[k];
                profit += w[k];
                w[k] = 0;
                p[k] = 0;
            }
        }

        System.out.println("Total profit: "+ profit);
    }
}
