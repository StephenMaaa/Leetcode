package String;

/*
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

        In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

        The canonical path should have the following format:

        The path starts with a single slash '/'.
        Any two directories are separated by a single slash '/'.
        The path does not end with a trailing '/'.
        The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
        Return the simplified canonical path.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    // approach 1 - String TC: O(n) SC: O(n)
    public String simplifyPath(String path) {
        // maintain working directory
        Deque<String> queue = new ArrayDeque<>();
        int i = 0;
        while (i < path.length()) {
            // read all leading /
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }

            // read directory
            // case 1: current directory .
            // case 2: prev directory ..
            // case 3: otherwise
            if (i < path.length() && path.charAt(i) == '.' && (i + 1 == path.length() || path.charAt(i + 1) == '/')) {
                i += 2;
                continue;
            } else if (i + 1 < path.length() && path.substring(i, i + 2).equals("..") && (i + 2 == path.length() || path.charAt(i + 2) == '/')) {
                // pop
                if (!queue.isEmpty()) {
                    queue.pollFirst();
                }
                i += 3;
            } else {
                int count = i;
                while (i < path.length() && path.charAt(i) != '/') {
                    i++;
                }

                if (count != i) {
                    queue.offerFirst(path.substring(count, i));
                }
                i++;
            }
        }

        // process working directory
        StringBuilder sb = new StringBuilder("/");
        while (!queue.isEmpty()) {
            sb.append(queue.pollLast());
            sb.append("/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString(); 
    }

    public static void main(String[] args) {
        SimplifyPath test = new SimplifyPath();
        System.out.println(test.simplifyPath("/home//foo/.."));
    }
}
