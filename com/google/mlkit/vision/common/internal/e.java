package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public class e
{
  private final Map<Class<?>, Provider<?>> a = new HashMap();
  
  e(Set<a> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      a locala = (a)paramSet.next();
      this.a.put(locala.a(), locala.b());
    }
  }
  
  @KeepForSdk
  public static class a
  {
    private final Class<?> a;
    private final Provider<?> b;
    
    final Class<?> a()
    {
      return this.a;
    }
    
    final Provider<?> b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */