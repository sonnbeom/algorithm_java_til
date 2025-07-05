import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);
        System.out.println(list);
        list.remove(1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list.remove(2);

        int[] arr = new int[3];

        arr[0] = 3;

        String[] strList = new String[4];
        int length = strList.length;
        String str = "str";
        str.length();

        HashSet<Integer> set = new HashSet<>();
        set.add(20);
        set.add(30);

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("hi");

        set.remove("hi");
        System.out.println(set);
        set.remove(20);
        System.out.println(set);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("2", 2);
        boolean b = map.containsKey("2");
        System.out.println(b);
        System.out.println(map.get("2"));

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("2", "@");
        map2.remove("@", "1");
        boolean b2 = map2.containsKey("@");
        map2.get("@");
        Stack<String> stack = new Stack<>();

        Stack<String> stack1 = new Stack<>();
        stack1.push("Sr");
        String peekdd = stack1.peek();
        stack1.pop();
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println("4가 나와야겠지? " + stack.pop());
        System.out.println("가장 상단은 무엇인가 3이겠죠 " + stack.peek());

        Queue<String> q = new LinkedList<>();
        q.offer("one");
        q.offer("two");
        q.offer("three");
        System.out.println(q.peek());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Integer one = queue.poll();
        boolean isEmpty = queue.isEmpty();

        System.out.println("one이 나오겠죠"+ q.poll());
        System.out.println("q가 비었나요? false 겠죳"+ q.isEmpty());

        A b = new B();
        b.paint();

    }

    class A{
        void draw(){
            System.out.println("부모");
            draw();
        }
    }
    class B extends A{
        void draw(){
            System.out.println("자식");
        }
        void paint(){
            super.draw();
        }
    }
}