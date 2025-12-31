package December;

import java.util.*;
import java.io.*;

public class BOJ_합이0 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        // 0 -2 -2 -2 2 2 2 2 r = 6 l = 1
        Arrays.sort(a);
        long cnt = 0;

        for (int i = 0; i < n-2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r){
                int sum = a[i] + a[l] + a[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    if (a[l] == a[r]){
                        long m = r - l + 1;
                        cnt += m * (m-1) / 2;
                        break;
                    }

                    int lv = a[l];
                    long lc = 0;
                    while (l < r && a[l] == lv){
                        lc ++;
                        l++;
                    }
                    int rv = a[r];
                    long rc = 0;
                    while (l <= r && a[r] == rv){
                        rc ++;
                        r--;
                    }
                    cnt += lc * rc;
                }
            }
        }
        System.out.println(cnt);
    }
}
