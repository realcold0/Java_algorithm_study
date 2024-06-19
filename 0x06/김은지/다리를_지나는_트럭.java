import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 다리를_지나는_트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> onWay = new ArrayDeque<>(); //한번에 초기값 선언 할 수 있는 방법이 없을까?
        Deque<Integer> ready = new ArrayDeque<>();
        for(int i= 0 ; i < bridge_length;i++){
            onWay.addLast(0);
        }
        for(int i = 0; i < truck_weights.length; i++){
            ready.addLast(truck_weights[i]);
        }

        System.out.println("초기 onWay"+ onWay);
        int currWeight = 0;
        int idx=0;
        int fin = 0;
        while(fin < truck_weights.length){
            System.out.println("현재 currWeight : "+ currWeight +"//idx: "+ idx +"//fin: "+ fin);
            //1. 일단 onWay 한 칸 이동
            int arrived = onWay.pollFirst();
            if (arrived != 0){
                System.out.println("arrived"+arrived);
                fin++;
            }
            currWeight -= arrived;
            //2. onWay에 0을add할지, truck_weight를 add할 지 정하기
            if(!ready.isEmpty() && currWeight+ ready.peekLast() <=weight){
                onWay.addLast(ready.peekLast());
                currWeight += ready.pollLast();
            }else{
                onWay.addLast(0);
            }
            //3. 항상 시간은 지난다!
            answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,10, new int[]{7, 4, 5, 6}));
    }

}
