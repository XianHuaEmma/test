package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class HuiwenLianBiao {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        res.append(0+"");
        res.append(0+"");
        System.out.println(res.toString().substring(0,1).equals(res.toString().substring(1,2)));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        StringBuilder ans = new StringBuilder();
        while(head!=null){
            ans.append(head.val+"");
            head = head.next;
        }
        String res = ans.toString();
        int len = res.length();
        String l ="";
        String r = "";
        if(len%2 == 0){
            l = res.substring(0,len/2+1);
            r = res.substring(len/2,len);
        } else {
            l = res.substring(0,len/2);
            r = res.substring(len/2+1,len);
        }
        if(l.equals(r)){
            return true;
        }
        return false;
    }
}
