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
    public static int[] shiftleft(int arrsize, int shifts, int[] arreglo)
    {
        int[] shiftleft = new int[arrsize];
        int j = 0;
        if (shifts != 0)
        {
            for (var i = shifts; i < arrsize; i++)
            {
                shiftleft[j] = arreglo[i];
                j++;
            }
            int k = arrsize - j;
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

    /*
     * Main
     * 
     */
    static void Main(string[] args)
    {
        Console.WriteLine("arraySize shifts2left ");
        string[] nd = Console.ReadLine().Split(' ');

        int n = Convert.ToInt32(nd[0]);
        Console.WriteLine("Array Size: " + n);

        int d = Convert.ToInt32(nd[1]);
        Console.WriteLine("Shifts to the left: " + d);

        Console.WriteLine("Elements:");
        int[] a = Array.ConvertAll(Console.ReadLine().Split(' '), 
            aTemp => Convert.ToInt32(aTemp));

        int[] res = shiftleft(n, d, a);

        Console.WriteLine(string.Join(" ", res));


    }
}
