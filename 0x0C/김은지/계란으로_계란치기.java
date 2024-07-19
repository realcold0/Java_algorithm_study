import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class egg{
    int hp;
    int w;
    egg(int hp, int w){
        this.hp = hp;
        this.w = w;
    }
}


public class 계란으로_계란치기 {
    static ArrayList<Integer> answers=new ArrayList<>();
    static int ans = -3;
    public static void breakEgg(ArrayList<egg> eggs,int start){
        if(start == eggs.size()){
            int count = 0;
            for(egg egg: eggs){
                if(egg.hp <=0){
                    count ++;
                }
            }
            ans = Math.max(ans, count);
            return;
        }
        
        //1. 계란 들기
        egg pickEgg = eggs.get(start);
        //이미 깨져있으면 다음거 집기
        if(pickEgg.hp <=0){
            breakEgg(eggs,start+1);
            return;
        }
        boolean islast = true;
        //2. 다른 계란 하나 치기(여기서 여러 경우로 나뉨
        for(int i=0;i<eggs.size();i++){
            egg otherEgg = eggs.get(i);
            if(i == start || otherEgg.hp <=0){ continue;}
            // 현재 계란과 다른 계란이 모두 깨지지 않았을 때에만 처리
            islast = false;
            pickEgg.hp -= otherEgg.w;
            otherEgg.hp -= pickEgg.w;

            //3. 다른 계란 들기
            breakEgg(eggs,start+1);
            pickEgg.hp += otherEgg.w;
            otherEgg.hp += pickEgg.w;

        }
        if(islast){
            breakEgg(eggs,start+1);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<egg> eggs = new ArrayList<egg>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
           eggs.add(new egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        breakEgg(eggs,0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
