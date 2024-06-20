import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        // 트럭 배열의 길이를 반복하며 다리를 건너도록 한다.
        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];
            
            while(true){
                // 다리 위에 아무것도 없는 경우 = 큐가 비어있는 경우
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if(queue.size() == bridge_length){
                    // 큐의 사이즈가 다리의 길이와 동일한 경우 
                    sum -= queue.poll();                   
                }
                else {
                    // 큐에 하나만 올라가있을 경우
                    // sum과 현재 트럭의 값이 weight 보다 작거나 같으면 트럭 하나가 더 올라갈 수 있음
                    if(sum+truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    else {
                        // 현재 하나로도 무게가 가득 찬다면
                        // queue에 0을 강제로 add해주어 값을 앞으로 밀어주면서 time을 증가시켜준다
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}