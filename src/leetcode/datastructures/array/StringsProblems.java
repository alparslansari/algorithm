package leetcode.datastructures.array;

public class StringsProblems {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    // Complexity = O(n^2)
    public static void example1() {
        String s = "";
        int n = 10000;
        for (int i = 0; i < n; i++) {
            s += "hello";
        }
        System.out.println(s);
    }

    // Complexity = O(n)
    //If you have to concatenate strings often, it will be better to use some other data structures like StringBuilder. The below code runs in O(n) complexity.
    public static void example2() {
        int n = 10000;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("hello");
        }
        String s = str.toString();
        System.out.println(s);
    }

    // If you did want your string to be mutable, you can convert it to a char array.
    public static void example3() {
        String s = "Hello World";
        char[] str = s.toCharArray();
        str[5] = ',';
        System.out.println(str);
    }
}
