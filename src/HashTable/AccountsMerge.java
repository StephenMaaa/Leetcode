package HashTable;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

        Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

        After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
*/

import java.util.*;

public class AccountsMerge {
    // approach 1: Map TC: O(mn) SC: O(mn)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set>> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);

            // check
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
                Set emails = new HashSet(account);
                emails.remove(name);
                map.get(name).add(emails);
            } else {
                List<Set> allAccounts = map.get(name);
                boolean flag = false;

                // merge
                for (Set emails : allAccounts) {
                    // check dup
                    for (String email : account) {
                        if (!flag && emails.contains(email)) {
                            emails.addAll(account);
                            emails.remove(name);
                            flag = true;
                        }
                    }
                }

                // add new account for the same name
                if (!flag) {
                    Set emails = new HashSet(account);
                    emails.remove(name);
                    map.get(name).add(emails);
                }
            }
        }

        // process
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            List<Set> account = map.get(key);
            for (Set emails : account) {
                List<String> merged = new ArrayList<>(emails);
                Collections.sort(merged);
                merged.add(0, key);
                res.add(merged);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AccountsMerge test = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> res = test.accountsMerge(accounts);
    }
}
