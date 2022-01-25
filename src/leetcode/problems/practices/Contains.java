package leetcode.problems.practices;

public class Contains {

    public static void parseContents(String s) {
        System.out.println("Option 1");
        for (char c : s.toCharArray()) {
            System.out.println(c);
        }


        System.out.println("Option 2");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s.contains("ll"));
        parseContents(s);
    }
}
