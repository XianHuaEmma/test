package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Test {
    public static void main(String[] args) {
//        MyLinkedList my = new MyLinkedList();
//        MyListNodeTwo my = new MyListNodeTwo();
////        my.addAtHead(1);
////        my.addAtTail(3);
////        my.addAtIndex(1,2);
////        System.out.println(my.get(1));
////        my.deleteAtIndex(1);
////        System.out.println(my.get(1));
        MyHashMap my = new MyHashMap();
        my.put(1,2);
        my.put(2,2);
        System.out.println(my.get(1));
        System.out.println(my.get(3));
        my.put(2,1);
        System.out.println(my.get(2));
        my.remove(2);
        System.out.println(my.get(2));
    }
}
