package Strings;

import java.util.*;

public class Strings {

    public static void printLetters(String str) {

        for (int i = 0; i < str.length(); i++) {

            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;

    }

    public static float getShortestPath(String path) {
        int x = 0, y = 0;

        for (int i = 0; i < path.length(); i++) {

            if (path.charAt(i) == 'N') {
                y++;

            } else if (path.charAt(i) == 'S') {
                y--;

            } else if (path.charAt(i) == 'W') {
                x--;

            } else {
                x++;

            }
        }
        int X2 = x * x;
        int Y2 = y * y;

        return (float) Math.sqrt(X2 + Y2);
    }

    public static String toUpperCase(String str) {

        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));

        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));

            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compressString(String str) {

        StringBuilder newStr = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {

            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {

                count++;
                i++;
            }

            newStr.append(str.charAt(i));
            if (count > 1) {
                newStr.append(count.toString());
            }

        }
        return newStr.toString();

    }

    public static void main(String[] args) { // String Is IMMUTABLE

        String str = "aaabbbbbbccccccc ";
        System.out.println(compressString(str));

        // StringBuilder us used to modify the string again and again whitout repeting
        // or copying the last/previous string
        // It is not an string but we can convert it into string by .toString function

        // StringBuilder sb = new StringBuilder("");

        // for(char ch = 'a'; ch<='z';ch++){
        // sb.append(ch);
        // }
        // System.out.println(sb.length());///////////////////

        // String fruit[] = { "apple", "mangO", "banana"
        // ,"MUSKMELON","Beery","LICHEE","strawberry"};
        // String largest = fruit[0];
        // for (int i = 0; i < fruit.length; i++) {
        // if (largest.compareToIgnoreCase(fruit[i]) < 0) {
        // largest = fruit[i];
        // }

        // }
        // System.out.println(largest);//////////////////

        // String path = "WNEENESENNN";

        // System.out.println(getShortestPath(path));/////////

        // String str = "racecar";
        // System.out.println(isPalindrome(str));///////////

        // String str2 = new String("abrar");
        // System.out.println(str2);

        // Scanner sc = new Scanner(System.in);
        // String name;
        // name = sc.next();
        // System.out.println(name);
        // System.out.println(name.length());

        // String firstname = "Mohd";

        // String Middlename = "Abrar";
        // String fullname = firstname + " " + Middlename;
        // System.out.println(fullname.charAt(5));
        // printLetters(fullname);////////////////////////

    }

}
