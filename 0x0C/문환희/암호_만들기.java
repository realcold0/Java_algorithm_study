import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 암호_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static String[] arr;
    static Stack<Integer> stack = new Stack<>();
    static int[] ck;

    static boolean check(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int cnt_vowels = 0;
        int cnt_consonants = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : vowels) {
            set.add(ch);
        }

        for(char cs : s.toCharArray()) {
            if(set.contains(cs)) {
                cnt_vowels++;
            }
            else {
                cnt_consonants++;
            }
        }
        return cnt_vowels >= 1 && cnt_consonants >= 2;
    }

    static void dfs(int l, int start) throws IOException {
        if(l == L) {
            StringBuilder sb = new StringBuilder();
            for(int i : stack) {
                sb.append(arr[i]);
            }
            if(check(sb.toString())) {
                sb.append("\n");
                bw.write(sb.toString());
            }
        }
        else {
            for(int i = start; i < C; i++) {
                if(ck[i] == 0) {
                    ck[i] = 1;
                    stack.push(i);
                    dfs(l + 1, i + 1);
                    ck[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        L = input[0];
        C = input[1];
        ck = new int[C];
        arr = br.readLine().split(" ");

        Arrays.sort(arr);

        dfs(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}
