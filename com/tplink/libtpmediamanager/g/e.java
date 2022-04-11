package com.tplink.libtpmediamanager.g;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class e
{
  private final HashMap<String, b> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onCleared();
    }
    this.a.clear();
  }
  
  final b b(String paramString)
  {
    return (b)this.a.get(paramString);
  }
  
  final void c(String paramString, b paramb)
  {
    this.a.put(paramString, paramb);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */