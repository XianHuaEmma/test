package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MyListNodeTwo {
    int size;
    ListNode head;  // sentinel node as pseudo-head
    public MyListNodeTwo (){
        size = 0;
        head = new ListNode(0);
    }
    public int get(int index) {
        if(index>=0&&index<size){
            ListNode cur = head;
            for (int i = 0; i <= index ; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0){
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
            size++;
        } else if(index<=size){
            ListNode cur = head;
            for (int i = 0; i < index ; i++) {
                cur = cur.next;
            }
            ListNode temp = new ListNode(val);
            temp.next = cur.next;
            cur.next = temp;
            size++;

        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=0&&index<=size-1){
            ListNode cur = head;
            for (int i = 0; i < index ; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }


}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
