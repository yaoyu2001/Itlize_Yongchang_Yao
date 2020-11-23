package Strings;

public class BasicStrings {

    public String flipConcat(String string1, String string2) {

        return string2 + string1;
    }

    public char getChar(String string, int index) {

        return string.charAt(index);
    }

    public String iCantSee(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <string.length() ; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public String loudAndClear(String string) {
        if(string.length() == 0){
            return string;
        }
        else {
            return string.toUpperCase();
            }
        }

    public String reverseCase(String string) {
        if(string.length() == 0){
            return string;
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <string.length() ; i++) {
                if(Character.isUpperCase(string.charAt(i))){
                    sb.append(Character.toLowerCase(string.charAt(i)));
                }else {
                    sb.append(Character.toUpperCase(string.charAt(i)));
                }
            }
            return sb.toString();
        }
    }


    public String oneAtATime(String string1, String string2) {
        int len = Math.min(string1.length(), string2.length());
        int start = 0;
        StringBuilder sb = new StringBuilder();
        while (start < len){
            sb.append(string1.charAt(start));
            sb.append(string2.charAt(start));
            start++;
        }
        if (start < string1.length()){
            for (int i = start; i < string1.length() ; i++) {
                sb.append(string1.charAt(i));
            }
        }else {
            for (int i = start; i < string2.length() ; i++) {
                sb.append(string2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BasicStrings bs = new BasicStrings();
        String string1 = " Bunny";
        String string2 = "Bugs";
        System.out.println(bs.flipConcat(string1, string2));
        System.out.println(bs.iCantSee("Bugs") + "***");
        System.out.println(bs.loudAndClear("lEt mE hEaR yOu"));
        System.out.println(bs.reverseCase("I love Y'ALL!"));
        String string11 = "W abs oooooo";
        String string22 = "ed et";
        System.out.println(bs.oneAtATime(string11,string22));
        String string3 = "Chr 9.0";
        String string4 = "oot";
        System.out.println(bs.oneAtATime(string3, string4));
    }
}
