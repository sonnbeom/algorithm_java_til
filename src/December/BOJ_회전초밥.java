package December;
import java.util.*;
import java.io.*;

public class BOJ_회전초밥 {
    static int N, d, k, c, max;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        max = 0;

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int end = N - k;

        for (int i = 0; i <= end; i++) {
            max = Math.max(func(i), max);
        }
        System.out.println(max);
    }
    static int func(int idx){
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < idx + k; i++) {
            int next = list.get(i);
            set.add(next);
        }
        set.add(c);
        return set.size();
    }
}







