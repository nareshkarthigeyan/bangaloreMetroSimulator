public class Program3 {
    
   static void merge(int[] b, int c[], int a[]){
        int i = 0, j = 0, k = 0;
        int p = b.length, q = c.length;
        while(i < p && j < q){
            if(b[i] < c[j]){
                a[k] = b[i];
                i++;
            } else {
                a[k] = c[j];
                j++;
            }
            k++;
            
            while( i < p ) a[k++] = b[i++];
            while ( j < q ) a[k++] = c[j++];
        }
    }

    static void mergeSort(int a[]){
        int n = a.length;
        if(n > 1){
            int p = (int) Math.floor(n/2);
            int q = (int) Math.ceil(n/2);

            int b[] = new int[p];
            int c[] = new int[q];

            System.arraycopy(a, 0, b, 0, p);
            System.arraycopy(a, p, c, 0, q);

            mergeSort(b);
            mergeSort(c);
            merge(b, c, a);
        }
    }
}
