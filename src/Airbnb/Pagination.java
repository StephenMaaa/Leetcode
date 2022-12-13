package Airbnb;

import java.util.*;

public class Pagination {
    public List<String> displayPages(List<String> input, int pageSize) {
        List<String> res = new ArrayList<>();

        // single page processing
        Set<String> page = new HashSet<>();
        int count = 0;
        Iterator<String> iterator = input.iterator();
        boolean backFill = false;
        while (iterator.hasNext()) {
            String data = iterator.next();
            String hostID = data.split(",")[0];

            // add
            // case 1: hostID not visited
            // case 2: backfill
            if (!page.contains(hostID) || backFill) {
                res.add(data);
                page.add(hostID);
                iterator.remove();
                count++;
            }

            // reset new page
            if (count == pageSize) {
                page.clear();
                count = 0;
                backFill = false;

                // check: separate pages
                if (!input.isEmpty()) {
                    res.add(" ");
                }
            }

            // start backfilling
            if (!iterator.hasNext()) {
                iterator = input.iterator();
                backFill = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Pagination test = new Pagination();

        //hostId, ListId, points, city
        List<String> input = new ArrayList<>();
        input.add("1,28,310.6,SF");
        input.add("1,5,204.1,SF");
        input.add("20,7,203.2,Oakland");
        input.add("6,8,202.2,SF");
        input.add("6,10,199.1,SF");
        input.add("1,16,190.4,SF");
        input.add("6,29,185.2,SF");
        input.add("7,20,180.1,SF");
        input.add("6,21,162.1,SF");
        input.add("2,18,161.2,SF");
        input.add("2,30,149.1,SF");
        input.add("3,76,146.2,SF");
        input.add("2,14,141.1,San Jose");

        List<String> res = test.displayPages(input, 5);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
