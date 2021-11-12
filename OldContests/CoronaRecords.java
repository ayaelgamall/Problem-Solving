package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoronaRecords {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("records.in"));
        int T = Integer.parseInt(br.readLine());
        int[] a= new int[5];
//        0 =Graznavia , 1=Idris , 2=Kyria, 3=Nairomi, 4=Odan,

        while (T-- > 0){
            Arrays.fill(a,0);
            int x = Integer.parseInt(br.readLine());
            while(x-->0){
                String s = br.readLine();
                switch (s){
                    case "Graznavia" : a[0]++;break;
                    case "Idris" : a[1]++;break;
                    case "Kyria" : a[2]++;break;
                    case "Nairomi" : a[3]++;break;
                    default: a[4]++;
                }


            }
            for (int i =0 ; i<5 ;i++){
                int r = Integer.MAX_VALUE;
                int n =-1;
                for (int j =0 ; j<5 ;j++){
                    if(a[j]<r && a[j]!=-1){
                        r= a[j];
                        n=j;

                    }

                }
                a[n]=-1;
                switch (n){
                    case 0:System.out.print("Graznavia " );break;
                    case 1:System.out.print("Idris " );break;
                    case 2:System.out.print("Kyria " );break;
                    case 3:System.out.print("Nairomi " );break;
                    default:System.out.print("Odan " );break;


                }
            }
            System.out.println();
        }
    }
}
