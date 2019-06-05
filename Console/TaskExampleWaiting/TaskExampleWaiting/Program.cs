// source: https://www.udemy.com/parallel-dotnet/learn/v4/content
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace TaskExampleWaiting
{
    class Program
    {
        static void Main(string[] args)
        {
            var cts = new CancellationTokenSource();
            var token = cts.Token;
            Task t1 = new Task(() =>
            {
                Console.WriteLine("You have 5 seconds");
                for (int i = 0; i < 5; i++)
                {
                    token.ThrowIfCancellationRequested();
                    Thread.Sleep(1000);
                }                
                Console.WriteLine("t1 is done");
            }, token);
            t1.Start();

            Task t2 = Task.Factory.StartNew(() => Thread.Sleep(3000), token);

            Task.WaitAll(new[] { t1, t2 }, 4000, token);

            Console.WriteLine($"Status Task t1: {t1.Status}");
            Console.WriteLine($"Status Task t2: {t2.Status}");

            Console.WriteLine("Main program done.");
            Console.ReadKey();
        }
    }
}
