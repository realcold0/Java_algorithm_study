import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_weight = 0; // 다리 위에 올라가 있는 트럭 무게

        Queue<Integer> queue_bridge = new LinkedList<>(); // 다리 위에 있는 트럭 큐
        Queue<Integer> queue_wait = new LinkedList<>(); // 대기하는 트럭 큐

        for (int i = 0; i < bridge_length; i++) {
            queue_bridge.offer(0); // 다리 위에 있는 트럭 큐 초기화
        }

        for (int i = 0 ; i < truck_weights.length; i++) {
            queue_wait.offer(truck_weights[i]); // 대기하는 트럭 큐에 추가
        }

        while (!queue_bridge.isEmpty()) {
            answer++;
            truck_weight -= queue_bridge.poll(); // 다리 위 맨 앞 트럭 무게 빼줌

            if (!queue_wait.isEmpty()) {
                if (truck_weight + queue_wait.peek() <= weight) {
                    int tmp = queue_wait.poll();
                    truck_weight += tmp; // 대기 중인 맨 앞 트럭 다리 위에 추가
                    queue_bridge.offer(tmp);
                } else {
                    queue_bridge.offer(0);
                }
            }
        }
        return answer;
    }
}