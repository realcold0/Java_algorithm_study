
import java.io.*;
import java.util.*;

public class N과M1 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    //길이가 m인 부분수열을 구하는 백트래킹 함수
    public static void backtrack(int[]arr, boolean[] visited,ArrayList<Integer> curr, int m){
        //base case
        if(curr.size() == m){
            for(int c : curr){
                sb.append(c).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;
            curr.add(arr[i]);
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
        int[]arr = new int[n];
        boolean[] visited = new boolean[n];
        //arr만들기
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }

        backtrack(arr,visited,new  ArrayList<>(),m);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
