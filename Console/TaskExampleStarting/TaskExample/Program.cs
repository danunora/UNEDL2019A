// source: https://www.udemy.com/parallel-dotnet/learn/v4/content

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskExample
{
    class Program
    {
        // initial Write method
        public static void Write(char c)
        {
            int i = 1000;
            while(i --> 0)
            {
                Console.Write(c);
            }
        }
        
        // overloading Write
        public static void Write(object o)
        {
            int i = 1000;
            while (i-- > 0)
            {
                Console.Write(o);
            }
        }

        public static int TextLength(object o)
        {
            Console.WriteLine($"\nTask with id {Task.CurrentId} processing object {o}...");
            return o.ToString().Length;
        }

        public static void Test1()
        {
            // Test 1 using Write (char)
            Task.Factory.StartNew(() => Write('.'));
            var t1 = new Task(() => Write('?'));
            t1.Start();
            Write('-');
        }

        public static void Test2()
        {
            // Test 2 using Write (object)
            var t2 = new Task(Write, "hello");
            t2.Start();
            Task.Factory.StartNew(Write, 123);
        }

        static void Main(string[] args)
        {
            //Test1();
            //Test2();            
            // Test 3
            
            string text1 = "testing", text2 = "this";
            var task1 = new Task<int>(TextLength, text1);
            task1.Start();

            Task<int> task2 = Task.Factory.StartNew<int>(TextLength, text2);

            Console.WriteLine($"\nLenght of '{text1}' is {task1.Result}");
            Console.WriteLine($"Lenght of '{text2}' is {task2.Result}");
            
            Console.WriteLine("Main program done");
            Console.ReadKey();
        }
    }
}