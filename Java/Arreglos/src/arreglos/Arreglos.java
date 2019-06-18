/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

import java.util.Stack;

/**
 *
 * @author root
 */
public class Arreglos {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] cadenas = {"(){})({()}", "{(){((())}", "{({()()}})", "{()()}{()}", "({){}({()}" };
        for (String cadena : cadenas){
            char[] caracteres = cadena.toCharArray();
            Stack pila = new Stack();
            try{
                for(int i =0; i < cadena.length(); i++){
                    switch(caracteres[i]){
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
                            if(!pila.isEmpty()){
                                char c = (char)pila.pop();
                                if (c != '(')
                                    throw new Exception(cadena + " : A () parentesis is missing");                              
                                break;
                            }
                            else {
                                throw new Exception(cadena + " : A () parentesis is missing");
                            }
                        case '}':
                            if(!pila.isEmpty()){
                                char c = (char)pila.pop();
                                if (c != '{')
                                    throw new Exception(cadena + " : A {} parentesis is missing");                              
                                break;
                            }
                            else {
                                throw new Exception(cadena + " : A {} parentesis is missing");
                            }
                        case ']':
                            if(!pila.isEmpty()){
                                char c = (char)pila.pop();
                                if (c != '[')
                                    throw new Exception(cadena + " : A [] parentesis is missing");                              
                                break;
                            }
                            else {
                                throw new Exception(cadena + " : A [] parentesis is missing");
                            }
                    }
                }
                                    if(!pila.isEmpty()){
                        throw new Exception(cadena + " : contains errors");
                    }
                    System.out.println(cadena + ": is correct");

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }        
    }    
}