package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingSpecificCharacters {    

    public static void main(String[] args) {
        
        Regex_Test tester = new Regex_Test();
        tester.checker("^(?=.{6}$)[123][120][xs0][30aA][xsu][\\.,]"); // Use \\ instead of using \ 
    
    }
}

class Regex_Test {

    public void checker(String Regex_Pattern){
    
        Scanner input = new Scanner(System.in);
        String Test_String = input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
        input.close();
    }   
    
}