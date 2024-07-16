
import java.util.*;
import java.io.*;

public class 암호 만들기
{
    static int L, C;
    static char[] arr, output;
    static boolean[] visited;
    static int count;
    static StringBuilder sb = new StringBuilder()
;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //알파벳 개수 L, 문자의 종류 개수 C
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());;

        arr = new char[C];
        visited = new boolean[C];
        output = new char[L];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<C; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        // 미리 사전순으로 정렬한다
        Arrays.sort(arr);
        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int depth, int start) {
        if(depth == L){
            if(isValid()){
                sb.append(output).append("\n");
            }
            return;
        }

        for(int i=start; i<C; i++){
            output[depth] = arr[i];
            dfs(depth+1, i+1);
        }

    }

    public static boolean isValid() {
        // 최소 한 개의 모음과 최소 두 개의 자음을 포함하는지 검사
        int vowels = 0, consonants = 0;
        for(char a : output){
            if(isVowel(a)) vowels++;
            else consonants++;
        }

        return vowels >= 1 && consonants >= 2;
    }

    public static boolean isVowel(char c){
        // 모음인지 여부 체크
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}