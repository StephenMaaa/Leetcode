package Graph;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.

        Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
*/

import java.util.*;

public class WordSearchII {
    TrieNode root = new TrieNode();

//    public class TrieNode {
//        Map<Character, TrieNode> edges = new HashMap<>();
//        boolean isWord;
//
//        public TrieNode() {
//            isWord = false;
//        }
//    }

//    // approach 1 - Trie + DFS TC: O(nL + RC3^L) SC: O(nL + RCL)
//    public List<String> findWords(char[][] board, String[] words) {
//        // build trie with words
//        for (String str : words) {
//            TrieNode curr = root;
//
//            // add str to trie
//            for (char c : str.toCharArray()) {
//                if (!curr.edges.containsKey(c)) {
//                    curr.edges.put(c, new TrieNode());
//                }
//                curr = curr.edges.get(c);
//            }
//            curr.isWord = true;
//        }
//
//        // check each starting entry on board
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        Set<String> set = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                // DFS
//                if (root.edges.containsKey(board[i][j])) {
//                    dfs(board, i, j, sb, visited, directions, root.edges.get(board[i][j]), set);
//                }
//            }
//        }
//        return new ArrayList<>(set);
//    }
//
//    private void dfs(char[][] board, int i, int j, StringBuilder sb, boolean[][] visited, int[][] directions, TrieNode root, Set<String> res) {
//        // base case
//        sb.append(board[i][j]);
//        visited[i][j] = true;
//
//        // check
//        if (root.isWord) {
//            res.add(sb.toString());
//        }
//
//        // recursive case
//        // expand
//        for (int[] dir : directions) {
//            int row = i + dir[0];
//            int col = j + dir[1];
//
//            // check
//            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && root.edges.containsKey(board[row][col]) && !visited[row][col]) {
//                dfs(board, row, col, sb, visited, directions, root.edges.get(board[row][col]), res);
//            }
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        visited[i][j] = false;

    public class TrieNode {
        Map<Character, TrieNode> edges = new HashMap<>();
        String word;

        public TrieNode() {
        }
    }

    // approach 1 - Trie + DFS TC: O(nL + RC3^L) SC: O(nL + RCL)
    public List<String> findWords(char[][] board, String[] words) {
        // build trie with words
        for (String str : words) {
            TrieNode curr = root;

            // add str to trie
            for (char c : str.toCharArray()) {
                if (!curr.edges.containsKey(c)) {
                    curr.edges.put(c, new TrieNode());
                }
                curr = curr.edges.get(c);
            }
            curr.word = str;
        }

        // check each starting entry on board
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // DFS
                if (root.edges.containsKey(board[i][j])) {
                    dfs(board, i, j, visited, directions, root, set);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, int[][] directions, TrieNode root, Set<String> res) {
        // base case
        TrieNode curr = root.edges.get(board[i][j]);
        visited[i][j] = true;

        // check
        if (curr.word != null) {
            res.add(curr.word);
        }

        // recursive case
        // expand
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];

            // check
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && curr.edges.containsKey(board[row][col]) && !visited[row][col]) {
                dfs(board, row, col, visited, directions, curr, res);
            }
        }
        visited[i][j] = false;

        // optimization
        if (curr.edges.isEmpty()) {
            root.edges.remove(board[i][j]);
        }
    }

    public static void main(String[] args) {
        WordSearchII test = new WordSearchII();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'},
                                      {'e', 't', 'a', 'e'},
                                      {'i', 'h', 'k', 'r'},
                                      {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(test.findWords(board, words));
    }
}
