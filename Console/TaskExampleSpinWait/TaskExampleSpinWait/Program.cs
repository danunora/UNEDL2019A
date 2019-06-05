// source: https://www.dotnetperls.com/spinwait

using System;
using System.Diagnostics;
using System.Threading;

class Program
{
    static void Main()
    {
        Stopwatch stopwatch = Stopwatch.StartNew();
        // CPU is maxed out during this call.
        // ... (Try making it much larger to test.)
        Thread.SpinWait(1000000000);
        Console.WriteLine(stopwatch.Elapsed.TotalMilliseconds);
    }
}
