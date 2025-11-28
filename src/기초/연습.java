package 기초;

import java.util.*;

public class 연습 {
    public static void main(String[] args){
        // 컬렉션
        List<String> list = new ArrayList<>();
        List<String>list1 = new ArrayList<>();

        if(list.isEmpty()){
            System.out.print("나가");
        }
        list.add("메롱");
        if (list.contains("메롱")){
            list.remove("메롱");
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        set.add(1);
        if (set.contains(1)){
            set.remove(1);
        }
        if (set.isEmpty()){
            System.out.print("콰욱");
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("키",1);

        if (map.containsKey("키")){
            map.remove("키");
        }
        int[] arr = new int[5];
        Queue<String> q = new LinkedList<>();
        Queue<String> q2  = new LinkedList<>();

        q.offer("이게 나야..");
        q.peek(); // 맨 앞에 있는 거 확인
        if (q.isEmpty()){
            System.out.print("이게 나라면 믿어줄래?");
        }
        String ex = "ZZZ";
        int s = 2;
        if (ex.equals("ZZZ")){
            System.out.println("초비상!!!!!!!!!!!!!");
        }

        int[] arr2 = new int[3];
        arr2[1] = 2;
        
        int num = 10;
        double d = num;
        System.out.println(d);

        String[] a = new String[3];
        String[] a1 = a;
        a1.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.pop();


    }
}
