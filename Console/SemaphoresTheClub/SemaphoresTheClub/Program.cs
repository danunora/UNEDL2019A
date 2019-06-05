// source: http://www.albahari.com/threading/part2.aspx#_Semaphore

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace SemaphoresTheClub

{
    class Program
    {
        const int PEOPLE = 7;                              // There are 7 persons waiting 
        static SemaphoreSlim _sem = new SemaphoreSlim(3);  // Capacity of 3 into the club

        static void Main()
        {
            for (int i = 1; i <= PEOPLE; i++)
            {
                new Thread(Enter).Start(i);
            }
        }

        static void Enter(object id)
        {
            Console.WriteLine(id + " wants to enter");
            _sem.Wait();
            Console.WriteLine(id + " is in!");           // Only three threads
            Thread.Sleep(1000 * (int)id);                // can be here at
            Console.WriteLine(id + " is leaving");       // a time.
            _sem.Release();
        }
    }

}
