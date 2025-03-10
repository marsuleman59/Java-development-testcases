package com.example.demo.codingchallenge2;

import java.util.List;

class Result1 {

    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY space
     */

    public static int segment(int x, List<Integer> space) {
        // Write your code here
        int size = space.size();
        int rowMax = 0;
        for(int i=0; i<size; i++) {
            int n = i + x;
            if(n == size+1) {
                break;
            }
            int cellMin = Integer.MAX_VALUE;
            for(int m=i; m<n; m++) {
                int cell = space.get(m);
                if(cell < cellMin) {
                    cellMin = cell;
                }
            }
            if(rowMax < cellMin) rowMax = cellMin;
        }
        return rowMax;
    }

}