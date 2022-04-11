package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class f
{
  private final HashMap<String, c> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).e();
    }
    this.a.clear();
  }
  
  final c b(String paramString)
  {
    return (c)this.a.get(paramString);
  }
  
  final void c(String paramString, c paramc)
  {
    this.a.put(paramString, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\kb\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */