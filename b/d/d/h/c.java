package b.d.d.h;

import java.math.BigDecimal;

public class c
  implements Runnable
{
  private final b[] c = new b[1];
  private final Thread d;
  private int f = 0;
  
  public c()
  {
    Thread localThread = new Thread(this);
    this.d = localThread;
    localThread.start();
  }
  
  public void a(int paramInt)
  {
    this.f += paramInt;
  }
  
  public void b()
  {
    this.d.interrupt();
    this.c[0] = null;
  }
  
  public void c(b paramb)
  {
    this.c[0] = paramb;
  }
  
  public void run()
  {
    int i = 0;
    while (!this.d.isInterrupted())
    {
      int j = i;
      try
      {
        Thread.sleep(1000L);
        j = i;
        float f1 = BigDecimal.valueOf((this.f - i) / 1024.0F).setScale(1, 4).floatValue();
        j = i;
        int k = this.f;
        j = k;
        b localb = this.c[0];
        i = k;
        if (localb != null)
        {
          j = k;
          localb.g(f1);
          i = k;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        i = j;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */