import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐2 {
    //Boj 18258
    public static void main(String[] args) throws IOException {
        Deque<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            switch (comm){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.add(num);
                    break;
                case "pop":
                    if(q.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(q.poll()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if(q.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(q.peek()).append('\n');
                    }
                    break;
                case "back":
                    if(q.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(q.peekLast()).append('\n');
                    }
                    break;

            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();

    }
}
