package No4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReducerOfIPFilter {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Set<String> st = new HashSet<String>();
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			st.add(line);
		}
		System.out.println(st.size());
	}
}