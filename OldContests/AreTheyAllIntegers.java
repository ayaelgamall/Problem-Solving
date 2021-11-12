package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AreTheyAllIntegers {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            a[i]= Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = 0; k <n ; k++) {
                    if(i!=j && i!=k && j!=k){
                    double temp = (a[i]-a[j])/(double)a[k];
                    if(temp != (int)temp){
                        System.out.println("no");
                        return;
                    }
                    }

                }
            }
        }
        System.out.println("yes");
    }
}
