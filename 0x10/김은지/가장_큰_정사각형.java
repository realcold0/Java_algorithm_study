
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            char[] oneLine = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j+1] = oneLine[j] - '0'; // 1과 0을 정확히 나타내기 위해 '0'을 빼줍니다.
            }
        }
        int[][] d = new int[n+1][m+1];
        int ans = 0;

        //점화식
        //d[i][j] : (i,j)를 오른쪽 아래 꼭짓점으로 하는 정사각형을 만든다고 할 때 가장 긴 변의 길이
        //d[i][j] = min(d[i-1][j-1],d[i-1][j],d[i][j-1])+1
        for(int i =1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(arr[i][j] == 1){
                    d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j],d[i][j-1])) + 1;
                    ans = Math.max(ans, d[i][j]); // 최대 변 길이 갱신
                }
            }
        }

        System.out.println(ans * ans); // 넓이를 출력합니다.
    }
}
