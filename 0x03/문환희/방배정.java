import java.util.Arrays;
import java.util.Scanner;

public class 방배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int[] NK = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] students = new int[7][2];
        for(int i = 0; i < NK[0]; i++) {
            int[] tmp = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            students[tmp[1]][tmp[0]]++;
        }
//        for(int i = 1; i < 7; i++) {
//            System.out.println(students[i][0] + " " + students[i][1]);
//        }
        for(int i = 1; i < 7; i++) {
            for(int j = 0; j < 2; j++) {
                int num = students[i][j];
                if (num % NK[1] == 0) {
                    result += (int) num / NK[1];
                }
                else {
                    result += (int) num / NK[1] + 1;
                }
            }
        }
        System.out.println(result);

    }
}
