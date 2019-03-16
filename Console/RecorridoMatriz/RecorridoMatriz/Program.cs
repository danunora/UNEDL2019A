using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RecorridoMatriz
{
    class Program
    {
        static void Main(string[] args)
        {
            // JAVA
            //int[][] matriz ={{1,3,5,7},
            //                 {4,7,9,7},
            //                 {2,6,8,0},
            //                 {2,4,5,2}};

            // CSHARP
            int[,] myarray = new int [4,5] {{1,3,5,7,6},
                                            {4,7,9,7,8},
                                            {2,6,8,0,3},
                                            {2,4,5,2,0}};

            Console.WriteLine("Array 0: " + myarray.GetLength(0));
            Console.WriteLine("Array 1: " + myarray.GetLength(1));
            int temp = myarray.GetLength(0);
            temp = temp - 1;
            // Array 1: 5
            for (int j = 0; j < myarray.GetLength(1); j++)
            {   // Array 0: 4
                for (int i = 0; i < myarray.GetLength(0); i++)
                {
                    if (j % 2 == 0)
                    {
                        Console.WriteLine("Valor Par: " + myarray[i, j]);
                    }
                    else
                    {
                        Console.WriteLine("Valor InP: " + myarray[temp - i, j]);
                    }
                    
                }
                
            }
            
        }
    }
}
