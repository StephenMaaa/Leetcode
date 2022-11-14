package BinarySearch;

public class ServerSelection {
    public int serverSelection(int[][] vulnerability) {
        int n = vulnerability.length;
        int m = vulnerability[0].length;

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                right = Math.max(right, vulnerability[i][j]);
            }
        }

        // binary search
        int res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;

            int[] rowCount = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (vulnerability[i][j] >= mid) {
                        rowCount[j]++;
                    }
                }
            }

            // check
            boolean flag = true;
            boolean flag2 = false;
            for (int i = 0; i < m; i++) {
                if (rowCount[i] == 0) {
                    flag = false;
                    break;
                }
                if (rowCount[i] > 1) {
                    flag2 = true;
                }
            }

            if (flag && flag2) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ServerSelection test = new ServerSelection();
        int[][] vulnerability = new int[][]{{1, 3, 1}, {3, 1, 1}, {1, 2, 2}, {1, 1, 3}};
        System.out.println(test.serverSelection(vulnerability));
    }
}
