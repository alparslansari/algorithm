public class NormalizeString {

    public static String normalizeString(String s) {
        //String lowerCased = s.toLowerCase();
        //String trimmed = lowerCased.trim();
        //String normalized = trimmed.replace(",","");
        return s.toLowerCase().trim().replace(",", "");
    }

    public static void main(String[] args) {
        System.out.println(normalizeString("     Hello There, BUDDY "));
    }
}
