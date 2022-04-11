package com.tplink.iot.Utils.v0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static b a;
  private List<a> b = new ArrayList();
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          b localb = new com/tplink/iot/Utils/v0/b;
          localb.<init>();
          a = localb;
        }
      }
      finally {}
    }
    return a;
  }
  
  public void b()
  {
    if (this.b.isEmpty()) {
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala != null) {
        locala.D0();
      }
    }
  }
  
  public void c(a parama)
  {
    if (parama != null) {
      this.b.add(parama);
    }
  }
  
  public void d(a parama)
  {
    if (parama != null) {
      this.b.remove(parama);
    }
  }
  
  @FunctionalInterface
  public static abstract interface a
  {
    public abstract void D0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */