// source: https://www.udemy.com/parallel-dotnet/learn/v4/content

using System;
using System.Runtime.InteropServices;
using System.Security.Cryptography;
using System.Threading;
using System.Threading.Tasks;

namespace IntroducingTasks
{
    class ExceptionHandling
    {
        public static void Main()
        {
            //Test();
            try
            {
                Test();
            }
            catch (AggregateException ae)
            {
                foreach (Exception e in ae.InnerExceptions)
                {
                    Console.WriteLine($"Exception {e.GetType()} from {e.Source}.");
                }
            }
            Console.WriteLine("Main program done.");
            Console.ReadKey();
        }

        public static void Test()
        {
            var t1 = Task.Factory.StartNew(() =>
            {
                throw new InvalidOperationException("Can't do this!") { Source = "t1" };
            });

            var t2 = Task.Factory.StartNew(() =>
            {
                var e = new AccessViolationException("Can't access this!");
                e.Source = "t2";
                throw e;
            });

            try
            {
                Task.WaitAll(t1, t2);
            }
            catch (AggregateException ae)
            {
                ae.Handle(e =>
                {
                    if (e is InvalidOperationException)
                    {
                        Console.WriteLine("Invalid Operation!");
                        return true;
                    }
                    else
                        return false;
                });
            }
        }
    }
}
