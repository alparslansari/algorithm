package leetcode.datastructures.array;

public class IntroToString {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example3() {
        String s1 = "Hello World";
        // 1. concatenate
        s1 += "!";
        System.out.println(s1);
        // 2. find
        System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s1.substring(6, 11));
    }
    public static void example2() {
        String s1 = "Hello World";
        //s1[5] = ','; // not possible
        System.out.println(s1);
    }

    public static void example1() {
        // Initialize a String
        String s1 = "Hello World";
        System.out.println("s1 is \""+s1+"\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // Compare Strings using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": "+ (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object.
        System.out.println("s1 and s2: "+(s1==s2));
        // false since s3 is referred to another new object
        System.out.println("s1 and s3: "+(s1==s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals'");
        System.out.println("s1 and \"Hello World\": "+ s1.equals("Hello World"));
        System.out.println("s1 and s2: "+s1.equals(s2));
        System.out.println("s1 and s3: "+s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo'");
        System.out.println("s1 and \"Hello World\": "+(s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2)==0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3)==0));

    }

}
