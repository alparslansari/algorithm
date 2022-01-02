package leetcode.problems;

/** 557. Reverse Words in a String III
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 * Constraints:
 *     1 <= s.length <= 5 * 104
 *     s contains printable ASCII characters.
 *     s does not contain any leading or trailing spaces.
 *     There is at least one word in s.
 *     All the words in s are separated by a single space.
 */
public class _557ReverseWordsInAString {

    // More memory oriented
    public String reverseWords(String s) {
        String result="";
        String temp = "";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == ' ')
            {
                result += temp+" ";
                temp = "";
            } else {
                temp = s.charAt(i) + temp;
            }
        }
        result += temp;
        return result;
    }

    // prebuilt functions
    public String reverseWordsV2(String s) {
        String words[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word: words)
            sb.append(new StringBuffer(word).reverse().toString()+" ");
        return sb.toString().trim();
    }

    public String reverseWordsV3(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }

}
