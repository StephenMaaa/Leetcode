package BFS;

/*
LeetCode 433

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

        Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

        For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
        There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

        Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

        Note that the starting point is assumed to be valid, so it might not be included in the bank.
*/

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    // approach 1: BFS + Set TC: O(mn) SC: O(mn)
    public int minMutation(String startGene, String endGene, String[] bank) {
        // initialization
        Set<String> bankSet = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        char[] geneType = new char[]{'A', 'C', 'G', 'T'};

        for (String gene : bank) {
            bankSet.add(gene);
        }
        bankSet.remove(startGene);


        // BFS
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();

                // check
                if (gene.equals(endGene)) {
                    return count;
                }

                // expand
                StringBuilder sb = new StringBuilder(gene);
                for (int j = 0; j < gene.length(); j++) {
                    char original = sb.charAt(j);

                    // check char
                    for (char type : geneType) {
                        sb.setCharAt(j, type);
                        String nextGene = sb.toString();
                        // check bank
                        if (bankSet.contains(nextGene)) {
                            queue.offer(nextGene);
                            bankSet.remove(nextGene);
                        }
                        sb.setCharAt(j, original);
                    }
                }
            }

            // update
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation test = new MinimumGeneticMutation();
        String[] arr = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(test.minMutation("AACCGGTT", "AACCGCTA", arr));
    }
}
