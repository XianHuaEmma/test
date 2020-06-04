package com.second;

/**
 * @Author：liubingan
 * @date: 779
 * @描述：
 */
public class KthGrammar {
    public static void main(String[] args) {
        KthGrammar kth = new KthGrammar();
        System.out.println(kth.kthGrammar(4,5));

    }
    public int kthGrammar(int N, int K) {
        String res = generate(N, "0");
        return res.charAt(K - 1)-'0';
    }

    private String generate(int N, String str) {
        if (N == 0) {
            return str;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                ans.append("01");
            } else {
                ans.append("10");
            }
        }
        N--;
        return generate(N, ans.toString());
    }
}
