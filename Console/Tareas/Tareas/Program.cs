using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tareas
{
    class Program
    {
        static void Main(string[] args)
        {

            // Paso 1
            //Escribe("Uno");
            //Escribe("Tres");
            //Escribe("Dos");

            // Paso 2
            //Task.Factory.StartNew(() => Escribe("Uno"));
            //Task.Factory.StartNew(() => Escribe("Dos"));
            //Task.Factory.StartNew(() => Escribe("Tres"));

            //// Paso 3
            Task[] tasks = new Task[2];
            tasks[0] = Task.Factory.StartNew(() => Escribe("Uno"));
            tasks[1] = Task.Factory.StartNew(() => Escribe("Dos"));
            Task.Factory.ContinueWhenAll(tasks,
                completedTasks => { Task.Factory.StartNew(() => Escribe("Tres")); });

            Console.WriteLine("Main");
            Console.ReadKey();
        }

        public static void Escribe(String c)
        {
            int i = 1;
            while( i < 100)
            {
                Console.WriteLine(c);
                i++;
            }
        }

    }
}
