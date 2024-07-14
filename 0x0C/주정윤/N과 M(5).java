
import java.util.*;
import java.io.*;

public class N과 M(5)
{
    static int N, M;
    static int[] arr, output;
    static boolean[] visited;
    static int count;
    static StringBuilder sb = new StringBuilder()
;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N개의 자연수 길이 M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());;

        arr = new int[N];
        visited = new boolean[N];
        output = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 미리 오름차순 정렬한다
        Arrays.sort(arr);
        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int depth) {
        // N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인
        // 수열을 모두 구하는 프로그램을 작성하라
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }


    }
}