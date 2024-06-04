import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<String> list = new LinkedList<String>();
		String[] b = br.readLine().split("");
		
		for(String s : b) { // a b c d
			list.add(s);
		}
		
		int N = Integer.parseInt(br.readLine()); //3
		
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		
		while(N-- >0) {
			String command[] = br.readLine().split(" "); // P x
			String f_command = command[0];
			
			if(f_command.equals("P")) {
				iter.add(command[1]);
			} else if(f_command.equals("L")) {
				if(iter.hasPrevious()) iter.previous();
			} else if(f_command.equals("D")) {
				if(iter.hasNext()) iter.next();
			} else if(f_command.equals("B")) {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}
		
		System.out.println(String.join("", list));
	}
	
	

}


