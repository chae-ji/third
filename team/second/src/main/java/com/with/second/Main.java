package com.with.second;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i = 0;
        int x = a;


        while(true){

            a = ((a % 10) * 10) + (((a / 10) + (a % 10)) % 10);

                i = i + 1;

                if(x == a){
                    break;
                }

        }
        System.out.println(i);
    }
}

/*
a = 1;
b = 10/10 + 10%10 = 1;
c = 11
 */