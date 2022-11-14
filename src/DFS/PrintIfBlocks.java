package DFS;

import java.util.ArrayList;
import java.util.List;

public class PrintIfBlocks {
    public void printIfBlocks(int n) {
        List<Integer> list = new ArrayList<>();
        dfs(n, 0, 0, list);
    }

    private void dfs(int n, int left, int right, List<Integer> list) {
        if (left == n && right == n) {
            print(list);
        }

        if (left < n) {
            list.add(0);
            dfs(n, left + 1, right, list);
            list.remove(list.size() - 1);
        }

        if (left > right) {
            list.add(1);
            dfs(n, left, right + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private void print(List<Integer> list) {
        int count = 0;
        String ifBlock = "if {";
        String endBlock = "}";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                for (int j = 0; j < count; j++) {
                    System.out.print("  ");
                }
                System.out.println(ifBlock);
                System.out.println("\n");
                count++;
            } else {
                count--;
                for (int j = 0; j < count; j++) {
                    System.out.print("  ");
                }
                System.out.println(endBlock);
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        PrintIfBlocks test = new PrintIfBlocks();
        test.printIfBlocks(2);
    }
}
