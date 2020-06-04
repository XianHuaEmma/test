package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class LianBiaoJiaMi {
    public ListNode jiaMi(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int length = 0;
        int valk = 0;
        int after = 0;
        while (cur != null) {
            length++;
            if (length == k) {
                valk = cur.val;
            }
            cur = cur.next;

        }
        cur = head;
        int endIndex = length - k;
        length = 0;
        while (cur != null) {
            length++;
            if (length == endIndex + 1) {
                after = cur.val;
            }
            cur = cur.next;
        }
        for (int i = 0; i < length; i++) {
            if(i==k-1){
                head.val = after;
            }
            if(i==endIndex){
                head.val = valk;
            }
            head = head.next;
        }

        return dummy.next;
    }
}

