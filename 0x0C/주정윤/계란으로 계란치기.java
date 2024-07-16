
import java.util.*;
import java.io.*;

public class 계란으로 계란치기
{
    static int N;
    static int[][] eggs; // 계란의 내구도와 무게
    static int maxBroken = 0;
;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //계란의 수 N
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);

        System.out.println(maxBroken);

    }

    public static void backtrack(int index) {
        // 모든 계란을 다 돌았으므로 현재 깨진 계란의 수를 계산하여
        // maxBroken 갱신
        if(index == N){
            int brokenCount = 0;
            for(int i=0; i<N; i++){
                if(eggs[i][0] <= 0) brokenCount++;
            }
            maxBroken = Math.max(maxBroken, brokenCount);
            return;
        }

        // 이미 계란이 깨진 상태이므로 다음 계란으로 넘어감
        if(eggs[index][0] <= 0){
            backtrack(index+1);
            return;
        }

        // 현재 계란으로 칠 수 있는 다른 계란이 없는 경우를 체크
        boolean allBroken = true;

        for(int i=0; i< N; i++){
            // 똑같지 않고 깨지지 않은 계란일 경우에만 부딪히기
            if(i != index && eggs[i][0] > 0){
                allBroken = false;
                eggs[index][0] -= eggs[i][1];
                eggs[i][0] -= eggs[index][1];
                backtrack(index + 1);
                // 계란 상태 복구
                eggs[index][0] += eggs[i][1];
                eggs[i][0] += eggs[index][1];
            }
        }

        // 칠 수 있는 계란이 없으므로 다음 계란으로 넘어감
       if(allBroken){
            backtrack(index+1);
        }

    }

}