package com.example.check;
import java.util.Scanner;
public class Check_even_odd {
    public static String check_even_odd(double num) {
        if (num < 0){
            return "neither even nor odd";
        }
        if (num%2==0){
            return "even";
        }
        else if(num%2 ==1){
            return "odd";
        }
        else{
            return "neither even nor odd";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        System.out.println(check_even_odd(weight));
    }
}
