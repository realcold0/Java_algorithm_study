package q1;

import java.io.*;
import java.util.*;


class dot{
    private int x;
    private int y;

    public dot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 점의 개수
        int N = Integer.parseInt(br.readLine());
        dot[] dots = new dot[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i] = new dot(x, y);
        }

        Arrays.sort(dots, new Comparator<dot>() {
            @Override
            public int compare(dot o1, dot o2) {
                if(o1.getY() != o2.getY()){
                    return o1.getY() - o2.getY();
                } else {
                    return o1.getX() - o2.getX();
                }
            }
        });

        for(int i = 0; i < N; i++){
            System.out.println(dots[i].getX() + " " + dots[i].getY());
        }
    }

}
