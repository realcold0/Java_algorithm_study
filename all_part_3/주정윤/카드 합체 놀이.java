import java.io.*;
import java.util.*;

public class 카드 합체 놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //카드의 개수
        int m = Integer.parseInt(st.nextToken()); //카드 합체 횟수

        PriorityQueue<Long> pq = new PriorityQueue<>();

        //카드 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add((long) Integer.parseInt(st.nextToken()));
        }

        //m번 합체
        for (int i = 0; i < m; i++) {
            long a = pq.poll(); 
            long b = pq.poll(); 
            long sum = a + b;
            
            //카드 한장 아니고 두장 추가
            pq.add(sum);
            pq.add(sum); 
        }

        //남은 카드들의 합 계산
        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
        br.close();
    }
}
