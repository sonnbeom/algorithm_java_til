package june_second_week_2025;

public class 프로그래머스_부족한금액계산하기 {
        public long solution(int price, int money, int count) {
            long answer = -1;

            double temp = count / 2.0;
            int tempSum = 2 * price + (count-1) * price;
            int totalPrice = (int)(temp * tempSum);

            if (money >= totalPrice){
                answer = 0;
            }
            else{
                answer = totalPrice - money;
            }

            return answer;
        }
}
