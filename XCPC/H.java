package XCPC;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class H {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cipher.in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder encrypted = new StringBuilder( br.readLine());
        StringBuilder original = new StringBuilder( br.readLine());
        StringBuilder key = new StringBuilder();
        char alpha []= new char[26];
        for (int i = 0; i <26 ; i++) {
            alpha[i]= (char) ('a'+i);
        }
        for (int i = 0; i < original.length() ; i++) {
            if(original.charAt(i)==' ')continue;
            int shift = encrypted.charAt(i)-original.charAt(i)+26;
            key.append(alpha[shift%26]);
        }
        StringBuilder keySoFar=new StringBuilder(key.charAt(0)+"");
        int repetition = 1;
        int idx=0;
        for (int i = 1; i <key.length() ; i++) {
            if(idx==keySoFar.length()){
                idx=0;repetition++;
            }
            if(keySoFar.charAt(idx)==key.charAt(i)){
                idx++;
            }else{
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j <repetition ; j++) {
                    temp.append(keySoFar);
                }
                temp.append(keySoFar.substring(0,idx));
                temp.append(key.charAt(i));
                keySoFar=temp;
                repetition=1;
                idx=0;
            }
        }
        pw.println(keySoFar);



        pw.close();

    }
}
