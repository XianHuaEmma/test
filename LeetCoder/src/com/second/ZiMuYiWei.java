package com.second;

import java.awt.image.PixelInterleavedSampleModel;
import java.util.Arrays;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class ZiMuYiWei {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        char [] sarr = s.toCharArray();
        char [] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.toString(sarr).equals(Arrays.toString(tarr));
    }
}
