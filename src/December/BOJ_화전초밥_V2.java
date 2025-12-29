package December;
import java.io.*;
import java.util.*;

public class BOJ_화전초밥_V2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수(번호 범위)
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수(윈도우 크기)
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 초밥 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) belt[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[d+1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            int x = belt[i];
            if (cnt[x] == 0){
                distinct ++;
            }
            cnt[x]++;
        }

        int max = distinct;
        if (cnt[c] == 0){
            max += 1;
        }

        for (int i = 1; i < N; i++) {
            // 빠지는 초밥
            int out = belt[i-1];
            cnt[out]--;
            if (cnt[out] == 0) distinct--;

            // 들어오는 초밥
            int in = belt[(i + k -1) % N];
            if (cnt[in] == 0) distinct++;
            cnt[in]++;

            int plus = cnt[c] == 0 ? 1 : 0;
            max = Math.max(distinct+plus, max);

        }
        System.out.println(max);
    }
}
