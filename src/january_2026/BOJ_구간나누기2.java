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
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (s < low) low = s;
            if (s > high) high = s;
            arr[i] = s;
        }
        boolean[] visited = new boolean[n];
        int ans = Integer.MAX_VALUE;
        while (true){
            int mid = (high-low)/ 2;
            int temp = Integer.MIN_VALUE;
            if (visited[mid]){
                break;
            }
            visited[mid] = true;
            int check = 0;
            int now = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                // 숫자 체크
                now = Math.max(arr[i], now);
                // 만약 크다면 그냥 넘겨도 됨
                int diff = Math.abs(now - arr[i]);
                if (diff >= mid){
                    temp = Math.max(diff, temp);
                    continue;
                }
                else {
                    check += 1;
                }
                // 숫자를 넣을 수가 없다
                if (check > m){
                    break;
                }
            }

            if (check > m){
                low = mid + 1;
            }
            else {
                ans = Math.min(ans, temp);
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