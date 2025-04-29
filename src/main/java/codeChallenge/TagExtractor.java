package codeChallenge;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtractor {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			String regex = "<(.+)>([^<]+)</\\1>";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(line);
			boolean found = false;
			while (matcher.find()){
				System.out.println(matcher.group(2));
				found = true;
			}
			if(!found){
				System.out.println("None");
			}
			testCases--;
		}
	}
}



