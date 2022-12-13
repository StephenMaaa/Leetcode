package Airbnb;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    Map<String, Integer> map;
    Map<String, Runnable> callBackMap;

    public FileSystem() {
        this.map = new HashMap<>();
        this.map.put("", 0);
        this.callBackMap = new HashMap<>();
    }

    public boolean create(String path, int val) {
        // edge case
        if (map.containsKey(path)) {
            return false;
        }

        // get relative path and create new node
        String prePath = path.substring(0, path.lastIndexOf("/"));

        // case 1: path not exists
        // case 2: exists
        if (!map.containsKey(prePath)) {
            return false;
        }
        map.put(path, val);
        return true;
    }

    public boolean set(String path, int val) {
        // edge case
        if (!map.containsKey(path)) {
            return false;
        }
        map.put(path, val);

        // trigger callback
        String curr = path;
        while (curr.length() > 0) {
            // callback
            if (callBackMap.containsKey(curr)) {
                callBackMap.get(curr).run();
            }

            curr = curr.substring(0, curr.lastIndexOf("/"));
        }
        return true;
    }

    public Integer get(String path) {
        return map.get(path);
    }

    public boolean watch(String path, String callback) {
        // edge case
        if (!map.containsKey(path)) {
            return false;
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(callback);
            }
        };
        callBackMap.put(path, runnable);
        return true;
    }

    public static void main(String[] args) {
        FileSystem solution = new FileSystem();
        solution.create("/a", 1);
        System.out.println(solution.get("/a"));
        solution.create("/a/b", 2);
        System.out.println(solution.get("/a/b"));
        solution.create("/c/d", 3);
        System.out.println(solution.get("/c"));
        solution.set("/a/b", 4);
        System.out.println(solution.get("/a/b"));
        solution.watch("/a", "/a call back triggerred");
        solution.watch("/a/b", "/a/b call back triggerred");
        solution.set("/d", 5);
        solution.create("/a/b/c", 10);
        solution.set("/a/b/c", 11);
    }
}
