package DFS;

/*
Given an array of strings, find if the strings can be concatenated to form a ring. The two strings s1 and s2 can be concatenated iff the the last char of s1 is identical to the first char of s2. The first char of the first string in the array must be identical to the last char of the last string. The ring must contain every string in the input once and only once.

        Assumptions:

        The given array is not null or empty.
        None of the strings in the array is null or empty.
        Examples:

        input = {"aaa", "bbb", "baa", "aab"}, return true since it can be re-arranged to {"aaa", "aab", "bbb"  and "baa"}
        input = {"aaa", "bbb"}, return false
*/

import java.util.*;

public class FormARingWithWords {
//    // time complexity: O(n!)
//    // space complexity: O(n)
//    public boolean formRing(String[] input) {
//        boolean[] status = new boolean[1];
//        dfs(input, 0, status);
//        return status[0];
//    }
//
//    private void dfs(String[] input, int index, boolean[] status) {
//        // base case
//        if (status[0]) {
//            return;
//        }
//
//        if (index == input.length) {
//            status[0] = true;
//            return;
//        }
//
//        // recursive case
//        for (int i = index; i < input.length; i++) {
//            swap(input, i, index);
//            if (check(input, i) && check(input, index)) {
//                dfs(input, index + 1, status);
//            }
//            swap(input, i, index);
//        }
//    }
//
//    private boolean check(String[] input, int i) {
//        char pre = 0;
//        char post = 0;
//
//        // check pre
//        if (i == 0) {
//            pre = input[input.length - 1].charAt(input[input.length - 1].length() - 1);
//        } else {
//            pre = input[i - 1].charAt(input[i - 1].length() - 1);
//        }
//
//        if (i == input.length - 1) {
//            post = input[0].charAt(0);
//        } else {
//            post = input[i + 1].charAt(0);
//        }
//
//        return pre == input[i].charAt(0) && post == input[i].charAt(input[i].length() - 1);
//    }
//
//    private void swap(String[] input, int i, int j) {
//        String temp = input[i];
//        input[i] = input[j];
//        input[j] = temp;
//    }

//    void dfs(int start, vector<int> adj[], vector<bool> &vis){
//        vis[start]=true;
//        for (auto it: adj[start]){
//            if (vis[it]==false){
//                dfs(it, adj, vis);
//            }
//        }
//    }
//    int isconnected(int s, int V, vector<int> adj[], vector<bool> &mark){
//        vector<bool> vis(26, false);
//        dfs(s, adj, vis);
//        for (int i=0; i<26; i++){
//            if (vis[i]==false && mark[i]==true){
//                return 0;
//            }
//        }
//        return 1;
//    }
//    int isCircle(int N, vector<string> A)
//    {
//        vector<bool> mark(26, false);
//        vector<int> adj[26];
//        vector<int> in(26, 0), out(26, 0);
//        for (auto s: A){
//            int u=s[0]-'a';
//            int v=s[s.size()-1]-'a';
//            mark[u]=mark[v]=true;
//            adj[u].push_back(v);
//            in[v]++;
//            out[u]++;
//        }
//        for (int i=0; i<26; i++){
//            if (in[i]!=out[i]){
//                return 0;
//            }
//        }
//        return isconnected(A[0].front()-'a', 26, adj, mark);
//    }

    // time complexity: O(n)
    // space complexity: O(n)
    public boolean formRing(String[] input) {
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            adjacentMap.put(i, new ArrayList<>());
        }
        boolean[] mark = new boolean[26];
        int[] indegrees = new int[26];
        int[] outdegrees = new int[26];
        for (String str : input) {
            int pre = str.charAt(0) - 'a';
            int post = str.charAt(str.length() - 1) - 'a';
            adjacentMap.get(pre).add(post);
            mark[pre] = true;
            mark[post] = true;
            indegrees[post]++;
            outdegrees[pre]++;
        }

        // check
        for (int i = 0; i < 26; i++) {
            if (indegrees[i] != outdegrees[i]) {
                return false;
            }
        }

        return isSC(input[0].charAt(0) - 'a', adjacentMap, mark);
    }

    private boolean isSC(int start, Map<Integer, List<Integer>> adjacentMap, boolean[] mark) {
        boolean[] visited = new boolean[26];
        dfs(start, adjacentMap, visited);

        for (int i = 0; i < 26; i++) {
            if (!visited[i] && mark[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int start, Map<Integer, List<Integer>> adjacentMap, boolean[] visited) {
        visited[start] = true;
        List<Integer> outdegrees = adjacentMap.get(start);
        for (int i : outdegrees) {
            if (!visited[i]) {
                dfs(i, adjacentMap, visited);
            }
        }
    }

    public static void main(String[] args) {
        FormARingWithWords test = new FormARingWithWords();
        String[] arr = new String[] {"aab", "cca", "bac", "bab"};
        System.out.println(test.formRing(arr)); 
    }
}
