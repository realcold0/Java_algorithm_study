import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        class Person {
            int age;
            String name;
            int index;

            public Person(int age, String name, int index) {
                this.age = age;
                this.name = name;
                this.index = index;
            }


        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age < o2.age) {
                    return -1;
                } else if (o1.age == o2.age) {
                    return o1.index - o2.index;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            sb.append(persons[i].age).append(" ").append(persons[i].name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
