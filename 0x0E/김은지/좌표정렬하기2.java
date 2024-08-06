import java.util.*;
import java.io.*;

class MyMap implements Comparable<MyMap>{
    int x;
    int y;

    MyMap(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(MyMap o){
        int firstSort = y - o.y;
        if(firstSort !=0) return firstSort;
        return x-o.x;
    }

    @Override
    public String toString(){
        return x +" " +y;
    }

}

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        MyMap[] maps = new MyMap[n];
        for(int i =0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            maps[i] = new MyMap(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(maps);
        for(MyMap m : maps){
            bw.write(m.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();


    }
}