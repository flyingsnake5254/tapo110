package b.d.d.m;

import b.d.d.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static b a;
  private final List<a> b = new ArrayList();
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          b localb = new b/d/d/m/b;
          localb.<init>();
          a = localb;
        }
      }
      finally {}
    }
    return a;
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramString, paramArrayOfByte, paramInt);
    }
  }
  
  public void c(a parama)
  {
    if (!this.b.contains(parama)) {
      this.b.add(parama);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\m\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */