
import java.util.*;
import java.io.*;

public class 소문난 칠공주
{
    static String[][] table; // 5*5 정사각형 격자 형태의 자리
    static int N = 7; // 구성원이 7명 고정
    static int maxCount, studentCount, sCount = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        table = new String[5][5];

        // 5*5 응답 받기
        for(int i=0; i<5; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<5; j++){
                table[i][j] = arr[j];
            }
        }

         backtrack(0, 0, 0);


    }

    public static void backtrack(int x, int y, int count) {
        //Scount가 따로 있어야 될듯
        if(count == N){
            maxCount = studentCount;
            return;
        }

        for(int i=x; i< 5; i++){
            for(int j=y; j<5; j++){
                if(table[x][y] == "S") sCount++;
            }
        }
    }
}
