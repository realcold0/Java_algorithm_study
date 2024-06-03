import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] wordCount = new int[26];

        // 알파벳 배열 생성
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        // 사용자로부터 word 단어를 입력받음
        String word = sc.next();

        for(int i=0; i<word.length(); i++) {
            for(int j=0; j<26; j++) {
                if(word.charAt(i)==alphabet[j]) {
                    wordCount[j]++;
                }
            }
        }

        for(int i : wordCount) {
            System.out.print(i + " ");
        }

    }
}