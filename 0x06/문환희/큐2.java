import java.io.*;
import java.util.*;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            String[] st = br.readLine().split(" ");

            String order = st[0];

            switch (order) {
                case "push":
                    queue.add(Integer.parseInt(st[1]));
                    break;
                case "pop" :
                    if(queue.isEmpty()){
                        sb.append("-1\n");
                    }
                    else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty" :
                    if(queue.isEmpty()){
                        sb.append("1\n");
                    }
                    else{
                        sb.append("0\n");
                    }
                    break;
                case "front" :
                    if(queue.isEmpty()){
                        sb.append("-1\n");
                    }else {
                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append("-1\n");
                    }else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }

        }


        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

