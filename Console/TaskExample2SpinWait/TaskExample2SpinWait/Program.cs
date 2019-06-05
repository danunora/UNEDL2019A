// source: https://www.udemy.com/parallel-dotnet/learn/v4/content
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace TaskExample2SpinWait
{
    class Program
    {
        static void Main(string[] args)
        {
            const int MILISECONDS = 5000;
            var cts = new CancellationTokenSource();
            var token = cts.Token;
            Task t = new Task(() =>
            {
                Console.WriteLine("Press any key to disarm; you have {0} seconds", MILISECONDS/1000);
                bool cancelled = token.WaitHandle.WaitOne(MILISECONDS);
                Console.WriteLine(cancelled? "Bomb disarmed" : "BOOM !!!");
            }, token);
            t.Start();
            // don't forget CancellationToken.None
            Console.ReadKey();
            cts.Cancel();
            Console.WriteLine("Main program done.");
            Console.ReadKey();
        }
    }
}
