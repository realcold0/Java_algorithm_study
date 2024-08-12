import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();
    static char[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        checked = new boolean[c];
        result = new char[l];

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < c; i++){
            arr[i] = st2.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(l, c, 0, 0);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int l, int c,int start , int count) {
        if(count == l){
            if(isValid(l, result)){
                for(int i=0;i<l;i++){
                    sb.append(Character.toString(result[i]));
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i<c;i++){
            if(checked[i] == false){
                checked[i] = true;
                result[count] = arr[i];
                dfs(l,c, i + 1,count + 1);
                checked[i] = false;
            }
        }

    }
    public static boolean isValid(int l,char[] result){
        int conCount = 0;
        int vowelCount = 0;
        for(int i =0;i < l;i++) {
            if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u')
                vowelCount++;
            else conCount++;
        }
        if(vowelCount >= 1 && conCount >= 2) {
            return true;
        }else {
            return false;
        }
    }
}
