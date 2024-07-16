import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arrS;
    static int[] arrW;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 가장 왼쪽 계란을 들고
         * 다른 계란을 친다. 계란이 깨졌거나 깨지지 않은것이 없다면 넘어간다.
         */
        int n = Integer.parseInt(br.readLine());
        arrS = new int[n];
        arrW = new int[n];
        for(int i= 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrS[i] = Integer.parseInt(st.nextToken());
            arrW[i] = Integer.parseInt(st.nextToken());
        }

        dfs(n, 0,0);
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n ,int current, int count){
        //끝가지 갔다면
        if(n == current || count == n -1){
            if(max < count){
                max = count;
            }
            return;
        }

        if(arrS[current] <= 0 ){
            dfs(n, current + 1, count);
            return;
        }
        //현개 왼손에 든 계란을 다른 계란들에 칠수 있다.
        //근데 자기자신을 치진 않는다.
        for(int i = 0; i < n;i++){
            if(i == current){
                continue;
            }
            //깰수 있는 것들을
            if(arrS[i] > 0){
                int tmp =0;
                arrS[i] = arrS[i] - arrW[current];
                arrS[current] = arrS[current] - arrW[i];
                if(arrS[current] <= 0 ){
                    tmp++;
                }
                if(arrS[i] <=0){//다음것이 깨짐
                    tmp++;
                }

                //다음으로 가는데
                //만약 깬 계란이
                dfs(n, current + 1, count + tmp);
                arrS[i] = arrS[i] + arrW[current];
                arrS[current] = arrS[current] + arrW[i];
            }
            else{
                dfs(n, current + 1, count);
            }

        }

    }
}
