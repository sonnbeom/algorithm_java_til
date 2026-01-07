package january_2026;

import java.io.*;
import java.util.*;
public class BOJ_구간나누기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int h = Integer.MIN_VALUE;
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (s < l) l = s;
            if (s > h) h = s;
            arr[i] = s;
        }
        int high = h-l;
        int low = 0;
        int ans = high;

        while (low <= high){
            int mid = (high + low)/ 2;
            int cnt = 1;

            int curMin = arr[0], curMax = arr[0];
            for (int i = 1; i < n; i++) {
                curMin = Math.min(curMin, arr[i]);
                curMax = Math.max(curMax, arr[i]);

                if (curMax - curMin > mid){
                    cnt++;
                    curMin = curMax = arr[i];
                }
            }

            if (cnt <= m){
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
/*
* 1. 중간 값을 정하고 (mid) = answer 여기서 나눠서 탐색 여기서 high는 max-min 미니멈은 모름
* 1 5 4 6 2 1 3 7
* high: 6 mid는 3
* 2. mid가 안 되네? -> low = mid +1
* 3. mid가 되네? -> high = mid
* 4. while 문을 돌면서 2가지 체크
* 4-1. 현재 나눈 구간이 m을 넘기냐?
* 4-2. x를 넘기냐?
* */