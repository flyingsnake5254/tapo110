package b.d.c.a.m;

import android.os.CountDownTimer;
import b.d.c.c.d;
import b.d.c.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends CountDownTimer
  implements d
{
  private final List<e> a = new ArrayList();
  
  public a(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void a()
  {
    start();
  }
  
  public void b(e parame)
  {
    if (parame != null) {
      synchronized (this.a)
      {
        this.a.add(parame);
      }
    }
  }
  
  public void c()
  {
    cancel();
  }
  
  public void d(e parame)
  {
    if (parame != null) {
      synchronized (this.a)
      {
        this.a.remove(parame);
      }
    }
  }
  
  public void e()
  {
    cancel();
    start();
  }
  
  public void onFinish()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale != null) {
        locale.a();
      }
    }
    a();
  }
  
  public void onTick(long paramLong) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */