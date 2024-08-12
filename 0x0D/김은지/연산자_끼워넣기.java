import java.io.*;
import java.util.StringTokenizer;

// 최대값과 최소값을 저장할 클래스
class Result {
    int max;
    int min;
    Result(int max, int min) {
        this.max = max;
        this.min = min;
    }
}
class Solution{
    int n;
    int[] arr;
    int[] calc;
    int operate(int a, int b, int calc){
        switch(calc){
            case 0: return a+b;
            case 1: return a-b;
            case 2: return a*b;
            case 3: return a/b;
        }
        return 0;
    }
    Solution(int n, int[]arr,int[]calc){
        this.n = n;
        this.arr = arr;
        this.calc = calc;
    }
    Result solution(){
        Result result = dfs(1, arr[0], calc);
        return result;
    }

    // 재귀적으로 최대값과 최소값을 찾는 함수
    Result dfs(int index, int currentResult, int[] operators){
        if (index == n) return new Result(currentResult, currentResult);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int nextResult = operate(currentResult, arr[index], i);
                Result result = dfs(index + 1, nextResult, operators);
                max = Math.max(max, result.max);
                min = Math.min(min, result.min);
                operators[i]++;
            }
        }

        return new Result(max, min);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] calc = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }
        Solution sol = new Solution(n, arr, calc);
        Result rs = sol.solution();
        bw.write(rs.max + "\n");
        bw.write(rs.min + "\n");
        bw.flush();
        bw.close();
    }
}
