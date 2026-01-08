package january_2026;

import java.io.*;
import java.util.*;
public class BOJ_개똥벌레 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] cave = new int[n];
        for (int i = 0; i < n; i++) {
            cave[i] = Integer.parseInt(br.readLine());
        }
        int min = Integer.MAX_VALUE;
        int[] check = new int[h];
        Arrays.fill(check, min);
        double now = 0.5;
        while (now < h){
            int temp = 0;
            for (int i = 0; i < n; i++) {
                // 짝수
                if (i % 2 == 0){
                    if (cave[i] > now){
                        temp += 1;
                    }
                }
                // 홀수
                else {
                    int diff = h - cave[i]; // 5 -3 = 2
                    if (diff < now){
                        temp += 1;
                    }
                }
            }
            int idx = (int) (now - 0.5);
            check[idx] = temp;
            min = Math.min(min, temp);
            // 1 더해주기
            now += 1;
        }
        int ans = 0;
        for (int i = 0; i < h; i++) {
            if (check[i] == min) ans += 1;
        }
        System.out.println(Arrays.toString(check));
        System.out.println(min +" " + ans);
    }
}

/*
/ 1.위 장애물 아래 장애물을 lower(홀수), upper(짝수)로 나눈다.
2. 0.5부터 시작해서 돌리기 시작
3. 되는 거 배열에 적어주면서 최솟값 찾기
4. 한번 더 배열 돌면서 최솟값과 일치하는 갯추 체크
 */