import java.io.*;
import java.util.*;


public class Main {
    static char[][] map;
    static boolean[][] checked;
    static int answer = 0;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[5][5];
        checked =new boolean[5][5];
        int[] result = new int[7];
        for(int i = 0; i < 5; i++){
            map[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, 0, 0 , result);
        bw.write(answer+"");


        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int count, int start, int sCount, int ycount, int[] result){
        if(ycount >= 4){
            return;
        }
        if(count == 7){
            if(sCount >=4){
                if(isLinked(result)) answer++;
            }
            return;
        }
        for(int i = start; i< 25; i++){
            result[count] = i;
            //만약 S라면 S카운트를 증가시키고
            if(map[i/5][i%5] == 'S'){
                dfs(count + 1, i + 1, sCount + 1, ycount , result);
            }
            //Y라면 Y 카운트를 증가
            else {
                dfs(count + 1, i + 1, sCount , ycount + 1 , result);
            }
        }

    }
    public static boolean isLinked(int[] result){
        Queue<Integer> queue = new LinkedList<>();
        //방문할곳 찾기 위해
        HashSet<Integer> hash = new HashSet<>();
        for(int i : result){
            hash.add(i);
        }
        queue.add(result[0]); //시작지점

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0 , 1, -1};


        while(!queue.isEmpty()){
            int current = queue.poll();
            int currentX = current/5;
            int currentY = current%5;
            //상하 좌우 확인
            for(int i = 0; i < 4;i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5 && hash.contains(nextX * 5 + nextY)){
                    hash.remove(nextX * 5 + nextY);
                    queue.add(nextX * 5 + nextY);
                }
            }
        }
        if(hash.size() == 0){
            return true;
        }
        else{
            return false;
        }


    }

}