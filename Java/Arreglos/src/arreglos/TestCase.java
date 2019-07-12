/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class TestCase {

public static void test(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Array size: ");
    int n = scan.nextInt();
    System.out.println("Queries: ");
    int m = scan.nextInt();
        
// This will be the "difference array". 
// The entry arr[i]=k indicates that arr[i] 
// is exactly k units larger than arr[i-1]
    long[] arr = new long[n];
        
    int lower;
    int upper;
    long sum;

    for(int i=0; i<n; i++) {
        arr[i]=0;
    }

    for(int i=0;i<m;i++){
        System.out.println("lower: ");
        lower=scan.nextInt();
        System.out.println("upper: ");
        upper=scan.nextInt();
        System.out.println("sum: ");
        sum=scan.nextInt();
        arr[lower-1]+=sum;
        if(upper<n) {
            arr[upper]-=sum;
        } 
    }
        
    long max=0;
    long temp=0;

    for(int i=0;i<n;i++){
        temp += arr[i];
        if(temp> max) max=temp;
    }

    System.out.println(max);
    }   
}
