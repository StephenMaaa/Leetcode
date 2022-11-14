package DFS;

import java.util.ArrayList;
import java.util.List;

public class DecodeString {
    public List<String> decodeString(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(str, sb, 0, res);
        return res;
    }

    private void dfs(String str, StringBuilder sb, int index, List<String> res) {
        // base case
        if (index == str.length()) {
            res.add(sb.toString());
        }

        String num = "";
        // read 2 digits
        for (int i = 0; i < 2; i++) {
            if (index + i < str.length()) {
                num += str.charAt(index + i);

                if (Integer.valueOf(num) > 26) {
                    continue;
                }
                if (Integer.valueOf(num) == 0 && num.charAt(0) == '0') {
                    continue;
                }

                sb.append((char)(Integer.valueOf(num) + 64));
                dfs(str, sb, index + i, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
