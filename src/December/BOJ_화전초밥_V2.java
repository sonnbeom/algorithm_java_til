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


    }
}
