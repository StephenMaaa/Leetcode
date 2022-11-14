package Array;

/*
Given an array of numbers in string type, sort them in a way that the concatenation of them yields the largest value. Return the largest number in string type.

        Assumptions:

        The given array is not null.
        Each of the strings in the array is not null and they are all numbers.
        Examples:

        {“54”, “546”, “648”, “88”}, the arrangement “8864854654” gives the largest value.
*/

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class FormLargestNumber {
    // approach 1 - Override Comparator TC: O(nlogn) SC: O(n)
    public String largestNumber(String[] input) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                int maxLen = Math.max(o1.length(), o2.length());
//                int num1 = (int) (Integer.valueOf(o1) * Math.pow(10, maxLen - o1.length()));
//                int num2 = (int) (Integer.valueOf(o2) * Math.pow(10, maxLen - o2.length()));
//
//                if (num1 == num2) {
//                    return o1.length() - o2.length();
//                } else {
//                    return num2 - num1;
//                }
                int num1 = Integer.valueOf(o1 + o2);
                int num2 = Integer.valueOf(o2 + o1);
                return num2 - num1;
            }
        });

        // sort
        for (int i = 0; i < input.length; i++) {
            pq.offer(input[i]);
        }

        StringBuilder sb = new StringBuilder();

        // edge case
        if (pq.isEmpty()) {
            return sb.toString();
        }

        if (pq.peek().equals("0")) {
            return "0";
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }

    // approach 2 - Improved TC: O(nlogn) SC: O(1)
    public String largestNumber2(String[] input) {
        // edge case
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = Integer.valueOf(o1 + o2);
                int num2 = Integer.valueOf(o2 + o1);
                return num2 - num1;
            }
        });

        StringBuilder sb = new StringBuilder();

        // edge case
        if (input.length == 0) {
            return sb.toString();
        }

        if (input[0].equals("0")) {
            return "0";
        }

        // sort
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
        }

        return sb.toString();
    }

    // approach 1 - Sort TC: O(nlogn) SC: O(n)
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }

        // sort
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
//                for (int i = 0; i < str1.length(); i++) {
//                    if (str1.charAt(i) == str2.charAt(i)) {
//                        continue;
//                    }
//                    return str2.charAt(i) - str1.charAt(i);
//                }
//                return 0;
                return str2.compareTo(str1);
            }
        });

        // edge case
        if (!list.isEmpty() && list.get(0).equals("0")) {
            return "0";
        }
        return String.join("", list);
    }

    public static void main(String[] args) {
        FormLargestNumber test = new FormLargestNumber();
//        String[] arr = new String[]{"10" , "2"};
        int[] arr = new int[]{0, 0};
        System.out.println(test.largestNumber(arr));
    }
}
