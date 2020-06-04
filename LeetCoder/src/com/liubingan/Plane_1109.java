package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Plane_1109 {
    public static void main(String[] args) {
        int [][]bookes={{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        System.out.println(corpFlightBookings(bookes,5));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int []res = new int[n];
        for(int[]book:bookings){
            res[book[0]-1] +=book[2];
            if(book[1]<n){
                res[book[1]] +=-book[2];
            }

        }
        for(int i=1;i<n;i++){
            res[i] += res[i-1];
        }
        return res;
    }
}
