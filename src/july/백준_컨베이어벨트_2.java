package july;
import java.util.*;
public class 백준_컨베이어벨트_2 {
    static boolean[] robots;
    static int[] belt;
    static int n;
    static int k;
    static int len;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        len = 2 * n;
        robots = new boolean[n];
        belt = new int[len];

        for (int i = 0; i < len; i++) {
            belt[i] = sc.nextInt();
        }

        func();
        System.out.println(answer);
    }

    static void func() {
        int pointer = 0;

        while (true) {
            answer++;

            // 1단계: 벨트 + 로봇 회전
            pointer = (pointer + len - 1) % len;

            // 로봇도 회전 (역순으로 이동)
            for (int i = n - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false; // 회전 직후 0번 칸은 새로 들어온 칸이라 초기화
            robots[n - 1] = false; // 내리는 위치는 항상 비워야 함

            // 2단계: 로봇 이동
            for (int i = n - 2; i >= 0; i--) {
                int next = (pointer + i + 1) % len;

                if (robots[i] && !robots[i + 1] && belt[next] > 0) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    belt[next]--;

                    if (i + 1 == n - 1) {
                        robots[i + 1] = false; // 내리는 위치 도달 시 제거
                    }
                }
            }

            // 3단계: 로봇 올리기
            if (belt[pointer] > 0 && !robots[0]) {
                robots[0] = true;
                belt[pointer]--;
            }

            // 4단계: 내구도 0인 칸 개수 세기
            int zeroCount = 0;
            for (int durability : belt) {
                if (durability == 0) zeroCount++;
            }

            if (zeroCount >= k) break;
        }
    }
}
/*
인덱스:  0   1   2   3   4   5
벨트:   A   B   C   D   E   F

회전 후 벨트:  F   A   B   C   D   E
               ↑
            올리는 위치
 */