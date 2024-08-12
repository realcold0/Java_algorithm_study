import java.io.*;
import java.util.*;


class judge{
    private String name;
    private int age;

    public judge(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개
        int N = Integer.parseInt(br.readLine());
        judge[] judges = new judge[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            judges[i] = new judge(name, age);
        }

        Arrays.sort(judges, Comparator.comparingInt(judge -> judge.getAge()));
        for(int i = 0; i < N; i++){
            System.out.println(judges[i].getAge() + " " + judges[i].getName());
        }

        br.close();
    }

}
