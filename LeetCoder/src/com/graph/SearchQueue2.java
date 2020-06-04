package com.graph;

import java.util.*;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class SearchQueue2 {
    //使用Map装载
    static String[] graphName = {"you", "alice", "bob", "claire", "anuj", "peggy", "thom", "jonny"};
    //    static String[][] graph = {
//            {"you", "alice"},
//            {"you", "bob"},
//            {"you", "claire"},
//            {"bob", "anuj"},
//            {"bob", "peggy"},
//            {"alice", "peggy"},
//            {"claire", "thom"},
//            {"claire", "jonny"},
//
//    };
    static Map<String, List<String>> graph = new HashMap<>();

    private static void addGraph() {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
    }

    public static boolean Search(String name) {
        addGraph();
        Queue<String> searchQueue = new LinkedList<>();
        Queue<String> searched = new LinkedList<>();
        for (int i = 0; i < graphName.length; i++)
            searchQueue.add(graphName[i]);

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    if (graph.get(person) != null) {
                        List<String> list = graph.get(person);
                        for (String temp : list) {
                            searchQueue.add(temp);
                        }
                    }
                    searched.add(person);
                }
            }
        }
        return false;
    }

    public static boolean personIsSeller(String name) {
        return name.charAt(name.length() - 1) == 'm';
    }

    public static void main(String[] args) {
        System.out.println(Search("you"));
    }
}
