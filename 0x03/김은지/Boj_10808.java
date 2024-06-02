import java.io.*;

public class Boj_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        char arr[] = new char[len];
        arr = s.toCharArray();

        //배열 문제
        //Java는 기본적으로 배열 0으로 초기화
        int eng[] = new int[26];
        for (int i = 0; i < s.length(); i++){
            int idx = arr[i] - 'a';
            eng[idx] +=1;
        }
        for (int j = 0; j < eng.length; j++){
            System.out.print(eng[j]);
            System.out.print(' ');
        }

    }
}
