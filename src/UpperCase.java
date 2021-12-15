public class UpperCase {

    public static boolean isUpperCase(String s) {
        return s.chars().allMatch(Character::isUpperCase);
    }

    public static boolean isLowerCase(String s) {
        //return s.chars().noneMatch(Character::isUpperCase);
        return s.chars().allMatch(Character::isLowerCase);
    }

    public static void main(String[] args) {
        System.out.println(isUpperCase("hello"));
        System.out.println(isUpperCase("HELLO"));

        System.out.println(isLowerCase("hello"));
        System.out.println(isLowerCase("HELLO"));
    }
}
