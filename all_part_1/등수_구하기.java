import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Info> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n>0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pq.add(new Info(i,Integer.parseInt(st.nextToken())));
            }
        }
        pq.add(new Info(Integer.MAX_VALUE,newScore));
        int rank =0;
        int prevScore=0;
        int sameCnt =0;
        for(int i = 1;i<=p;i++) {
            if(pq.isEmpty()) {
                System.out.println(-1);
                return;
            }
            Info now = pq.poll();
            if(prevScore==now.score){
                sameCnt++;
            }else{
                rank += sameCnt +1;
                sameCnt=0;

            }
            if(now.score == newScore && now.id ==Integer.MAX_VALUE) {
                System.out.println(rank!=0 ? rank : 1);
                return;
            }
            prevScore=now.score;

        }
        System.out.println(-1);
    }
}

class Info implements Comparable<Info> {
    int id;
    int score;

    public Info(int id, int score) {
        this.id = id;
        this.score = score;
    }
    @Override
    public int compareTo(Info o) {
        int first= o.score - this.score;
        if(first==0) {
            return this.id - o.id;
        }
        return first;
    }
}