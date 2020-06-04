package com.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 1030
 * @描述：
 */
public class JuZhenJuLi {

    private  List<int[]>res = new ArrayList<>();

    public static void main(String[] args) {
        JuZhenJuLi li = new JuZhenJuLi();
        System.out.println(li.allCellsDistOrder(2,3,1,2));
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int [][]value = new int[R][C];
        value[r0][c0] = 1;
        List<position>list = new ArrayList<>();
        res.add(new int[]{r0,c0});
        list.add(new position(r0,c0));
        getNearest(list,value);
        return res.toArray(new int[list.size()][]);
    }
    private void getNearest(List<position>list,int[][]value){
        List<position>temp = new ArrayList<>();
        for(position cur:list){
            if(cur.row>0&&value[cur.row-1][cur.col]==0){
                value[cur.row-1][cur.col]=1;
                temp.add(new position(cur.row-1,cur.col));
                res.add(new int[]{cur.row-1,cur.col});
            }
            if(cur.row<value.length-1&&value[cur.row+1][cur.col]==0){
                value[cur.row+1][cur.col]=1;
                temp.add(new position(cur.row+1,cur.col));
                res.add(new int[]{cur.row+1,cur.col});
            }
            if(cur.col>0&&value[cur.row][cur.col-1]==0){
                value[cur.row][cur.col-1]=1;
                temp.add(new position(cur.row,cur.col-1));
                res.add(new int[]{cur.row,cur.col-1});
            }
            if(cur.col<value[0].length-1&&value[cur.row][cur.col+1]==0){
                value[cur.row][cur.col+1]=1;
                temp.add(new position(cur.row,cur.col+1));
                res.add(new int[]{cur.row,cur.col+1});
            }
        }
        if(temp.size()==0){
            return ;
        }
        getNearest(temp,value);
    }
}

