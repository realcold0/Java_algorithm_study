import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) -1 ;
        List<Integer> list = new LinkedList<>();
        for(int i = 1 ; i <= n ;i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while(!list.isEmpty()){

            index = (index + k) % list.size();
            sb.append(list.remove(index));
            if(!list.isEmpty()){
                sb.append(", ");
            }


        }
        sb.append(">");
        bw.write(sb.toString());


        bw.flush();
        bw.close();
    }
}
