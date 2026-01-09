package january_2026;

import java.io.*;
import java.util.*;

public class BOJ_개똥벌레_V2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] top = new int[n / 2];
        int[] bottom = new int[n / 2];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (i % 2 == 0) bottom[i/2] = x;
            else top[i / 2] = x;
        }
        Arrays.sort(top);
        Arrays.sort(bottom);
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 1; i <= h; i++) {
            int b = bottom.length - find(bottom, i);

            int need = h - i + 1;
            int t = top.length - find(top, need);

            int hit = b + t;
            if (hit < min){
                min = hit;
                cnt = 1;
            }
            else if (hit == min) cnt++;
        }
        System.out.println(min + " " + cnt);

    }
    static int find(int arr[], int target){
        int low = 0, high = arr.length;
        while (low < high){
            int mid = (low + high) / 2;
            if (arr[mid]>= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
