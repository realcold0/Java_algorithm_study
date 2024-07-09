import java.io.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n * 2 - 1];

        recur(n, 0,0);

        for(int i =0;i<map.length;i++){
            for(int j= 0;j<map[i].length;j++){
                if(map[i][j] == 0){
                    map[i][j] = ' ';
                }
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void recur(int n, int x, int y){
        if(n == 3){
            map[x][y] = ' ';map[x][y + 1] = ' ';map[x][y + 2] = '*';map[x][y + 3] = ' ';map[x][y + 4] = ' ';
            map[x + 1][y] = ' ';map[x + 1][y + 1] = '*';map[x + 1][y + 2] = ' ';map[x+1][y + 3] = '*';map[x+1][y + 4] = ' ';
            map[x + 2][y] = '*';map[x + 2][y + 1] = '*';map[x + 2][y + 2] = '*';map[x+2][y + 3] = '*';map[x+2][y + 4] = '*';
            return;
        }
        int next = n /2;
        int width = n * 2 - 1; // 47
        int middleWidth = width/2 + 1;
        recur(next, x, y + width /4 + 1 ); //위
        recur(next, x + next, y ); //왼쪽밑
        recur(next , x + next, y + middleWidth);

    }
}