import java.util.*;
import java.io.*;

class 히스토그램에서_가장_큰_직사각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //7 2 1 4 5 1 3 3
            int N = Integer.parseInt(st.nextToken());
            if( N ==0) break;

            int[] arr = new int[N];
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //arr 값이 아니라, idx 저장
            Stack<Integer> stack = new Stack<>(); 
            long maxArea = -10000;
            for (int idx = 0; idx < N; idx++){
                while(!stack.isEmpty() && arr[stack.peek()] > arr[idx]){
                    int height = stack.pop();
                    int width = stack.isEmpty() ? idx : idx - 1 - stack.peek(); //전체 넒이에서 작은 부분의 넓이 width 뺌
                    maxArea = Math.max(maxArea,(long)width*arr[height]);
                }
                stack.add(idx);
            }    
            while(!stack.isEmpty()){
                int height = stack.pop();
                int width = stack.isEmpty() ? N : N - 1 - stack.peek(); //전체 넒이에서 작은 부분의 넓이 width 뺌    
                maxArea = Math.max(maxArea,(long)width*arr[height]);
            }
            sb.append(maxArea + "\n");
            
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}