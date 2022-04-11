package com.google.mlkit.common.a;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
{
  private final Map<Class<? extends a>, Provider<?>> a = new HashMap();
  
  @KeepForSdk
  public b(Set<a> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      paramSet = (a)localIterator.next();
      this.a.put(paramSet.a(), paramSet.b());
    }
  }
  
  @KeepForSdk
  public static class a
  {
    private final Class<? extends a> a;
    private final Provider<?> b;
    
    final Class<? extends a> a()
    {
      return this.a;
    }
    
    final Provider<?> b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */