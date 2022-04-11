package com.google.gson.internal.k;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;

public abstract class b
{
  private static final b a;
  
  static
  {
    Object localObject;
    if (d.c() < 9) {
      localObject = new a();
    } else {
      localObject = new c();
    }
    a = (b)localObject;
  }
  
  public static b a()
  {
    return a;
  }
  
  public abstract void b(AccessibleObject paramAccessibleObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */