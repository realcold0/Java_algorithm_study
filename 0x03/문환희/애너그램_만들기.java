import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 애너그램_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        char[] a = sc.nextLine().toCharArray();
        char[] b = sc.nextLine().toCharArray();
        int[] a1 = new int[26];
        int[] b1 = new int[26];

        for (char c1 : a) {
            a1[c1 - 'a']++;
        }
        for (char c2 : b) {
            b1[c2 - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            result += Math.abs(a1[i] - b1[i]);
        }


        System.out.println(result);
    }
}
