using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UsingTasks
{
    class Program
    {

        public static void WriteChar(char c)
        {
            int i = 10000;
            while (i-- > 0)
            {
                Console.Write(c);
            }
        }

        public static void WriteObject(object ob)
        {
            int i = 1000;
            while (i --> 0)
            {
                Console.Write(ob);
            }
        }

        static void Main(string[] args)
        {
            //WriteChar('.');
            //WriteChar('-');
            //Task.Factory.StartNew(() => WriteChar('.'));
            //Task tarea = new Task(() => WriteChar('?'));
            //tarea.Start();
            //Task.Factory.StartNew(() => Escribe('$'));

            Task.Factory.StartNew(WriteObject, "Hello");
            Task tarea = new Task(WriteObject, 1234);
            tarea.Start();

            Console.WriteLine("Main done");
            Console.ReadKey();
        }
    }
}
