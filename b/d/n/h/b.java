package b.d.n.h;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b
  implements Executor
{
  private static Executor c;
  private final ExecutorService d = Executors.newFixedThreadPool(2);
  
  public static Executor a()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          b localb = new b/d/n/h/b;
          localb.<init>();
          c = localb;
        }
      }
      finally {}
    }
    return c;
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.d.execute(paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */