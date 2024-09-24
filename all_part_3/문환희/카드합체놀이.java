import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            long p = pq.poll();
            long q = pq.poll();
            for(int j = 0; j < 2; j++) {
                pq.add(p + q);
            }
        }

        long answer = 0;
        for(long i : pq) {
            answer += i;
        }


        System.out.println(answer);
    }
}
