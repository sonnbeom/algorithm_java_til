//package December;
//import java.util.*;
//public class BOJ_DSLR_RE {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        int output =  sc.nextInt();
//        String answer = "";
//        bfs(input, output, answer);
//
//    }
//    static void bfs(int input, int output, String answer){
//        Queue<Pai> q = new LinkedList<>();
//        Pai pair = new Pai(input, output, answer);
//        q.offer(pair);
//        while (q.isEmpty()){
//
//        }
//    }
//    static int D(int input){
//        return 2;
//    }
//    static int S(int input){
//        input += 1;
//        if (input == 10000){
//            return 1;
//        }
//        else return input;
//    }
//    static class Pai{
//        int num;
//        int output;
//        String str;
//        public Pai(int num, int output, String str){
//            this.num = num;
//            this.output = output;
//            this.str = str;
//        }
//    }
//}
