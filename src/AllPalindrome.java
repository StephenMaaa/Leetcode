import java.util.ArrayList;
import java.util.List;

public class AllPalindrome {
    public List<List<String>> allPalindrome(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int index, List<String> list, List<List<String>> res) {
        // base case
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        for (int i = index + 1; i <= s.length(); i++) {
            // check
            if (isPalindrome(s, index, i - 1)) {
                list.add(s.substring(index, i));
                dfs(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        AllPalindrome test = new AllPalindrome();
        System.out.println(test.allPalindrome("aab"));
    }
}
