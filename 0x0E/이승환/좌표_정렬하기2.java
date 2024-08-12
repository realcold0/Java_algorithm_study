import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        class Point {
            int x;
            int y;

            Point(int x, int y){
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString(){
                return new StringBuilder().append(x).append(' ').append(y).toString();
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        points.sort(new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y > o2.y){
                    return 1;
                }else if(o1.y < o2.y){
                    return -1;
                }else{
                    if(o1.x > o2.x){
                        return 1;
                    }else if(o1.x < o2.x){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < points.size(); i++){
            sb.append(points.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}