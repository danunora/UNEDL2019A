using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strings2doParcial
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] cadenas = { "(){})({()}", "{(){((())}", "{({()()}})", "{()()}{()}", "({){}({()}" };
            foreach (String cadena in cadenas)
            {
                char[] caracteres = cadena.ToCharArray();
                Stack pila = new Stack();
                try
                {
                    for (int i = 0; i < cadena.Length; i++)
                    {
                        switch (caracteres[i])
                        {
                            case '(':
                                pila.Push(caracteres[i]);
                                break;
                            case '{':
                                pila.Push(caracteres[i]);
                                break;
                            case ')':
                                if (pila.Count != 0)
                                {
                                    var c = (char)pila.Pop();
                                    if (c != '(')
                                        throw (new InvalidOperationException(cadena + ": A round parenthesis is missing: "+ i));
                                    break;
                                }
                                else
                                {
                                    throw (new InvalidOperationException(cadena + ": A round parenthesis is missing: " + i));
                                }
                            case '}':
                                if (pila.Count != 0)
                                {
                                    var d = (char)pila.Pop();
                                    if (d != '{')
                                        throw (new InvalidOperationException(cadena + ": A curly parenthesis is missing: " + i));
                                    break;
                                }
                                else
                                {
                                    throw (new InvalidOperationException(cadena + ": A curly parenthesis is missing: " + i));
                                }
                        }
                        //Console.WriteLine("Posicion: {0}", i);
                        //Console.WriteLine("Pila: {0}", pila.Count);
                    }
                    if (pila.Count != 0)
                    {
                        throw (new InvalidOperationException(cadena + ": String contains errors"));
                    }
                    Console.WriteLine(cadena + ": is correct");
                }
                catch (InvalidOperationException e)
                {
                    Console.WriteLine(e. Message);
                }
            }
        }
    }
}