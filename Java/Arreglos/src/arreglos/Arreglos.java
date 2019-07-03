/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.Stack;

/**
 *
 * @author root
 */
public class Arreglos {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Balance the parenthesis
     */
    public static void sparceArrays() {
//        String[] cadenas = {"aba", "baba", "aba","xzxb"};
//        String[] queries = {"aba", "xzxb", "ab"};
        String[] cadenas = {"def", "de","fgh"};
        String[] queries = {"de","lmn","fgh"};
        int[] matching = new int[queries.length];
        int i = 0;
        int j = 0;
        for (String query : queries) {
            for (String cadena : cadenas ){
                if (query.equals(cadena)){
                   matching[i] = ++j; 
                }
            }
            j = 0;
            i++;
        }
        for (i = 0; i < matching.length; i++){
            System.out.println("matching: " + matching[i]);
        }
    }

    /**
     * Balance the parenthesis
     */
    public static void Balance() {
        String[] cadenas = {"(){})({()}", "{(){((())}", "{({()()}})",
            "{()()}{()}", "({){}({()}"};
        for (String cadena : cadenas) {
            char[] caracteres = cadena.toCharArray();
            Stack pila = new Stack();
            try {
                for (int i = 0; i < cadena.length(); i++) {
                    switch (caracteres[i]) {
                        case '(':
                            pila.push(caracteres[i]);
                            break;
                        case '{':
                            pila.push(caracteres[i]);
                            break;
                        case '[':
                            pila.push(caracteres[i]);
                            break;
                        case ')':
                            if (!pila.isEmpty()) {
                                char c = (char) pila.pop();
                                if (c != '(') {
                                    throw new Exception(cadena
                                            + " : A () parentesis is missing");
                                }
                                break;
                            } else {
                                throw new Exception(cadena
                                        + " : A () parentesis is missing");
                            }
                        case '}':
                            if (!pila.isEmpty()) {
                                char c = (char) pila.pop();
                                if (c != '{') {
                                    throw new Exception(cadena
                                            + " : A {} parentesis is missing");
                                }
                                break;
                            } else {
                                throw new Exception(cadena
                                        + " : A {} parentesis is missing");
                            }
                        case ']':
                            if (!pila.isEmpty()) {
                                char c = (char) pila.pop();
                                if (c != '[') {
                                    throw new Exception(cadena
                                            + " : A [] parentesis is missing");
                                }
                                break;
                            } else {
                                throw new Exception(cadena
                                        + " : A [] parentesis is missing");
                            }
                    }
                }
                if (!pila.isEmpty()) {
                    throw new Exception(cadena + " : contains errors");
                }
                System.out.println(cadena + ": is correct");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Sort an array of zeros and ones
     * @param arreglo
     * @return 
     */
    public static void zeroSort(){
        int[] arreglo = new int[] {0,0,1,1,0,1};
        int[] sorted = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == 0){
                sorted[i] = arreglo[i];
            }else if (arreglo[i] == 1){
                sorted[arreglo.length - i -1] = arreglo[i];
            } else{
                System.out.println("Invalid element");
                break;
            }
        }
        for (int i = 0; i < sorted.length; i++){
            System.out.println("Sorted: " + sorted[i]);
        }        
    }

    /**
     * Simple Array Sum
     *
     * @param arreglo
     * @return
     */
    public static int simpleArraySum(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma = suma + arreglo[i];
        }
        return suma;
    }
    
    /**
     * Return the major element of an array
     * @param ar
     * @return mayor
     */
    public static long mayor(long[] ar){
        long mayor = 0;
        for (int i = 0; i < ar.length; i++){
            if(ar[i] > mayor){
                mayor = ar[i];
            }
        }
        return mayor;
    }
    
    /**
     * 
     * @return 
     */
    public static void arrayManipulation() {
        int n = 10;
//        int[][] queries = {{1,5,3},{4,8,7},{6,9,1}};
//        int[][] queries = {{1,2,100},{2,5,100},{3,4,100}};
        int[][] queries = {{2,6,8},{3,5,7},{1,8,1},{5,9,15}};
        long[] arreglo = new long[n + 2];
//        System.out.println("Queries: " + queries.length);
        for (int i = 0; i < queries.length; i++){            
            int low = queries[i][0];
            int upe = queries[i][1];
            int sum = queries[i][2];
            arreglo[low] += sum;
            arreglo[upe+1] -= sum;
//            System.out.println("low: " + low);
//            System.out.println("upe: " + upe);
//            System.out.println("sum: " + sum);
// Brute Force
//            for (int j = low-1; j <= upe-1; j++){                
//                arreglo[j] += sum;
//                System.out.println("j: " + j);
//                System.out.println("arreglo[j]:" + arreglo[j]);
//            }
        }
        long mayor = Long.MIN_VALUE;
        long sum = 0;        
        for (int i = 0; i < arreglo.length; i++){
// Prefix Sum algorithm            
            sum += arreglo[i];
            mayor = Math.max(mayor, sum);
//                System.out.println("Mayor: " + mayor); 
        }
//        return mayor;
        System.out.println("Mayor: "+ mayor);
    }
    
    /**
     * 
     */
    public static void arrayExercise(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Array size: ");
        int arraysize = scan.nextInt();
        System.out.println("Queries: ");
        int queries = scan.nextInt();
        
        long[] arreglo = new long[arraysize];
        long mayor = 0;
        int lower = 0 ;
        int upper = 0;
        long sum = 0;

        for (int i = 0; i < queries; i++){
            System.out.println("lower: ");
            lower=scan.nextInt();
            System.out.println("upper: ");
            upper=scan.nextInt();
            System.out.println("sum: ");
            sum=scan.nextInt();
            arreglo[lower-1] += sum;
            if(upper < arraysize){
                arreglo[upper]-=sum;
            }
        }
        for (int i = 0; i < arreglo.length; i++){
            if(arreglo[i] > mayor){
                mayor = arreglo[i];
            }
        }
        System.out.println("Mayor: " + mayor);        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("Array Size: ");
//        int arCount = Integer.parseInt(scanner.nextLine().trim());
//        int[] ar = new int[arCount];
//        System.out.println("Array Elements: ");
//        String[] arItems = scanner.nextLine().split(" ");
//        for (int arItr = 0; arItr < arCount; arItr++) {
//            int arItem = Integer.parseInt(arItems[arItr].trim());
//            ar[arItr] = arItem;
//        }
//        
//        int result = simpleArraySum(ar);
//        System.out.println("Result: " + result);
//        Balance();
//          zeroSort();
          //sparceArrays();
          //int[] test = new int[]{1,6,3,4,5};
          //System.out.println("mayor: " + mayor(test));
          //arrayExercise();
          //TestCase tc = new TestCase();
          //tc.test();
          arrayManipulation();
    }
}
