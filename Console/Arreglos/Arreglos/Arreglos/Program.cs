using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution
{

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a)
    {
        int[] reverso = new int[a.Length];
        int j = 0;
        for (var i = a.Length - 1; i >= 0; i--)
        {
            reverso[j] = a[i];
            j++;
        }
        return reverso;
    }

    /**
 * Shift Left
 * 1,2,3,4,5 => 1 left rotation  => 2,3,4,5,1
 * 1,2,3,4,5 => 2 left rotations => 3,4,5,1,2
 */
    public static int[] shiftleft(int shifts, int[] arreglo)
    {
        int[] shiftleft = new int[arreglo.Length];
        int j = 0;
        if (shifts != 0)
        {
            for (var i = shifts; i < arreglo.Length; i++)
            {
                shiftleft[j] = arreglo[i];
                j++;
            }
            Console.WriteLine("test");
            int k = arreglo.Length - j;
            for (var i = 0; i < k; i++)
            {
                shiftleft[j] = arreglo[i];
                j++;
            }
            return shiftleft;
        }
        else
        {
            return arreglo;
        }
    }

    static void Main(string[] args)
    {
        //        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);
        TextWriter textWriter = new StreamWriter(@"C:\Users\root\file.txt", true);

        Console.WriteLine("Array size:");
        int arrCount = Convert.ToInt32(Console.ReadLine());

        Console.WriteLine("Numbers:");
        int[] arr = Array.ConvertAll(Console.ReadLine().Split(' '), 
            arrTemp => Convert.ToInt32(arrTemp));

        //int[] res = reverseArray(arr);

        int[] res = shiftleft(2,arr);

        Console.WriteLine(string.Join(" ", res));
        textWriter.WriteLine(string.Join(" ", res));

        textWriter.Flush();
        textWriter.Close();
    }
}