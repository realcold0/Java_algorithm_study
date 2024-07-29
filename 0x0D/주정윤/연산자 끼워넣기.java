import java.util.*;
import java.io.*;

public class 연산자 끼워넣기 {
    static int N;
    static int[] A;
    static int[] op = new int[4]; //덧셈, 뺄셈, 나눗셈, 곱셈
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 수의 개수 N
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        //a1, a2, ... an
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);

        bw.write(MAX + "\n");
        bw.write(MIN + "\n");
        bw.flush();
        br.close();
        bw.close();

    }

    public static void dfs(int result, int index){
        //전체 완료 시
        if(index == N){
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--;
                switch (i){
                    case 0:
                        dfs(result + A[index], index+1);
                        break;
                    case 1:
                        dfs(result - A[index], index+1);
                        break;
                    case 2:
                        dfs(result * A[index], index+1);
                        break;
                    case 3:
                        if(result < 0){
                            // result값이 0보다 작을때
                            dfs(-1 * (Math.abs(result) / A[index]), index+1);
                        } else {
                            dfs(result / A[index], index+1);
                        }
                        break;

                }
                op[i]++;
            }
        }
    }

}
