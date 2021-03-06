package leetcode.problems.linkedin;

import java.util.ArrayList;
import java.util.List;

/** 68. Text Justification
 * Given an array of strings words and a width maxWidth, format the text such that each line
 * has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as
 * you can in each line. Pad extra spaces ' ' when necessary so that each line has
 * exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line does not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified and no extra space is
 * inserted between words.
 *
 * Note:
 *     A word is defined as a character sequence consisting of non-space characters only.
 *     Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 *     The input array words contains at least one word.
 *
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class _68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0; List<String> result = new ArrayList<>();

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");

        return padResult(result.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}

/* space ler - justified degil
Your input ["This", "is", "an", "example", "of", "text", "justification."] 16
Output   ["This is an","example of text","justification."]
Expected ["This    is    an","example  of text","justification.  "]
public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> solution = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int sblen = words[0].length();
        sb.append(words[0]);

        for(int i=1;i<words.length;i++)
        {
            if(sblen+words[i].length()+1 == maxWidth)
            {
                sb.append(" ");
                sb.append(words[i]);
                solution.add(sb.toString());
                sblen = 0;
                sb = new StringBuffer();
            } else if(sblen+words[i].length()+1 < maxWidth)
            {
                sb.append(" ");
                sb.append(words[i]);
                sblen += 1 + words[i].length();
            } else {
                solution.add(sb.toString());
                sblen = words[i].length();
                sb = new StringBuffer();
                sb.append(words[i]);
            }
        }
        if(sblen > 0) solution.add(sb.toString());

        return solution;
    }
 */