import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 방_번호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int[] arr = new int[10];
        int result = 0;
        for(char c : str) {
            int num = (int) c - 48;
                if(num == 9 || num == 6) {
                    if(arr[9] > arr[6]) {
                        arr[6]++;
                    }
                    else if(arr[9] < arr[6]){
                        arr[9]++;
                    }
                    else {
                        arr[num]++;
                    }
                }
                else{
                arr[num]++;
            }
        }
        for(int i : arr) {
            result = Math.max(i, result);
        }

        System.out.println(result);
    }
}
