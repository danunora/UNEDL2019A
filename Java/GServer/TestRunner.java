
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    
   public static void main(String[] args) {
      myTest test = new myTest();
      test.givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect();
       
//       Result result = JUnitCore.runClasses(myTest.class);
//
//      for (Failure failure : result.getFailures()) {
//         System.out.println(failure.toString());
//      }
//
//      System.out.println(result.wasSuccessful());
   }
}
