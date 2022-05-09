package com.example.min_max;

import java.security.PublicKey;

public class MIN_MAX {
    public static double max(double arr[]) {
        double max=arr[0];
        for(int i=0;i< arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static double min(double arr[]) {
        double min=arr[0];
        for(int i=0;i< arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        double arr[] = {11, 22, 0,33,44, 55, 66, 77, 88, 99, 100};
        double max=max(arr);
        double min=min(arr);
        System.out.println(max);
        System.out.println(min);

    }
}
