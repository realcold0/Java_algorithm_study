import java.io.*;
import java.util.*;

public class N과M5 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    //길이가 m인 부분수열을 구하는 백트래킹 함수
    public static void backtrack(List<Integer>arr, boolean[] visited,ArrayList<Integer> curr, int m){
        //base case
        if(curr.size() == m){
            for(int c : curr){
                sb.append(c).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < arr.size(); i++){
            if(visited[i]) continue;
            curr.add(arr.get(i));
            visited[i] = true;
            backtrack(arr,visited, curr, m);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        // 다음 줄
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr.add(i,Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        boolean[] visited = new boolean[n];

        backtrack(arr,visited,new  ArrayList<>(),m);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

