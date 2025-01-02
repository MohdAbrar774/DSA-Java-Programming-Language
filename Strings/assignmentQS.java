package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class assignmentQS {
    // LS = LowerCase
    public static void countLSVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                count++;
            }
        }
        System.out.println("The Lowercase Vowels " + count);

    }

    public static void getBiggestSubString(String str){
                
       
    
            int tp = 0;
            for (int i = 0; i < str.length(); i++) {
        
              
              StringBuilder curr = new StringBuilder("");
               curr.append(str.charAt(i));
              for (int j = i + 1; j < str.length(); j++) {
              String subString = new String(curr.append(str.charAt(j)));
                
                while(subString.charAt(i) != subString.charAt(j)){
                System.out.print("("+ subString+")");
                j++;
                  tp++;

                }  

              
        
              }
              System.err.println();
            }
            System.err.println("Total pairs =" + tp);
        
        


    }

    public static void main(String[] args) {

        String str1 = "aabbccdehhjgadeg";
           getBiggestSubString(str1);
        // String str2 = "radhash";
        // // First convert it into lowercase. Why? So, We don't need to check for
        // // lowercase and uppercase separetly
        // str1 = str1.toLowerCase();
        // str2 = str2.toLowerCase();

        // // Check the length of both strings
        // if (str1.length() == str2.length()) {

        //     // Convert String into char Array
        //     char[] str1tocharArray = str1.toCharArray();
        //     char[] str2tocharArray = str2.toCharArray();

        //     // Sort the char Array
        //     Arrays.sort(str1tocharArray);
        //     Arrays.sort(str2tocharArray);
        //       boolean result = Arrays.equals(str1tocharArray ,str2tocharArray  );
        //     if (result  == true) {
        //         System.out.println(str1 + " " + " and " + " " + str2 + " are  an Anagram to eachother");
        //     } else {
        //         System.out.println(str1 + " " + " and " + " " + str2 + " are not  an Anagram to eachother");
        //     }

        // } else {
        //     System.out.println(str1 + " " + " and " + " " + str2 + " are not  an Anagram to eachother");
        // }///////////////////////////////////////////////

        // String str = "ShradhaDidi".replace("Didi","Bhabhi");
        // String str1 = "ApnaCollege";
        // String str2 = "ShradhaDidi";
        // System.out.println(str1.equals(str1) + " " + str1.equals(str2));
        // System.out.println(str);////////////////////////////////////////

        // Scanner sc = new Scanner(System.in);
        // System.err.println("Enter Your String");
        // String str;
        // str = sc.next();
        // countLSVowels(str);
    }

}
