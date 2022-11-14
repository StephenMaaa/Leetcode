package DFS;

/*
Given a string containing only digits, restore it by retiring all possible valid IP address combinations.

        Input:  ”25525511135”

        Output: [“255.255.11.135”, “255.255.111.35”]
*/

import java.util.*;

public class RestoreIPAddress {
    public List<String> Restore(String ip) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(ip, sb, 0, 0, set);
        return new ArrayList<>(set);
    }

    private void dfs(String ip, StringBuilder sb, int index, int level, Set<String> set) {
        // base case
        if (level == 4) {
            if (index == ip.length()) {
                set.add(sb.toString());
            }
            return;
        }

        if (index >= ip.length()) {
            return;
        }

        String num = "";
        for (int i = 0; i < 3; i++) {
            if (index + i < ip.length()) {
                num += ip.charAt(index + i);

                // invalid case: num > 255
                if (Integer.valueOf(num) > 255) {
                    continue;
                }

                // invalid case: 2 digits but starts with 0
                if (num.length() > 1 && num.charAt(0) == '0') {
                    continue;
                }

                sb.append(Integer.valueOf(num));
                if (level != 3) {
                    sb.append(".");
                }
                int length = num.length();
                dfs(ip, sb, index + i + 1, level + 1, set);
                if (level != 3) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                for (int j = 0; j < length; j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
//        String a = "";
//        a += "1";
//        a += "2";
//        System.out.println(a);
        RestoreIPAddress test = new RestoreIPAddress();
        System.out.println(test.Restore("00000"));
    }
}
