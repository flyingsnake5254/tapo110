package b.d.d.h;

import java.math.BigDecimal;
import java.util.Arrays;

public class d
  implements Runnable
{
  private boolean c = false;
  private a d;
  private int f = 0;
  
  public d()
  {
    new Thread(this).start();
  }
  
  private int c(int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt != null)
    {
      int k;
      for (int j = 0; i < paramArrayOfInt.length; j = k)
      {
        k = j;
        if (paramArrayOfInt[i] >= 0) {
          k = j + paramArrayOfInt[i];
        }
        i++;
      }
      return j / paramArrayOfInt.length;
    }
    return 0;
  }
  
  private boolean d(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      for (int i = 0; i < paramArrayOfInt.length; i++) {
        if (paramArrayOfInt[i] < 0) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    this.f += paramInt;
  }
  
  public void b()
  {
    this.c = false;
    this.d = null;
  }
  
  public void e(a parama)
  {
    this.d = parama;
  }
  
  public void run()
  {
    int[] arrayOfInt = new int[8];
    Arrays.fill(arrayOfInt, -1);
    int i = 0;
    int j = 0;
    while (this.c)
    {
      int k = i;
      int m = j;
      try
      {
        Thread.sleep(1000L);
        k = i;
        m = j;
        Object localObject = new java/math/BigDecimal;
        k = i;
        m = j;
        ((BigDecimal)localObject).<init>(this.f - i);
        k = i;
        m = j;
        int n = ((BigDecimal)localObject).setScale(1, 4).intValue();
        k = i;
        m = j;
        int i1 = this.f;
        arrayOfInt[j] = n;
        j++;
        n = j % 8;
        i = i1;
        j = n;
        k = i1;
        m = n;
        if (d(arrayOfInt))
        {
          k = i1;
          m = n;
          int i2 = c(arrayOfInt);
          k = i1;
          m = n;
          localObject = this.d;
          i = i1;
          j = n;
          if (localObject != null)
          {
            k = i1;
            m = n;
            ((a)localObject).b(i2);
            i = i1;
            j = n;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        b();
        i = k;
        j = m;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */