package TeamContest1_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Insominia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int res = 1;
        for (int i= k-1;i>1;i--){
            if(k%i==0)res++;
        }
        System.out.println(res);

    }



}
