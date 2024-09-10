package boj.greedy.multitapscheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] schedule=  new int[n];
        //빈도수 Map<종류,카운트>
        Map<Integer,Integer> map = new HashMap<>();
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int now = Integer.parseInt(st.nextToken());
            schedule[i] = now;
            map.put(now, map.getOrDefault(now, 0) + 1);
        }
        int answer = 0;
        Map<Integer,Integer> codes = new HashMap<>();
        //순회하며 플러그 꽂기
        for(int i=0;i<k;i++){
            if(codes.size() < n){
                map.put(schedule[i], Math.min(map.getOrDefault(schedule[i], 0) - 1 ,0));
                codes.put(schedule[i],map.get(schedule[i]));
            }else{
                //이미 꽂혀있으면 패스
                if(!map.containsKey(schedule[i])){
                    //빼야하면 카운트 젤 낮은 걸 빼기
                    //미구현

                }
            }

        }

    }
}
