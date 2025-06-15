class diffrence{
    public static int minMaxDifference(int num) {


        String str = Integer.toString(num);
        String str2 = str;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != '9'){
              String st = String.valueOf(str.charAt(i));
              str = str.replaceAll(st,"9");
              break;
            }
        }
            String st2 = String.valueOf(str2.charAt(0));
            str2 = str2.replaceAll(st2,"0");


            return Integer.parseInt(str) - Integer.parseInt(str2);

        
    }
    public static void main(String[] args) {
        int num = 11891;

       System.out.println( minMaxDifference(num));
    }
}