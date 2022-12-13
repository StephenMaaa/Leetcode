package Airbnb;

/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

        You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

        Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

        For the last line of text, it should be left-justified, and no extra space is inserted between words.

        Note:

        A word is defined as a character sequence consisting of non-space characters only.
        Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
        The input array words contains at least one word.
*/

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    // approach 1 - String TC: O(mn) SC: O(mn)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            List<String> line = new ArrayList<>();
            int count = 0;

            // add one word
            line.add(words[i]);
            count += words[i].length();
            i++;

            // fill words until reaching maxWidth
            while (i < words.length && count + words[i].length() + 1 <= maxWidth) {
                line.add(words[i]);
                count += words[i].length() + 1;
                i++;
            }

            // case 1: last line
            // case 2: single word
            // case 3: normal case
            if (i == words.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(line.get(0));

                for (int j = 1; j < line.size(); j++) {
                    sb.append(" " + line.get(j));
                }

                // fill space
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                continue;
            }

            int wordCount = line.size();
            if (wordCount == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(line.get(0));

                // fill space
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                continue;
            }

            int wordWidth = count - (wordCount - 1);
            int spaceWidth = maxWidth - wordWidth;
            int averageSpaceWidth = spaceWidth / (wordCount - 1);
            String averageSpace = "";
            for (int j = 0; j < averageSpaceWidth; j++) {
                averageSpace += " ";
            }
            StringBuilder sb = new StringBuilder();
            int spaceSum = 0;
            for (int j = 0; j < line.size(); j++) {
                sb.append(line.get(j));

                // skip last word
                if (j == line.size() - 1) {
                    break;
                }
                sb.append(averageSpace);
                spaceSum += averageSpaceWidth;

                // check extra space
                if ((wordCount - 1 - (j + 1)) * averageSpaceWidth + spaceSum < spaceWidth) {
                    sb.append(" ");
                    spaceSum++;
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        TextJustification test = new TextJustification();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = test.fullJustify(words, 16);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
