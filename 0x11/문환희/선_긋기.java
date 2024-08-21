import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class edge implements Comparable<edge> {
    int start;
    int end;

    @Override
    public int compareTo(edge o) {
        if(this.start == o.start){
            return this.end - o.end;
        }
        return this.start - o.start;
    }

    public int length() {
        return end - start;
    }

    public edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class 선_긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<edge> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new edge(start, end));
        }

        edge now = pq.poll();
        int answer = now.length();

        while(!pq.isEmpty()) {
            edge e = pq.poll();
            if(e.start < now.end) {
                if(e.end >= now.end) {
                    answer += (e.end - now.end);
                    now = e;
                }
            }
            else {
                answer += e.length();
                now = e;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
