/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockmerchant;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 * @author root
 */
public class SockMerchant {

    private static final Scanner scanner = new Scanner(System.in);
    
    // Complete the sockMerchant function below.
    // It must return an integer representing the number 
    // of matching pairs of socks that are available.
    public static int sockMerchant(int n, int[] ar) {
        HashMap mapa = new HashMap();
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            String c = Integer.toString(ar[i]);
            if (!mapa.isEmpty()){
               if (mapa.containsKey(c)){
                   temp = (int)mapa.get(c);
                   temp++;
                   mapa.replace(c,temp);                   
               }else{
                   mapa.put(c,1);
               }
            }else{
                mapa.put(c,1);
            }
        }
        Set set = mapa.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
//            System.out.println("Key: " + me.getKey().toString());
//            System.out.println("Val: " + me.getValue());
            temp = (int)me.getValue() / 2; 
            if( temp != 0){
                counter = counter + temp;
            }
        }
        return counter;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedWriter bufferedWriter = 
                new BufferedWriter(new FileWriter("C:\\Users\\root\\socks.txt"));

        System.out.println("The number of socks in the pile:");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        System.out.println("the colors (number representing) of each sock:");
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        //int result = sockMerchant(n, ar);
        int result = sockMerchant(n, ar);

        System.out.println("Pares:" + result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}