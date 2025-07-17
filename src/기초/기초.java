package 기초;

import java.util.*;

public class 기초 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5}, {4, 1, 3}, {2, 3, 4}};

        /*
        오름 차순 원하면 이차원 배열 정렬 시에 o1 - o2가 음수라면 순서를 유지
        1 2 형태라면 음수나 나옴 오름차순이네? 유지 즉 음수가 나오면 유지고 양수가 나오면 순서를 바꾼다.
        즉 양수가 나오면 순서를 바꾸고 음수가 나오면 순서를 유지한다.
        */
        Arrays.sort(arr, (o1, o2) -> o1[2]- o2[2]);
        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr, (o1, o2) -> o2[2]-o1[2]);
        System.out.println(Arrays.deepToString(arr));

    }
}
