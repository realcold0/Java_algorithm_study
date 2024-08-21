package boj.greedy.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] days = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                days[j] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> wallet = new Stack<>();
            int answer = 0;
            //주식 그래프의 꼭짓점 구하기 처음과 끝은 기본으로 넣고 시작한다.
            Deque<Integer> list = new ArrayDeque<>();
            int max = days[0];
            list.add(days[0]);
            int prev = days[0];
            boolean asc  = days[0] < days[1];
            for(int j = 1; j < n-1; j++){
                if(prev < days[j] && asc){

                }else if(prev > days[j] && !asc){

                }
                else
                {
                    list.add(days[j]);
                    max = Math.max(max, days[j]);
                    asc = !asc;
                }
                prev = days[j];
            }
            list.add(days[n-1]);
            //꼭짓점을 순회하며 현재 위치에서 다음위치를 비교하여
            // 내려가면 가지고있다면 팔고 / 없다면 stay
            // 올라가면 산다
            for(int j = 0; j < n && !list.isEmpty(); j++){
                int nowEdge = list.poll();
                if(days[j]<=nowEdge){
                    wallet.push(days[j]);
                }else if(!list.isEmpty() &&days[j] ==max){
                    int nextEdge = list.peek();
                    while (!wallet.isEmpty()&&wallet.peek() < nowEdge) {
                        answer += nowEdge - wallet.peek();
                        wallet.pop();
                    }

                    if(nowEdge !=days[j]){
                        list.addFirst(nowEdge);
                    }
                }else {
                    while(!wallet.isEmpty()){
                        answer += nowEdge - wallet.peek();
                        wallet.pop();
                    }
                    break;
                }
            }
            System.out.println(answer);

        }







    }
}
