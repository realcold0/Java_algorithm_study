
import java.io.*;
import java.util.*;

public class 별찍기_11 {
    static char[][] map;

    public static ArrayList<String> recur(int n){
        if (n ==3){

            return new ArrayList<>(List.of(new String[]{"  *  ", " * * ", "*****"}));
        }
        ArrayList<String> list = new ArrayList<>();
        list = recur(n /2);
        int L = list.size();
        ArrayList<String >result = new ArrayList<>();

        for(int i=0;i<L;i++){
            result.add(" ".repeat(L) + list.get(i) + " ".repeat(L));
        }
        for(int i = 0; i < L; i++){
            result.add(list.get(i) + " "+ list.get(i));
        }


        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
//        for(int i = 0; i < N; i++){
//        Arrays.fill(map[i],' ');
//        }
        ArrayList<String> list = new ArrayList<>();
        list = recur(N);
        for (String star :list){
            System.out.println(star);
        }

    }

}
