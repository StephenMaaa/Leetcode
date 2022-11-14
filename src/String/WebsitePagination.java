package String;

import java.util.*;

public class WebsitePagination {
    public String[] websitePagination(String[][] items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // sort
//        Arrays.sort(items, (a, b) -> a[sortParameter].compareTo(b[sortParameter]));
        Arrays.sort(items, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[sortParameter].compareTo(o2[sortParameter]);
            }
        });

        // descending
        if (sortOrder == 1) {
            reverse(items);
        }

        // process
        List<String> res = new ArrayList<>();
        int index = pageNumber * itemsPerPage;
        int count = 0;
        while (count < itemsPerPage && index < items.length) {
            res.add(items[index][0]);
            count++;
            index++;
        }
        return res.toArray(new String[res.size()]);
    }

    private void reverse(String[][] items) {
        int left = 0;
        int right = items.length - 1;
        while (left < right) {
            String[] temp = items[left];
            items[left] = items[right];
            items[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        WebsitePagination test = new WebsitePagination();
        String[][] items = new String[][]{{"p1", "1", "2"}, {"p2", "2", "1"}, {"p3", "3", "3"}};
        System.out.println(Arrays.toString(test.websitePagination(items, 0, 0, 2, 0)));
    }
}
