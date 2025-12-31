package December;

import java.util.*;
import java.io.*;

public class BOJ_합이0 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = students[i] + students[j] + students[k];
                    if (sum == 0){
                        cnt ++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
