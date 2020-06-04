package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class KuoHaoYouXiao {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
    }
    public static  boolean checkValidString(String s) {
        int l = 0;
        for (char c:s.toCharArray()) {
            if (c != ')') {
                l++;
            } else if(l--==0){
                return false;
            }
        }
        if(l==0){
            return true;
        }
        int r = 0;
        for (int i =s.length()-1; i >=0 ; i--) {
            char c = s.charAt(i);
            if(c!='('){
                r++;
            } else if(r--==0){
                return false;
            }
        }
        return true;
    }


}
