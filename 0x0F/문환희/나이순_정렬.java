import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class member{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class 나이순_정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        member[] arr = new member[n];
        for (int i = 0; i < n; i++) {
            member m = new member();
            String[] input = br.readLine().split(" ");
            m.setName(input[1]);
            m.setAge(Integer.parseInt(input[0]));
            arr[i] = m;
        }

//        Arrays.sort(arr, Comparator.comparingInt(member::getAge));

        Collections.sort(Arrays.asList(arr), Comparator.comparingInt(member::getAge));
        for(member m : arr) {
            bw.write(m.getAge() + " " + m.getName() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
