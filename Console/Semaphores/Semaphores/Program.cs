// source: http://www.tutorialspoint.com/Semaphore-in-Chash

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Semaphores
{
    class Program
    {
        const int VEINTE = 20;
        static Thread[] myThread = new Thread[VEINTE];

        // initial count, maximum count
        static Semaphore semaphore = new Semaphore(2, 2);

        // To simulate some activity
        static void DoSomething()
        {
            Console.WriteLine("{0} = waiting", Thread.CurrentThread.Name);
            semaphore.WaitOne();
            Console.WriteLine("{0} begins!", Thread.CurrentThread.Name);
            Thread.Sleep(1000);
            Console.WriteLine("{0} releasing...", Thread.CurrentThread.Name);
            semaphore.Release();
        }

        static void Main(string[] args)
        {
            for (int j = 0; j < VEINTE; j++)
            {
                myThread[j] = new Thread(DoSomething);
                myThread[j].Name = "thread number " + j;
                myThread[j].Start();
            }
            Console.Read();
        }
    }
}
