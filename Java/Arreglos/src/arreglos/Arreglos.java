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
          zeroSort();        
    }
}
