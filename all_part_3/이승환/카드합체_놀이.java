import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
         * 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
         * 이 카드 합체를 총 m번 하면 놀이가 끝난다. m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다. 이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i =0;i<n ;i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        //작은 수 두개 꺼내서 합치고 넣기
        for(int i =0;i<m ;i++){
            long a = pq.remove();
            long b = pq.remove();
            long sum = a+b;
            pq.add(sum);
            pq.add(sum);
        }

        long sum = 0;

        for(int i =0; i < n ;i++){
            sum += pq.remove();
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();
    }


}
