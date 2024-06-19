import java.util.*;

public class 다리를_지나는_트럭 {
    static class Solution{
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            ArrayList<Integer> queue = new ArrayList<>();
            for(int i = 0; i < bridge_length; i++){
                queue.add(0);
            }
            for(int i : truck_weights) {
                queue.add(i);
            }

            int sum = 0;


            while(!queue.isEmpty()){
                sum -= queue.get(0);
                queue.remove(0);
                if(queue.size() >= bridge_length){
                    sum += queue.get(bridge_length - 1);
                }
                if(sum > weight) {
                    sum -= queue.get(bridge_length - 1);
                    queue.add(bridge_length - 1, 0);
                }
                answer++;
            }


            return answer;
        }
    }


    public static void main(String[] args) {
        int answer = 0;
        Solution s = new Solution();

        System.out.println(s.solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));


    }
}
