package com.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MyHashMap {
    List<Integer> keyList ;
    List<Integer>valueList;
    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(keyList.contains(key)){
            int index = keyList.indexOf(key);
            valueList.set(index,value);
            return;
        }
        keyList.add(key);
        valueList.add(value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = keyList.indexOf(key);
        if(index>=0){
            return valueList.get(index);
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(keyList.contains(key)){
            int index = keyList.indexOf(key);
            keyList.remove(index);
            valueList.remove(index);
        }

    }
}
