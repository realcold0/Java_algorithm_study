import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < truck_weights.length;i++){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck_weights[i]);
                    currentWeight += truck_weights[i];
                    answer++;
                    break;
                }else if(queue.size() >= bridge_length){
                    currentWeight -= queue.poll();
                }
                else{
                    if(currentWeight + truck_weights[i] <= weight){
                        queue.add(truck_weights[i]);
                        currentWeight += truck_weights[i];
                        answer++;
                        break;
                    }else{
                        queue.add(0);
                        answer++;
                    }
                }

            }

        }
        answer  += bridge_length;
        return answer;
    }
}