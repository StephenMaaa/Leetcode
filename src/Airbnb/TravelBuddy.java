package Airbnb;

import DP.BuyStock;

import java.util.*;

public class TravelBuddy {
    public class Buddy {
        String name; 
        Set<String> cities; 
        int sim;
        
        public Buddy(String name, Set<String> cities, int sim) {
            this.name = name; 
            this.cities = cities;
            this.sim = sim;
        }
    }

    // approach 1 - Set + Map TC: O(mn) SC: O(mk)
    public List<Buddy> getBuddyList(Set<String> list, Map<String, Set<String>> buddies) {
        List<Buddy> res = new ArrayList<>();

        for (String key : buddies.keySet()) {
            // count common cities
            int count = 0;
            Set<String> cities = buddies.get(key);

            for (String city : list) {
                if (cities.contains(city)) {
                    count++;
                }
            }

            // check if common cities > 50%
            if (count >= list.size() / 2) {
                res.add(new Buddy(key, cities, count));
            }
        }

        // sort based on similarity
        Collections.sort(res, (a, b) -> b.sim - a.sim);
        return res;
    }

    public List<String> recommendKCities(Set<String> list, Map<String, Set<String>> buddies, int k) {
        // get sorted buddy list
        List<Buddy> buddiesList = getBuddyList(list, buddies);

        // find top K
        Set<String> res = new LinkedHashSet<>();
        for (Buddy buddy : buddiesList) {
            Set<String> cities = buddy.cities;
            System.out.println(buddy.name);
            // find cities in buddy but not in my list
            for (String city : cities) {
                if (!list.contains(city) && !res.contains(city)) {
                    res.add(city);

                    // check
                    if (res.size() == k) {
                        return new ArrayList<>(res);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        TravelBuddy test = new TravelBuddy();

        Set<String> myList = new HashSet<>(Arrays.asList("A", "B", "C", "D"));

        Set<String> peter = new HashSet<>(Arrays.asList("A", "B", "E", "F"));
        Set<String> john = new HashSet<>(Arrays.asList("A", "B", "D", "G"));
        Set<String> casy = new HashSet<>(Arrays.asList("X", "B", "A", "D", "Q"));
        Set<String> jason = new HashSet<>(Arrays.asList("A", "B", "C", "D", "P", "Q"));
        Set<String> ken = new HashSet<>(Arrays.asList("A", "X", "Y", "Z"));

        Map<String, Set<String>> friendLists = new HashMap<>();
        friendLists.put("peter", peter);
        friendLists.put("john", john);
        friendLists.put("casy", casy);
        friendLists.put("jason", jason);
        friendLists.put("ken", ken);

        List<Buddy> buddiesList = test.getBuddyList(myList, friendLists);
        for (Buddy buddy : buddiesList) {
            System.out.println(buddy.name);
        }

        List<String> cities = test.recommendKCities(myList, friendLists, 5);
        System.out.println(cities);
    }
}
