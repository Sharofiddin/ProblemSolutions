package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NegativeLookahead {    
    public static class Regex_Test {

	    public static void checker(String Regex_Pattern){
	    
	        Scanner input = new Scanner(System.in);
	        String Test_String = input.nextLine();
	        Pattern p = Pattern.compile(Regex_Pattern);
	        Matcher m = p.matcher(Test_String);
	        int Count = 0;
	        while(m.find()){
	            Count += 1;
	        }
	        System.out.format("Number of matches : %d",Count);
	        input.close();
	    }   
    public static void main(String[] args) {
         Regex_Test.checker("(.)(?!\\1)"); //Use '\\' instead of '\'.
    
    }
}


    
}